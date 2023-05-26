package edu.cibertec.gestioncitasmedicas.paciente.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PacienteUpdateDTO {
    private Long id_paciente;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String nroDocumento;
    private String email;
    private String telefono;
    private int estado;
}
