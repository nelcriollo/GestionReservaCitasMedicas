package edu.cibertec.gestioncitasmedicas.usuario.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    @Column(name = "nombre", length = 50, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese un solo letras")
    @NotBlank
    private String nombre;

    @Column(name = "apellidos", length = 70, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese solo letras")
    @NotBlank
    private String apellidos;

    @Column(name = "email", length = 150, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "password", length = 256, nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "La contraseña no cumple con los requisitos")
    private String password;

    @Column(name = "estado", nullable = false)
    private int estado;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReservaCita> citasReservadas;
}
