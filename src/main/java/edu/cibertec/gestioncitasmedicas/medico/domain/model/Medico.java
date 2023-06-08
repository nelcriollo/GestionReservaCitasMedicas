package edu.cibertec.gestioncitasmedicas.medico.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese un solo letras")
    @NotBlank
    private String nombre;

    @Column(name = "apellidos", length = 70, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese un solo letras")
    @NotBlank
    private String apellidos;

    @Column(name = "email", length = 250, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "telefono", length = 15, nullable = false)
    @Digits(integer = 9, fraction = 0, message = "Ingrese solo números")
    @NotBlank
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    @JsonIgnore
    private Especialidad especialidad;

    @Column(name = "estado", nullable = false)
    private int estado;


    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private Set<Horario> horarios;

}
