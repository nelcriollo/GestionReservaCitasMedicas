package edu.cibertec.gestioncitasmedicas.medico.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoCreateDTO {

    private String codigoCpi;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private int especialidadId;

    private int estado;
}
