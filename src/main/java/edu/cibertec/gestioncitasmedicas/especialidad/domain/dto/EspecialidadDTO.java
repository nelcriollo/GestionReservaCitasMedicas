package edu.cibertec.gestioncitasmedicas.especialidad.domain.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class EspecialidadDTO {

    private Long id_especialidad;
    private String nombre;
    private BigDecimal precioConsulta;
    private int duracion;
    private int estado;

}
