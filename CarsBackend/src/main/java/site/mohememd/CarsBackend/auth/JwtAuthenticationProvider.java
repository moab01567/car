package site.mohememd.CarsBackend.auth;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import site.mohememd.CarsBackend.JwtHelper;
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String bearerToken = (String) authentication.getPrincipal();

      String token = bearerToken.substring(7);
      Claims claims = jwtHelper.getTokenClaims(token);
      UserDetails userDetails = User.builder()
              .username(claims.getSubject())
              .roles((String) claims.get("role"))
              .build();

        return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
    }

   @Override
    public boolean supports(Class<?> authentication) {

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
