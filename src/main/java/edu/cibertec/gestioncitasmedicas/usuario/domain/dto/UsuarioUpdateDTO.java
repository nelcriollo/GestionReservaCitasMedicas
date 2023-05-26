package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    private long idUsuario;

    private String nombre;

    private String apellidos;

    private String email;

    private String password;

    private int estado;
}
