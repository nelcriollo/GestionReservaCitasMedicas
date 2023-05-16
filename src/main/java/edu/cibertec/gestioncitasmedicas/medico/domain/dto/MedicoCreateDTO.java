package edu.cibertec.gestioncitasmedicas.medico.domain.dto;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoCreateDTO {

    private String codigo_cpi;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private int especialidadId;

    private int estado;
}
