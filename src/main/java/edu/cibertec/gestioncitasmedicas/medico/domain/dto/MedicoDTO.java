package edu.cibertec.gestioncitasmedicas.medico.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {
    private long id_medico;

    private String codigo_cpi;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private String nomEspecialidad;

    private int estado;
}
