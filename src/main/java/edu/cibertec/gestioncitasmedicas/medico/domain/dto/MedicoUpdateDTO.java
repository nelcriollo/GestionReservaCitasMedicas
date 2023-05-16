package edu.cibertec.gestioncitasmedicas.medico.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoUpdateDTO {

    private long id_medico;

    private String codigo_cpi;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private int especialidadId;

    private int estado;
}
