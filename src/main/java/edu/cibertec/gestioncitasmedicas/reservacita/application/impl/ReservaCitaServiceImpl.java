package edu.cibertec.gestioncitasmedicas.reservacita.application.impl;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out.EspecialidadRepository;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.infrastructure.out.HorarioRepository;
import edu.cibertec.gestioncitasmedicas.medico.infrastructure.out.MedicoRepository;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.paciente.infrastructure.out.PacienteRepository;
import edu.cibertec.gestioncitasmedicas.reservacita.application.service.ReservaCitaService;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper.ReservaCitaMapper;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out.ReservaCitaRepository;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import edu.cibertec.gestioncitasmedicas.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ReservaCitaServiceImpl implements ReservaCitaService {

    @Autowired
    private ReservaCitaRepository reservaCitaRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public ReservaCitaCreateDTO save(ReservaCitaCreateDTO reservaCitaCreateDTO) {

        List<Horario> horarios = horarioRepository.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();

        int maxIntentos = 10;
        int intentos = 0;
        Horario horario = null;

        while (intentos < maxIntentos && horario == null) {
            int indiceHorario = ThreadLocalRandom.current().nextInt(0, horarios.size());
            Horario horarioActual = horarios.get(indiceHorario);

            boolean horarioAsignado = horarioActual.getEstado() != 0;
            boolean reservaExistente = reservaCitaRepository.existsReservasCitaByFechaAndEspecialidadAndPaciente(
                    horarioActual.getFechaRegistro(),
                    horarioActual.getEspecialidad().getIdEspecialidad(),
                    reservaCitaCreateDTO.getPaciente().getIdPaciente()
            );

            if (!horarioAsignado && !reservaExistente) {
                horario = horarioActual;
            }

            intentos++;
        }

        if (horario != null) {
            // Asigna el horario a la reservaCita
            ReservaCita reservaCita = ReservaCitaMapper.instancia.reservaCitaCreateDTOAReservaCita(reservaCitaCreateDTO);
            reservaCita.setHorario(horario);

            // Obtén un usuario aleatorio
            int indiceUsuario = ThreadLocalRandom.current().nextInt(0, usuarios.size());
            Usuario usuario = usuarios.get(indiceUsuario);
            reservaCita.setUsuario(usuario);

            // Actualiza el estado del horario a "1"
            horario.setEstado(1);
            horarioRepository.save(horario);

            // Guarda la reservaCita en la base de datos
            return ReservaCitaMapper.instancia.reservaCitaAReservaCitaRegistradaDTO(reservaCitaRepository.save(reservaCita));
        } else {
            throw new RuntimeException("No hay horarios disponibles");
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
