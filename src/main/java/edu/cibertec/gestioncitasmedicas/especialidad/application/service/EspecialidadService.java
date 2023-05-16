package edu.cibertec.gestioncitasmedicas.especialidad.application.service;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;

import java.util.List;

public interface EspecialidadService {

    EspecialidadDTO find(Long id_especialidad);

    List<EspecialidadDTO> findAll();

    EspecialidadDTO save(EspecialidadDTO especialidadDTO);

    void delete(Long id_especialidad);

}
