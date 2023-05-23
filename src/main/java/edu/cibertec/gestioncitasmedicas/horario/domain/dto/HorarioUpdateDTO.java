package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class HorarioUpdateDTO {

    private long id_horario;

    private Date fecha;

    private Date horaInicio;

    private Date horaFin;

    private boolean estado;
}
