package edu.cibertec.gestioncitasmedicas.usuario.domain.model;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario", nullable = false)
    private long Id_Usuario;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String Nombre;

    @Column(name = "Apellidos", length = 70, nullable = false)
    private String Apellidos;

    @Column(name = "Email", length = 150, nullable = false)
    private String Email;

    @Column(name = "Password", length = 250, nullable = false)
    private String Password;

    @Column(name = "Estado", nullable = false)
    private int Estado;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReservaCita> citasReservadas;
}
