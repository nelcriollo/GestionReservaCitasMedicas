package edu.cibertec.gestioncitasmedicas.reservacita.application.service;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;

import java.util.List;

public interface ReservaCitaService {

    List<ReservaCitaDTO> findAll();

    ReservaCitaDTO findByID(long id);

    ReservaCitaDTO save(ReservaCitaCreateDTO reservaCitaCreateDTO);

    ReservaCitaDTO update(ReservaCitaUpdateDTO reservaUpdateDTO);

    void delete(long id);

}
