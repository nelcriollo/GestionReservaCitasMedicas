package edu.cibertec.gestioncitasmedicas.springsecurity.configsecurity;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cibertec.gestioncitasmedicas.springsecurity.model.AuthenCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private   TokenUtil tokenUtil;
    public JWTAuthenticationFilter(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        AuthenCredentials authCredentials =  null;
        String username = "";
        String password = "";
      try {

      authCredentials = new  ObjectMapper().readValue(request.getInputStream(), AuthenCredentials.class);
          username = authCredentials.getEmail();
          password = authCredentials.getPassword();
      System.out.println("opteniendo las credenciales: " + authCredentials);

      }catch (StreamReadException e) {
            throw new RuntimeException(e.getMessage());
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
        }
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                username,
                password
                );

        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("soy el metodo susscess: ");

        User user = (User)  authResult.getPrincipal(); //User es de spring security

        String token = tokenUtil.generateToken(user.getUsername());

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Agregar el encabezado "Authorization" con el token en la respuesta
        response.addHeader("Authorization", "Bearer " + token);
        
        Map<String, Object> httpResponse = new HashMap<>();
         httpResponse.put("token", token);
         httpResponse.put("Message", "Autenticacion Correcta");
         httpResponse.put("username", user.getUsername());

         response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
         response.setStatus(HttpStatus.OK.value());
         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
         response.getWriter().flush();

        // Imprimir el token generado
        System.out.println("Token generado: " + response);

        super.successfulAuthentication(request, response, chain, authResult);

    }

}
