package edu.cibertec.gestioncitasmedicas.springsecurity.configsecurity;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class TokenUtil {

    private  final static String ACCESS_TOKEN_SECRET = "6g6MHmc0tnyDL4oWy15D4Uucc6XSrwsCOurlAS0Xf9w=";


    public  String generateToken(String email) {
        System.out.println("soy el metodo de que genera e token: ");
        return Jwts.builder()
              .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(getExpirationDate())
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
               .compact();
    }

    private static Date getExpirationDate() {
        // Calcula la fecha de caducidad (de 30 días desde la fecha que se henera)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        return calendar.getTime();
    }

    public boolean  validateToken(String token) {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println(" el token es valido ");
            return true;
        } catch (JwtException e) {
            log.error("el token es inavlido! " + e.getMessage());
           return false;
        }
    }


    // Obtener el username del token
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    // Obtener un solo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Obtener todos los claims del token
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
