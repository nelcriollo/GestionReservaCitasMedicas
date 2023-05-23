package edu.cibertec.gestioncitasmedicas.especialidad.application.service;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadCreateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadUpdateDTO;

import java.util.List;

public interface EspecialidadService {


    List<EspecialidadDTO> findAll();
    EspecialidadDTO findById(long id_especialidad);

    EspecialidadCreateDTO save(EspecialidadCreateDTO especialidadCreateDTO);

    EspecialidadDTO update(EspecialidadUpdateDTO especialidadUpdateDTO);

    void delete(long id_especialidad);

}
