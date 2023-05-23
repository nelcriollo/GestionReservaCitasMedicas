package edu.cibertec.gestioncitasmedicas.horario.application.service;

import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioUpdateDTO;

import java.util.List;

public interface HorarioService {

    List<HorarioDTO> findAll();
    HorarioDTO findById(long id_horario);

    HorarioCreateDTO save(HorarioCreateDTO horarioCreateDTO);

    HorarioDTO update(HorarioUpdateDTO horarioUpdateDTO);
    void delete(long id_horario);
}
