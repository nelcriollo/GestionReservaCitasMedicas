package edu.cibertec.gestioncitasmedicas.horario.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class HorarioCreateDTO {


    private Date fecha;

    private String horaInicio;

    private String horaFin;

    private int estado;
}
