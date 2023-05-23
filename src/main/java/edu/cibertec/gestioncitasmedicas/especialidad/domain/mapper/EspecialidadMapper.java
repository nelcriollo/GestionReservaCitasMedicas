package edu.cibertec.gestioncitasmedicas.especialidad.domain.mapper;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadCreateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadUpdateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EspecialidadMapper {

    EspecialidadMapper INSTANCE = Mappers.getMapper(EspecialidadMapper.class);

    EspecialidadDTO especialidadAEspecialidadDTO(Especialidad especialidad);

    Especialidad especialidadCreateDTOEspecialidad(EspecialidadCreateDTO especialidadCreateDTO);

    EspecialidadCreateDTO especialidadAEspecialidadRegistrarDTO(Especialidad especialidad);

    Especialidad especialidadUpdateDTOAEspecialidad(EspecialidadUpdateDTO especialidadUpdateDTO);

    List<EspecialidadDTO> listaEspecialidadAEspecialidadDTO(List<Especialidad> especialidad);


}
