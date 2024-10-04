package site.mohememd.CarsBackend;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import site.mohememd.CarsBackend.exceptions.WrongWithToken;

import java.security.Key;
import java.util.Date;


@Component
public  class JwtHelper {

    public String createJWT(String id, String issuer, String subject, String role){
        //time in seconds 10 hours
        long expirationTime = 36000000;
        long expiration = System.currentTimeMillis() + expirationTime;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id)
                .setIssuer(issuer)
                .setSubject(subject)
                .claim("role", role)
                .setExpiration(new Date(expiration))
                .signWith(getSigningKey());

        return jwtBuilder.compact();
    }
    private Key getSigningKey() {
        String secret = "jsncjsncjsnjcnsjcfjncjnjanfjcnrjnsncfjnsafnjcrfnjnfsjnjfnjsnfjsdnjfregrds";
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public  Claims getTokenClaims(String token){
        try{
         Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build().parseClaimsJws(token)
                    .getBody();
        return claims;
        }catch (ExpiredJwtException e) {
            System.out.println("Token has expired: " + e.getMessage());
            throw new WrongWithToken();
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
            throw new WrongWithToken();
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token format: " + e.getMessage());
            throw new WrongWithToken();
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token: " + e.getMessage());
            throw new WrongWithToken();
        } catch (IllegalArgumentException e) {
            System.out.println("JWT token is missing or invalid: " + e.getMessage());
            throw new WrongWithToken();
        } catch (PrematureJwtException e) {
            System.out.println("JWT token is not yet valid: " + e.getMessage());
            throw new WrongWithToken();
        } catch (Exception e) {
            System.out.println("Error parsing JWT token: " + e.getMessage());
            throw new AccessDeniedException(e.getMessage());
        }



    }



}
