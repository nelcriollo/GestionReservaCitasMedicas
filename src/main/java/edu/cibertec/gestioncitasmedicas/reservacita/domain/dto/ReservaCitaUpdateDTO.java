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
public class ReservaCitaUpdateDTO {

    private long idReserva;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;


    private int cantidad;


    private BigDecimal precio;


    private int estado;

    private long usuarioId;


    private long horarioId;


    private long pacienteId;
}
