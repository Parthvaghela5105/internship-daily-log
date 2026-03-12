package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.exception.customized.UserNotFoundException;
import com.intern.bloodmanagement.proxy.AuthRequest;
import com.intern.bloodmanagement.proxy.AuthResponse;
import com.intern.bloodmanagement.proxy.ForgetPassword;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.repository.UserRepo;
import com.intern.bloodmanagement.service.AuthService;
import com.intern.bloodmanagement.utility.JwtUtil;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUsersDetailsService myUsersDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String register(UserProxy proxy) {
        Users users = mapperHelper.map(proxy, Users.class);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepo.save(users);
        return "Register successfully";
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AuthResponse authResponse = new AuthResponse();

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if(authenticate.isAuthenticated()){
            UserDetails userDetails = myUsersDetailsService.loadUserByUsername(request.getEmail());
            String jwtToken = jwtUtil.generateToken(userDetails);
            authResponse.setEmail(request.getEmail());
            authResponse.setToken(jwtToken);
        }

        return authResponse;
    }

    @Override
    public String forgetPassword(ForgetPassword forgetPassword) {
        String email = forgetPassword.getEmail();
        Optional<Users> optUser = userRepo.findByEmail(email);
        if(optUser.isPresent()){
            Users users = optUser.get();
            users.setPassword(passwordEncoder.encode(forgetPassword.getPassword()));
            return userRepo.save(users).toString();
        }
        throw new UserNotFoundException("user not found with email "+email);
    }
}
