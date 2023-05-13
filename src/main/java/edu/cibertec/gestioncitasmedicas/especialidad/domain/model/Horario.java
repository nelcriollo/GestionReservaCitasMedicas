package edu.cibertec.gestioncitasmedicas.especialidad.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tb_horario")
@Data
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private long id_horario;


    @Column(name = "fecha" , nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private Date fecha;

    @Column(name = "horaInicio" , nullable = false)
    @Temporal(value = TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date horaInicio;

    @Column(name = "horaFin" , nullable = false)
    @Temporal(value = TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date horaFin;


    @Column(name = "id_medico" , nullable = false)
    private int id_medico;

    @Column(name = "id_especialidad" , nullable = false)
    private int id_especialidad;


    @Column(name = "estado")
    private boolean estado;
}
