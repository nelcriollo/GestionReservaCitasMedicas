package edu.cibertec.gestioncitasmedicas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

@Override
    public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/usuario/login")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedHeaders("POST")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);

    registry.addMapping("/api/usuario/createUser")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedHeaders("POST")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);

    registry.addMapping("/api/usuario/**")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    registry.addMapping("/api/especialidad/**")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    registry.addMapping("/api/horario/**")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    registry.addMapping("/api/paciente/**")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    registry.addMapping("/api/reservaCitas/**")
            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación de Next.js
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);

}

}


