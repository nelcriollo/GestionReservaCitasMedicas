package edu.cibertec.gestioncitasmedicas.reservacita.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalTime;
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


    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horainicio;

    private String nompaciente;
}
