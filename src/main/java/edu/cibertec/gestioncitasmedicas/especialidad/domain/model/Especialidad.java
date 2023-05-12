package edu.cibertec.gestioncitasmedicas.especialidad.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_especialidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long id_especialidad;

    @Column(name = "nombre" ,length =  100 ,nullable = false)
    private String nombre;

    @Column(name = "precioConsulta" , scale = 2, nullable = false)
    private BigDecimal precioConsulta;

    @Column(name = "duracion" , nullable = false)
    private int duracion;

    @Column(name = "estado")
    private boolean estado;

}
