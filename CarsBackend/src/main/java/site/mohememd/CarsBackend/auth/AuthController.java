package site.mohememd.CarsBackend.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mohememd.CarsBackend.Message;
import site.mohememd.CarsBackend.auth.DTO.SuccessLogin;
import site.mohememd.CarsBackend.auth.DTO.UserAuth;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController  {

     private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessLogin> authLogin(@RequestBody UserAuth userAuth, HttpServletResponse response) {
        String token = authService.validateUser(userAuth);
        Cookie cookie = new Cookie("JWT", token);
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return new ResponseEntity<>(new SuccessLogin("successful login",token),HttpStatus.OK);
    }

    @GetMapping("/validate/token")
    public ResponseEntity<Message> validateToken(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getCookies());
        System.out.println(1);
        Cookie cookie = new Cookie("JWT", "hei");
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return new ResponseEntity<>(new Message("validated"),HttpStatus.OK);
    }
}
