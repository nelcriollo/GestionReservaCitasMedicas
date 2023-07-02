package edu.cibertec.gestioncitasmedicas.reservacita.application.impl;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.infrastructure.out.HorarioRepository;
import edu.cibertec.gestioncitasmedicas.reservacita.application.service.ReservaCitaService;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper.ReservaCitaMapper;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out.ReservaCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaCitaServiceImpl implements ReservaCitaService {

    @Autowired
    private ReservaCitaRepository reservaCitaRepository;

    @Autowired
    private HorarioRepository horarioRepository;


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
    @Transactional
    public ReservaCitaDTO save(ReservaCitaCreateDTO reservaCitaCreateDTO) {

// Verificar si ya existe una reserva con la misma fecha, especialidad y paciente
        boolean reservaExistente = reservaCitaRepository.existsReservasCitaByFechaAndEspecialidadAndPaciente(
                reservaCitaCreateDTO.getHorario().getFechaRegistro(),
                reservaCitaCreateDTO.getHorario().getEspecialidad().getIdEspecialidad(),
                reservaCitaCreateDTO.getPaciente().getIdPaciente()
        );

        // Obtener el horario correspondiente
        Optional<Horario> horario = horarioRepository.findById(reservaCitaCreateDTO.getHorario().getIdHorario());

        // Verificar si el horario está disponible (estado = 0)
        boolean horarioDisponible = horario.isPresent() && horario.get().getEstado() == 0;

        // Realizar las validaciones
        if (reservaExistente) {
            throw new RuntimeException("Ya existe una reserva con la misma fecha, especialidad y paciente.");
        } else if (!horarioDisponible) {
            throw new RuntimeException("El horario está ocupado. No se puede registrar la reserva.");
        }else{

            ReservaCita reservaCita = ReservaCitaMapper.instancia.reservaCitaCreateDTOAReservaCita(reservaCitaCreateDTO);
            ReservaCitaDTO reservaCitaRegistradaDTO = ReservaCitaMapper.instancia.reservaCitaAReservaCitaDTO(reservaCitaRepository.save(reservaCita));

            // Actualizar el estado del horario a 1
            if (horario.isPresent()) {
                Horario horarioActualizado = horario.get();
                horarioActualizado.setEstado(1);
                horarioRepository.save(horarioActualizado);
            }

            return reservaCitaRegistradaDTO;
        }
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
