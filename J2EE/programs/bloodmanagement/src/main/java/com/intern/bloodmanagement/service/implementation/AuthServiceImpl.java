package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.AuthRequest;
import com.intern.bloodmanagement.proxy.AuthResponse;
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
        return userRepo.save(users).toString();
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
}
