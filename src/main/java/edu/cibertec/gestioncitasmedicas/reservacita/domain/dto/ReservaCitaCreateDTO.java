package edu.cibertec.gestioncitasmedicas.reservacita.domain.dto;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ReservaCitaCreateDTO {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private BigDecimal precio;

    private int estado;

    private Usuario usuario;

    private Horario horario;

    private Paciente paciente;
}
