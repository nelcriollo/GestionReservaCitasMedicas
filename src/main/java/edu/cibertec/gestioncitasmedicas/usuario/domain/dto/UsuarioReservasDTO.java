package edu.cibertec.gestioncitasmedicas.usuario.domain.dto;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioReservasDTO {

    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private List<ReservaCitaDTO> reservasDtos = new ArrayList<>();
}
