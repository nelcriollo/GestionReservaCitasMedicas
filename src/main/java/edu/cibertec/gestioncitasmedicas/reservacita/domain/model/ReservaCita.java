package edu.cibertec.gestioncitasmedicas.reservacita.domain.model;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_reservacita")
public class ReservaCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private long idReserva;

    @Column(name = "Fecha_Registro", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Ingrese una fecha válida en el futuro")
    private Date fechaRegistro;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "Precio", scale = 2, nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "¤#,##0.00")
    private BigDecimal Precio;

    @Column(name = "estado", nullable = false)
    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;


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
