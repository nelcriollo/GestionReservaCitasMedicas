package edu.cibertec.gestioncitasmedicas.reservacita.application.impl;

import edu.cibertec.gestioncitasmedicas.reservacita.application.service.ReservaCitaService;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper.ReservaCitaMapper;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out.ReservaCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaCitaServiceImpl implements ReservaCitaService {

    @Autowired
    private ReservaCitaRepository reservaCitaRepository;

    @Override
    public List<ReservaCitaDTO> findAll() {
        return ReservaCitaMapper.instancia.listaReservasCitaAReservaCitaDTO(reservaCitaRepository.findAll());
    }

    @Override
    public ReservaCitaDTO findByID(long id) {
        Optional<ReservaCita> reservaCitaOptional = reservaCitaRepository.findById(id);

        if (!reservaCitaOptional.isPresent()) {
            throw new NoResultException("No se encontro la cita reservada con id: " + id);
        }
        return ReservaCitaMapper.instancia.reservaCitaAReservaCitaDTO(reservaCitaOptional.get());
    }

    @Override
    public ReservaCitaCreateDTO save(ReservaCitaCreateDTO reservaCitaCreateDTO) {
        ReservaCita reservaCita = ReservaCitaMapper.instancia.reservaCitaCreateDTOAReservaCita(reservaCitaCreateDTO);
        return ReservaCitaMapper.instancia.reservaCitaAReservaCitaRegistradaDTO(reservaCitaRepository.save(reservaCita));
    }

    @Override
    public ReservaCitaDTO update(ReservaCitaUpdateDTO reservaUpdateDTO) {
        ReservaCita reservaCita = ReservaCitaMapper.instancia.reservaCitaUpdateDTOAReservaCita(reservaUpdateDTO);
        return ReservaCitaMapper.instancia.reservaCitaAReservaCitaDTO(reservaCitaRepository.save(reservaCita));
    }

    @Override
    public void delete(long id) {
        Optional<ReservaCita> reservaCitaOptional = reservaCitaRepository.findById(id);

        reservaCitaOptional.ifPresent(reservaCita -> reservaCitaRepository.delete(reservaCita));
        throw new NoResultException("No se encontro la cita reservada con id: " + id);

    }
}
