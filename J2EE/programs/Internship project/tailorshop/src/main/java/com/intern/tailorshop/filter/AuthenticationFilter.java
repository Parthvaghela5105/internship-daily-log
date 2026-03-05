package com.intern.tailorshop.filter;

import com.intern.tailorshop.service.implemantation.MyUserDetailsService;
import com.intern.tailorshop.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");
        System.out.println("authToken= "+authToken);
        if(authToken != null && authToken.startsWith("Bearer ")){
            String jwtToken = authToken.substring(7);
            System.out.println("JWT token : "+jwtToken);
            String userName = jwtUtil.extractUsername(jwtToken);

            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                System.out.println("UserName: "+userName);
                UserDetails user = myUserDetailsService.loadUserByUsername(userName);

                List<String> roles = jwtUtil.extractClaim(jwtToken, claims -> claims.get("roles", ArrayList.class));

//                List<SimpleGrantedAuthority> list = Arrays.stream(role.split(",")).map(r -> new SimpleGrantedAuthority(r)).toList();
//                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

                List list = roles.stream().map(r -> new SimpleGrantedAuthority(r)).toList();
                System.out.println("UserDetails: "+user.getUsername());
                if(jwtUtil.validateToken(jwtToken,user))
                {
                    System.out.println("isValidatedToken");
                    UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(userName,null, list);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("Auth set in context: " + SecurityContextHolder.getContext().getAuthentication());
                }
            }
        }

        filterChain.doFilter(request , response);
    }
}
