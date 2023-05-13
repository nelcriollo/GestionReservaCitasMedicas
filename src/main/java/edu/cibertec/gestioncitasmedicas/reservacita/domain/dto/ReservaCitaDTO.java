package edu.cibertec.gestioncitasmedicas.reservacita.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReservaCitaDTO {

    private long Id_Reserva;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha_Registro;

    private int Cantidad;

    private BigDecimal Precio;


    private int estado;

    private String nomusuario;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date horainicio;

    private String nompaciente;
}
