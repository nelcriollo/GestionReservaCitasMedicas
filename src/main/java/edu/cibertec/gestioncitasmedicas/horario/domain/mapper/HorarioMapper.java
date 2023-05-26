package edu.cibertec.gestioncitasmedicas.horario.domain.mapper;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HorarioMapper {

    HorarioMapper INSTANCE = Mappers.getMapper(HorarioMapper.class);

    @Mapping(target = "nomEspecialidad", source = "especialidad.nombre")
    @Mapping(target = "nomMedico", source = "medico.nombre")
    HorarioDTO horarioAHorarioDTO(Horario horario);

    @Mapping(target = "especialidad.idEspecialidad", source = "horarioCreateDTO.idEspecialidad")
    @Mapping(target = "medico.idMedico", source = "horarioCreateDTO.idMedico")
    @Mapping(target = "horaInicio", source = "horarioCreateDTO.horaInicio")
    @Mapping(target = "horaFin", source = "horarioCreateDTO.horaFin")
    Horario horarioCreateDTOHorario(HorarioCreateDTO horarioCreateDTO);


    @Mapping(target = "idEspecialidad", source = "especialidad.idEspecialidad")
    @Mapping(target = "idMedico", source = "medico.idMedico")
    @Mapping(target = "horaInicio", source = "horario.horaInicio")
    @Mapping(target = "horaFin", source = "horario.horaFin")
    HorarioCreateDTO horarioAHorarioRegitrarDTO(Horario horario);

    @Mapping(target = "especialidad.idEspecialidad", source = "horarioUpdateDTO.idEspecialidad")
    @Mapping(target = "medico.idMedico", source = "horarioUpdateDTO.idMedico")
    @Mapping(target = "horaInicio", source = "horarioUpdateDTO.horaInicio")
    @Mapping(target = "horaFin", source = "horarioUpdateDTO.horaFin")
    Horario horarioUpdateDTOAHorario(HorarioUpdateDTO horarioUpdateDTO);

    @Mapping(target = "nomEspecialidad", source = "especialidad.nombre")
    @Mapping(target = "nomMedico", source = "medico.nombre")
    List<HorarioDTO> listaHorarioAHorarioDTO(List<Horario> horario);

}
