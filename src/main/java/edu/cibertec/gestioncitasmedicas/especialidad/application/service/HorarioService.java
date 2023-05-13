package edu.cibertec.gestioncitasmedicas.especialidad.application.service;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.HorarioDTO;

import java.util.List;

public interface HorarioService {
    HorarioDTO find(Long id_horario);
    List<HorarioDTO> findAll();
    HorarioDTO save(HorarioDTO horarioDTO);
    void delete(Long id_horario);
}
