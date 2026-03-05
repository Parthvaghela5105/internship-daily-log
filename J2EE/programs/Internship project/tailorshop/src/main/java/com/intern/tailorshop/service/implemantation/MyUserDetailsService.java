package com.intern.tailorshop.service.implemantation;

import com.intern.tailorshop.domain.UserAccount;
import com.intern.tailorshop.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserAccountRepo userAccountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> optUser = userAccountRepo.findByUsername(username);

        if(optUser.isPresent()){
            UserAccount userAccount = optUser.get();
            String role = userAccount.getRole().name();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

            return User.builder()
                    .username(userAccount.getUsername())
                    .password(userAccount.getPassword())
                    .authorities(simpleGrantedAuthority)
                    .build();

        }

        throw new UsernameNotFoundException("There is no user found with username"+username);
    }
}
