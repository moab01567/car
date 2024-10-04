package site.mohememd.CarsBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.mohememd.CarsBackend.auth.AuthRepository;

import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = WrongUsernameAndPassword.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> handleWrongUsernameAndPassword(WrongUsernameAndPassword ex){
        Map<String,String> response = new HashMap<String,String>();
        response.put("message","Wrong Username or Password");
        return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = WrongWithToken.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> handleWrongWithToken(WrongWithToken ex){
        Map<String,String> response = new HashMap<String,String>();
        response.put("message","Wrong Token");
        return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = SomethingIsWrongWithDatabase.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<Object> handleWrongUsernameAndPassword(SomethingIsWrongWithDatabase ex ){
        Map<String,String> response = new HashMap<String,String>();
        response.put("message","Database Error");
        System.out.println(ex.getMessage());
        return new ResponseEntity<Object>(response,HttpStatus.SERVICE_UNAVAILABLE);
    }
}
