package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {

    private String Nombre;

    private String Apellidos;

    private String Email;

    private String Password;

    private int Estado;
}
