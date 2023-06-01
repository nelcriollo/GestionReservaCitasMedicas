package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Getter
@Setter
public class HorarioDTO {

    private long idHorario;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    @JsonFormat(pattern = "HH:mm:ss")
    private String horaInicio;


    @JsonFormat(pattern = "HH:mm:ss")
    private String horaFin;

    private Medico medico;

    private Especialidad especialidad;

    private int estado;
}
