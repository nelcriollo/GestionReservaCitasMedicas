package edu.cibertec.gestioncitasmedicas.especialidad.application.impl;

import edu.cibertec.gestioncitasmedicas.especialidad.application.service.EspecialidadService;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadCreateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadUpdateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.mapper.EspecialidadMapper;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    private EspecialidadMapper especialidadMapper = EspecialidadMapper.INSTANCE;


    @Override
    public List<EspecialidadDTO> findAll() {
        return especialidadMapper.listaEspecialidadAEspecialidadDTO(especialidadRepository.findAll());
    }

    @Override
    public EspecialidadDTO findById(long id_especialidad) {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id_especialidad);

        if (!especialidad.isPresent()) {
            throw new NoResultException("No se encontro el especialista con el id : " + id_especialidad);
        } else {
            return especialidadMapper.especialidadAEspecialidadDTO(especialidad.get());
        }

    }


    @Override
    public EspecialidadCreateDTO save(EspecialidadCreateDTO especialidadCreateDTO) {
        Especialidad especialidad = EspecialidadMapper.INSTANCE.especialidadCreateDTOEspecialidad(especialidadCreateDTO);
        return EspecialidadMapper.INSTANCE.especialidadAEspecialidadRegistrarDTO(especialidadRepository.save(especialidad));
    }


    @Override
    public EspecialidadDTO update(EspecialidadUpdateDTO especialidadUpdateDTO) {
        Especialidad especialidad = EspecialidadMapper.INSTANCE.especialidadUpdateDTOAEspecialidad(especialidadUpdateDTO);
        return EspecialidadMapper.INSTANCE.especialidadAEspecialidadDTO(especialidadRepository.save(especialidad));
    }

    @Override
    public void delete(long id_especialidad) {

        Optional<Especialidad> especialidad = especialidadRepository.findById(id_especialidad);


        if (!especialidad.isPresent()) {
            throw new NoResultException("No se encontro el especialista con el id: " + id_especialidad);

        } else {
            especialidadRepository.delete(especialidad.get());
        }

    }
}
