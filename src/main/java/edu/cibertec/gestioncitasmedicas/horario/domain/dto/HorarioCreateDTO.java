package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class HorarioCreateDTO {

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    @JsonFormat(pattern = "HH:mm:ss")
    private String horaInicio;


    @JsonFormat(pattern = "HH:mm:ss")
    private String horaFin;

    private int idMedico;

    private int idEspecialidad;

    private int estado;
}