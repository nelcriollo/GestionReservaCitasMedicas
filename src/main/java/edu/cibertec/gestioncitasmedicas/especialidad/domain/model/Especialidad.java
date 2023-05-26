package edu.cibertec.gestioncitasmedicas.especialidad.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long idEspecialidad;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "precioConsulta", scale = 2, nullable = false)
    private BigDecimal precioConsulta;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "estado")
    private int estado;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Horario> horario;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medico> especialidadMedicos;

}
