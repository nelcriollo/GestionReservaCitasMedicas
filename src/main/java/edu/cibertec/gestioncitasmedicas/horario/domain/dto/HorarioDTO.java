package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
@Getter
@Setter
public class HorarioDTO {

    private long id_horario;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @JsonFormat(pattern = "HH:mm:ss")
    private String horaInicio;


    @JsonFormat(pattern = "HH:mm:ss")
    private String horaFin;

    private int id_medico;

    private int id_especialidad;

    private int estado;
}
