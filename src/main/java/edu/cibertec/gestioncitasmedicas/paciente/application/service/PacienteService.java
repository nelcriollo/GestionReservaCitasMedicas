package edu.cibertec.gestioncitasmedicas.paciente.application.service;

import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteCreateDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteUpdateDTO;

import java.util.List;

public interface PacienteService {

    List<PacienteDTO> findAll();

    PacienteDTO findByID(long id_paciente);

    PacienteDTO findByDni(String dni);

    PacienteDTO save(PacienteCreateDTO pacienteCreateDTO);

    PacienteDTO update(PacienteUpdateDTO pacienteUpdateDTO);

    void delete(long id_paciente);


}
