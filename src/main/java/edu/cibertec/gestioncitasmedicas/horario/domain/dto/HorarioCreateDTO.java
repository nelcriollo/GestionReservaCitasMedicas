package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class HorarioCreateDTO {


    private Date fecha;

    private Date horaInicio;

    private Date horaFin;

    private boolean estado;
}
