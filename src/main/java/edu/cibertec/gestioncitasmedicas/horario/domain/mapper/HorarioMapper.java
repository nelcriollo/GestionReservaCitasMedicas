package edu.cibertec.gestioncitasmedicas.horario.domain.mapper;

import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HorarioMapper {

    HorarioMapper INSTANCE = Mappers.getMapper(HorarioMapper.class);

    @Mapping(target = "id_especialidad", source = "especialidad.id_especialidad")
    HorarioDTO horarioAHorarioDTO(Horario horario);

    @Mapping(target = "especialidad.id_especialidad", source = "horarioDTO.id_especialidad")
    Horario horarioDTOAHorario(HorarioDTO horarioDTO);

    @Mapping(target = "id_especialidad", source = "especialidad.id_especialidad")
    List<HorarioDTO> listaHorarioAHorarioDTO(List<Horario> horario);

    //List<Horario> listaHorarioDTOAHorario(List<HorarioDTO> horarioDTOLista);
}
