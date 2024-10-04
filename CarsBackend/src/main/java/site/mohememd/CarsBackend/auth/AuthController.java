package site.mohememd.CarsBackend.auth;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController  {



    @Autowired
    ServiceAuth serviceAuth;


    @PostMapping("/login")
    public ResponseEntity<?> authLogin(@RequestBody UserAuth userAuth){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        String token = serviceAuth.validateUser(userAuth);
        Map<String,String> response = new HashMap<>();
        response.put("message","successful login");
        response.put("token",token);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/validate/token")
    public ResponseEntity<?> validateToken(){
        Map<String,String> response = new HashMap<>();
        response.put("message","validated");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
