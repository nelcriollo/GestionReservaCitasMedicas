package edu.cibertec.gestioncitasmedicas.paciente.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class PacienteUpdateDTO {
    private Long idPaciente;
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
