package edu.cibertec.gestioncitasmedicas.springsecurity.configsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class WebSecurityConfig {

    @Autowired
    private  UserDetailsService userDetailsService;
    @Autowired
    private  TokenUtil tokenUtil;
    @Autowired
    private  JWTAuthorizationFilter authorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager ) throws Exception {

        JWTAuthenticationFilter AuthenticationFilterJWT = new JWTAuthenticationFilter(tokenUtil);
        AuthenticationFilterJWT.setAuthenticationManager(authManager);
       AuthenticationFilterJWT.setFilterProcessesUrl("/api/usuario/login");


        return http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/usuario/createUser").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement( session -> {
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})
                .addFilter(AuthenticationFilterJWT)
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }


}

