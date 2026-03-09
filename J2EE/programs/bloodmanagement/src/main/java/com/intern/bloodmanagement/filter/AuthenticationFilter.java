package com.intern.bloodmanagement.filter;

import com.intern.bloodmanagement.service.implementation.MyUsersDetailsService;
import com.intern.bloodmanagement.utility.JwtUtil;
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
import java.util.List;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUsersDetailsService myUsersDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");

        if(authToken != null && authToken.startsWith("Bearer ")){
            String jwtToken = authToken.substring(7);
            String username = jwtUtil.extractUsername(jwtToken);

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = myUsersDetailsService.loadUserByUsername(username);

                List<String> roles = jwtUtil.extractClaim(jwtToken, claims -> claims.get("roles", ArrayList.class));
                List<SimpleGrantedAuthority> list = roles.stream().map(SimpleGrantedAuthority::new).toList();

                if(jwtUtil.validateToken(jwtToken,userDetails))
                {
                    System.out.println("isValidatedToken");
                    UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(username,null, list);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("Auth set in context: " + SecurityContextHolder.getContext().getAuthentication());
                }

            }
        }

        filterChain.doFilter(request , response);
    }
}
