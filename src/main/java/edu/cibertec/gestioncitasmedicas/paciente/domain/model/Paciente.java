package edu.cibertec.gestioncitasmedicas.paciente.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id_paciente;

    @Column(name = "nombre", length = 100,nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 100,nullable = false)
    private String apellidos;

    @Column(name = "fechaNacimiento")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @Column(name = "nroDocumento", length = 100,nullable = false)
    private String nroDocumento;

    @Column(name = "email", length = 100,nullable = false)
    private String email;

    @Column(name = "telefono", length = 100,nullable = false)
    private String telefono;

    @Column(name = "estado")
    private boolean estado;
}
