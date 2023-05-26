package edu.cibertec.gestioncitasmedicas.medico.domain.mapper;

import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoCreateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoUpdateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoMapper instancia = Mappers.getMapper(MedicoMapper.class);

    @Mapping(target = "nomEspecialidad", source = "especialidad.nombre")
    MedicoDTO medicoAMedicoDTO(Medico medico);


    @Mapping(target = "especialidad.idEspecialidad", source = "medicoCreateDTO.especialidadId")
    Medico medicoCreateDTOAMedico(MedicoCreateDTO medicoCreateDTO);

    @Mapping(target = "especialidadId", source = "especialidad.idEspecialidad")
    MedicoCreateDTO medicoAMedicoRegistradoDTO(Medico medico);

    @Mapping(target = "especialidad.idEspecialidad", source = "medicoUpdateDTO.especialidadId")
    Medico medicoUpdateDTOAMedico(MedicoUpdateDTO medicoUpdateDTO);

    @Mapping(target = "nomEspecialidad", source = "especialidad.nombre")
    List<MedicoDTO> listaMedicosAMedicoDTO(List<Medico> lista);


}
