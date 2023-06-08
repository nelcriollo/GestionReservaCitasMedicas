package edu.cibertec.gestioncitasmedicas.horario.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private long idHorario;

    @Column(name = "fecha", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    @Column(name = "horaInicio", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Ingrese una hora válida en formato de 24 horas")
    private LocalTime horaInicio;


    @Column(name = "horaFin", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Ingrese una hora válida en formato de 24 horas")
    private LocalTime horaFin;

    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    @JsonIgnore
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    @JsonIgnore
    private Especialidad especialidad;


    @JsonIgnore
    @OneToOne(mappedBy = "horario")
    private ReservaCita reservaCita;
}
