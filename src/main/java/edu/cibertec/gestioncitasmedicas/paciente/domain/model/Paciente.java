package edu.cibertec.gestioncitasmedicas.paciente.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Paciente")
    private Long idPaciente;

    @Column(name = "nombre", length = 100, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese un solo letras")
    @NotBlank
    private String nombre;

    @Column(name = "apellidos", length = 100, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese solo letras")
    @NotBlank
    private String apellidos;

    @Column(name = "fechaNacimiento")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Ingrese una fecha válida en el futuro")
    private Date fechaNacimiento;

    @Column(name = "nroDocumento", length = 100, nullable = false)
    @Digits(integer = 8, fraction = 0, message = "Ingrese solo números")
    @NotBlank
    private String nroDocumento;

    @Column(name = "email", length = 100, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "telefono", length = 100, nullable = false)
    @Digits(integer = 9, fraction = 0, message = "Ingrese solo números")
    @NotBlank
    private String telefono;

    @Column(name = "estado")
    private int estado;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ReservaCita> citasReservadas;
}
