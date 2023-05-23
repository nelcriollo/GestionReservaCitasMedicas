package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import lombok.Data;

import java.util.Date;


@Data
public class HorarioDTO {

    private long id_horario;

    private Date fecha;

    private String horaInicio;

    private String horaFin;

    private int estado;
}
