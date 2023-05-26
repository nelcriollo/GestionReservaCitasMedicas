package edu.cibertec.gestioncitasmedicas.especialidad.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EspecialidadUpdateDTO {

    private Long idEspecialidad;
    private String nombre;
    private BigDecimal precioConsulta;
    private int duracion;
    private int estado;

}
