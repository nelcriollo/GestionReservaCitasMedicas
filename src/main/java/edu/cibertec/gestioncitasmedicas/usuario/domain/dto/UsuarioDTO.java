package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private long Id_Usuario;

    private String Nombre;

    private String Apellidos;

    private String Email;

    private String Password;

    private int Estado;


}
