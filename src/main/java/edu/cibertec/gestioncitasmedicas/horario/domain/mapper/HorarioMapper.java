package edu.cibertec.gestioncitasmedicas.horario.domain.mapper;

import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HorarioMapper {

    HorarioMapper INSTANCE = Mappers.getMapper(HorarioMapper.class);

    HorarioDTO horarioAHorarioDTO(Horario horario);

    Horario horarioDTOAHorario(HorarioDTO horarioDTO);

    List<HorarioDTO> listaHorarioAHorarioDTO(List<Horario> horario);

    List<Horario> listaHorarioDTOAHorario(List<HorarioDTO> horarioDTOLista);
}
