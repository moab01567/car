package site.mohememd.CarsBackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.JwtHelper;
import site.mohememd.CarsBackend.exceptions.WrongUsernameAndPassword;

@Service
public class ServiceAuth implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    PasswordEncoder passwordEncoder;


    public String validateUser(UserAuth userAuth)   {

        DatabaseUser databaseUser = authRepository.getUserFromDatabase(userAuth.username());
         if (passwordEncoder.matches(userAuth.password(), databaseUser.getPassword())){
            return jwtHelper.createJWT(databaseUser.getId() + "",
                    "App.mohemmed.site",
                    databaseUser.getName(),
                    databaseUser.getRole());
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
