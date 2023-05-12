package edu.cibertec.gestioncitasmedicas.especialidad.domain.mapper;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EspecialidadMapper {

    EspecialidadMapper INSTANCE = Mappers.getMapper( EspecialidadMapper.class);

    EspecialidadDTO especialidadAEspecialidadDTO(Especialidad especialidad);

    Especialidad especialidadDTOAEspecialidad(EspecialidadDTO especialidadDTO);

    List<EspecialidadDTO> listaEspecialidadAEspecialidadDTO(List<Especialidad> especialidad);


}
