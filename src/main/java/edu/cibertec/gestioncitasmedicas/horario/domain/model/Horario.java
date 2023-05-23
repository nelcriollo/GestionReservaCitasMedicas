package edu.cibertec.gestioncitasmedicas.horario.domain.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Table(name = "tb_horario")
@Data
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private long id_horario;


    @Column(name = "fecha" )
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private Date fecha;

    @Column(name = "horaInicio")
    @DateTimeFormat(pattern = "HH:mm")
    private String horaInicio;

    @Column(name = "horaFin")
    @DateTimeFormat(pattern = "HH:mm")
    private String horaFin;





    @Column(name = "id_medico" )
    private int id_medico;

    @Column(name = "id_especialidad" )
    private int id_especialidad;


    @Column(name = "estado")
    private int estado;
}
