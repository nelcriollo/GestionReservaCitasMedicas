package edu.cibertec.gestioncitasmedicas.especialidad.domain.dto;

import lombok.Data;

import java.util.Date;


@Data
public class HorarioDTO {

    private long id_horario;

    private Date fecha;

    private Date horaInicio;

    private Date horaFin;

    private boolean estado;
}
