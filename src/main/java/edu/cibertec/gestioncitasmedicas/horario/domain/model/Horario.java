package edu.cibertec.gestioncitasmedicas.horario.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private LocalTime horaInicio;


    @Column(name = "horaFin", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaFin;

    @Column(name = "estado")
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;


    @OneToOne(mappedBy = "horario")
    private ReservaCita reservaCita;
}
