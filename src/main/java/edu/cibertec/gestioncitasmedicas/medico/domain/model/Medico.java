package edu.cibertec.gestioncitasmedicas.medico.domain.model;


import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private long idMedico;

    @Column(name = "codigo_CPI", length = 15, nullable = false)
    private String codigoCpi;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 70, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

    @Column(name = "estado", nullable = false)
    private int estado;

    @OneToMany(mappedBy = "medico")
    private Set<Horario> horarios = new HashSet();

}
