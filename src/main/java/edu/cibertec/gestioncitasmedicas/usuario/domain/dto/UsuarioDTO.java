package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UsuarioDTO {

    private long idUsuario;

    private String nombre;

    private String apellidos;

    private String email;

    private String password;

    private int estado;


}
