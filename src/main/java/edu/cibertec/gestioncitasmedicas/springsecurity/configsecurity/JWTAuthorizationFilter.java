package edu.cibertec.gestioncitasmedicas.springsecurity.configsecurity;

import edu.cibertec.gestioncitasmedicas.springsecurity.application.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String token =  request.getHeader("Authorization");
        String jwtToken = null;
        if (token!= null && token.startsWith("Bearer ")) {
            jwtToken = token.substring(7);

            if (tokenUtil.validateToken(jwtToken)){
                String username = tokenUtil.getUsernameFromToken(jwtToken);
                UserDetails userDetails = userDetailService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username,null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                System.out.println("token validado ok. "+jwtToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
