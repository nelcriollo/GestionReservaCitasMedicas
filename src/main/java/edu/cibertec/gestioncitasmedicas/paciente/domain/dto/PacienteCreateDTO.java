package edu.cibertec.gestioncitasmedicas.paciente.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Setter
@Getter
public class PacienteCreateDTO {

    private String nombre;
    private String apellidos;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private String nroDocumento;
    private String email;
    private String telefono;
    private int estado;
}
