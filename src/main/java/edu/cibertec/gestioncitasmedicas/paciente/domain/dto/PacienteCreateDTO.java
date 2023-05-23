package edu.cibertec.gestioncitasmedicas.paciente.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PacienteCreateDTO {

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String nroDocumento;
    private String email;
    private String telefono;
    private int estado;
}
