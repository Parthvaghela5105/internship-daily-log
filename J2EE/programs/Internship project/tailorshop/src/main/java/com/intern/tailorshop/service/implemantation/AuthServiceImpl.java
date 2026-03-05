package com.intern.tailorshop.service.implemantation;

import com.intern.tailorshop.domain.UserAccount;
import com.intern.tailorshop.proxy.CreateUserRequest;
import com.intern.tailorshop.proxy.LoginRequestProxy;
import com.intern.tailorshop.proxy.LoginResponseProxy;
import com.intern.tailorshop.repository.UserAccountRepo;
import com.intern.tailorshop.service.AuthService;
import com.intern.tailorshop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String createUser(CreateUserRequest createUserRequest) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(createUserRequest.getUsername());
        userAccount.setPassword(createUserRequest.getPassword());
        userAccount.setRole(createUserRequest.getRole());

        return userAccountRepo.save(userAccount).toString();
    }

    @Override
    public LoginResponseProxy loginUser(LoginRequestProxy loginRequestProxy) {
        LoginResponseProxy loginResponseProxy = new LoginResponseProxy();

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestProxy.getUsername() , loginRequestProxy.getPassword()));

        if(authenticate.isAuthenticated()){
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequestProxy.getUsername());
            String jwtToken = jwtUtil.generateToken(userDetails);
            loginResponseProxy.setUsername(loginRequestProxy.getUsername());
            loginResponseProxy.setToken(jwtToken);
        }

        return loginResponseProxy;
    }
}
