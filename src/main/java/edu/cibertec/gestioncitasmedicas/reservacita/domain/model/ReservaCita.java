package edu.cibertec.gestioncitasmedicas.reservacita.domain.model;

import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_reservacita")
public class ReservaCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Reserva", nullable = false)
    private long Id_Reserva;

    @Column(name = "Fecha_Registro", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha_Registro;

    @Column(name = "Cantidad", nullable = false)
    private int Cantidad;

    @Column(name = "Precio", scale = 2, nullable = false)
    private BigDecimal Precio;

    @Column(name = "estado", nullable = false)
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Usuario", nullable = false)
    private Usuario usuario;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Horario", nullable = false)
    private Horario horario;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Paciente", nullable = false)
    private Paciente paciente;*/


    // método para asignar nombre a los estados
    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0:
                nombreEstado = "Anulado";
                break;
            case 1:
                nombreEstado = "Confirmado";
                break;
            default:
                nombreEstado = "Atendido";
        }
        return nombreEstado;
    }

}
