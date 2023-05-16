package edu.cibertec.gestioncitasmedicas.medico.domain.model;


import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private long id_medico;

    @Column(name = "codigo_CPI", length = 15, nullable = false)
    private String codigo_cpi;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 70, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

    @Column(name = "estado", nullable = false)
    private int estado;

}
