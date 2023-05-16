package edu.cibertec.gestioncitasmedicas.paciente.application.service;

import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {


    PacienteDTO find(Long id_paciente);
    List<PacienteDTO> findAll();
    PacienteDTO save(PacienteDTO pacienteDTO);
    void delete(Long id_paciente);


}
