package site.mohememd.CarsBackend.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.auth.DTO.UserAuth;
import site.mohememd.CarsBackend.auth.JWT.JwtHelper;
import site.mohememd.CarsBackend.exceptions.WrongUsernameAndPassword;

import java.io.IOException;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    PasswordEncoder passwordEncoder;


    public String validateUser(UserAuth userAuth) {

        DatabaseUser databaseUser = authRepository.getUserFromDatabase(userAuth.username());
        if (passwordEncoder.matches(userAuth.password(), databaseUser.getPassword())){

             String JWToken = jwtHelper.createJWT(databaseUser.getId() + "",
                    "App.mohemmed.site",
                    databaseUser.getName(),
                    databaseUser.getRole());

            return JWToken;
         }

        throw new WrongUsernameAndPassword();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DatabaseUser databaseUser = authRepository.getUserFromDatabase(username);
        return User.builder()
                .username(databaseUser.getName())
                .password(databaseUser.getPassword())
                .roles(databaseUser.getRole())
                .build();
    }

}
