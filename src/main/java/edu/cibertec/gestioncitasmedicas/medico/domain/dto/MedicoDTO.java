package edu.cibertec.gestioncitasmedicas.medico.domain.dto;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {

    private long idMedico;

    private String codigoCpi;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private Especialidad especialidad;

    private int estado;
}
