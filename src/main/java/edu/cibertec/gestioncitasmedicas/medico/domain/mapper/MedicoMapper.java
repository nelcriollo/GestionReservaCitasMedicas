package edu.cibertec.gestioncitasmedicas.medico.domain.mapper;

import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoCreateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoUpdateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoMapper instancia = Mappers.getMapper(MedicoMapper.class);

    MedicoDTO medicoAMedicoDTO(Medico medico);

    Medico medicoCreateDTOAMedico(MedicoCreateDTO medicoCreateDTO);

    MedicoCreateDTO medicoAMedicoRegistradoDTO(Medico medico);

    Medico medicoUpdateDTOAMedico(MedicoUpdateDTO medicoUpdateDTO);

    List<MedicoDTO> listaMedicosAMedicoDTO(List<Medico> lista);


}
