package edu.cibertec.gestioncitasmedicas.reservacita.application.service;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;

import java.util.List;

public interface ReservaCitaService {

    List<ReservaCitaDTO> findAll();

    ReservaCitaDTO findByID(long id);

    ReservaCitaCreateDTO save(ReservaCitaCreateDTO reservaCitaCreateDTO);

    ReservaCitaDTO update(ReservaCitaUpdateDTO reservaUpdateDTO);

    void delete(long id);

    List<ReservaCita> obtenerReservasDeUsuario(Usuario usuario);

}
