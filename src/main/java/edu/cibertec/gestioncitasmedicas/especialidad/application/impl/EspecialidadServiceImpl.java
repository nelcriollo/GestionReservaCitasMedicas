package edu.cibertec.gestioncitasmedicas.especialidad.application.impl;

import edu.cibertec.gestioncitasmedicas.especialidad.application.service.EspecialidadService;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.mapper.EspecialidadMapper;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out.EspecialidadRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    private EspecialidadMapper especialidadMapper = EspecialidadMapper.INSTANCE;

    @Override
    public EspecialidadDTO find(Long id_especialidad) {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id_especialidad);

        if (especialidad.isPresent()){
            return especialidadMapper.especialidadAEspecialidadDTO(especialidad.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<EspecialidadDTO> findAll() {
     return especialidadMapper.listaEspecialidadAEspecialidadDTO(especialidadRepository.findAll());
    }


    @Override
    public EspecialidadDTO save(EspecialidadDTO especialidadDTO) {
        return especialidadMapper.especialidadAEspecialidadDTO(especialidadRepository.save(especialidadMapper.especialidadDTOAEspecialidad(especialidadDTO)));
    }

    @Override
    public void delete(Long id_especialidad){ especialidadRepository.deleteById(id_especialidad);

    }
}
