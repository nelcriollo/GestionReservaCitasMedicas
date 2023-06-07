package edu.cibertec.gestioncitasmedicas.springsecurity.configsecurity;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private  final static String ACCESS_TOKEN_SECRET = "6g6MHmc0tnyDL4oWy15D4Uucc6XSrwsCOurlAS0Xf9w=";


    public static String generateToken(String nombre,String email) {

        Map<String, Object> adicional = new HashMap<>();
        adicional.put("nombre", nombre);

        return Jwts.builder()
              .setSubject(email)
              //.setIssuedAt(new Date())
              //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .addClaims(adicional)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
              .compact();

    }

    public static UsernamePasswordAuthenticationToken validateToken(String token) {

        try {
            Claims claims =  Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

           String email = claims.getSubject();
            System.out.println(" el token es valido");
            return new  UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());

        } catch (JwtException e) {
           throw new JwtException("el token es inavlido!" + e.getMessage());
        }
    }
}
