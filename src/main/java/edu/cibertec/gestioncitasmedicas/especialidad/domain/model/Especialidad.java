package edu.cibertec.gestioncitasmedicas.especialidad.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Ingrese un solo letras")
    @NotBlank
    private String nombre;

    @Column(name = "precioConsulta", scale = 2, nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "¤#,##0.00")
    private BigDecimal precioConsulta;

    @Column(name = "duracion", nullable = false)
    @Min(value = 1)
    private int duracion;

    @Column(name = "estado")
    private int estado;


    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Horario> horario;


    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medico> especialidadMedicos;

}
