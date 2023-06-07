package edu.cibertec.gestioncitasmedicas.springsecurity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenCredentials {

    private String email;

    private String password;
}
