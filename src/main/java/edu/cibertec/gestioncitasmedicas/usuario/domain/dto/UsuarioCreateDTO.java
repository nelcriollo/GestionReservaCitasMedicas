package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {
    private String nombre;

    private String apellidos;

    private String email;

    private String password;

    private int estado;
}
