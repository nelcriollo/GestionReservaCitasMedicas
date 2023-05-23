package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class HorarioUpdateDTO {

    private long id_horario;

    private Date fecha;

    private String horaInicio;

    private String horaFin;

    private int estado;
}
