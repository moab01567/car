package site.mohememd.CarsBackend.auth.JWT;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import site.mohememd.CarsBackend.exceptions.WrongWithToken;


import java.io.IOException;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {


   @Autowired
   JwtHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            System.out.println(bearerToken);
            String token = bearerToken.substring(7);
            try {
                Claims claims = jwtHelper.getTokenClaims(token);
                UserDetails userDetails = User.builder()
                        .username(claims.getSubject())
                        .password("")
                        .roles((String) claims.get("role"))
                        .build();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }catch (WrongWithToken ignored){

            }
        }

        filterChain.doFilter(request, response);
    }
    @Bean
    public FilterRegistrationBean<JwtAuthFilter> tenantFilterRegistration(JwtAuthFilter filter) {
        FilterRegistrationBean<JwtAuthFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

}