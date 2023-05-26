package edu.cibertec.gestioncitasmedicas.reservacita.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private long idReserva;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    private int cantidad;

    private BigDecimal precio;


    private int estado;

    private String nomUsuario;

    @JsonFormat(pattern = "HH:mm:ss")
    private String horaInicio;

    private String nomPaciente;
}
