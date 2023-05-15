package edu.cibertec.gestioncitasmedicas.paciente.application.impl;

import edu.cibertec.gestioncitasmedicas.paciente.application.service.PacienteService;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.mapper.PacienteMapper;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.paciente.infrastructure.out.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;
    @Override
    public PacienteDTO find(Long id_paciente) {
        Optional<Paciente> paciente = pacienteRepository.findById(id_paciente);
        if (paciente.isPresent()) {
            return pacienteMapper.pacienteAPacienteDTO(paciente.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<PacienteDTO> listaPaciente() {
        return pacienteMapper.listaPacienteAPacienteDTO(pacienteRepository.findAll());
    }

    @Override
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        return pacienteMapper.pacienteAPacienteDTO(pacienteRepository.save(pacienteMapper.pacienteDTOAPaciente(pacienteDTO)));
    }

    @Override
    public void delete(Long id_paciente) { pacienteRepository.deleteById(id_paciente);

  }
}
