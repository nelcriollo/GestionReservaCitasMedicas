package edu.cibertec.gestioncitasmedicas.horario.application.service;

import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioUpdateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;

import java.util.List;

public interface HorarioService {

    HorarioDTO findById(long id_horario);

    List<HorarioDTO> findAll();

    HorarioCreateDTO save(HorarioCreateDTO horarioCreateDTO);

    HorarioDTO update(HorarioUpdateDTO horarioUpdateDTO);

    void delete(Long id_horario);
}
