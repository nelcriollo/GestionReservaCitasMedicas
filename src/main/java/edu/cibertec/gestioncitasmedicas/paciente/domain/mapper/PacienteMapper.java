package edu.cibertec.gestioncitasmedicas.paciente.domain.mapper;

import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO pacienteAPacienteDTO(Paciente paciente);

    Paciente pacienteDTOAPaciente(PacienteDTO pacienteDTO);

    List<PacienteDTO> listaPacienteAPacienteDTO(List<Paciente> paciente);

    List<Paciente> listaPacienteDTOAPaciente(List<PacienteDTO> pacienteDTOLista);
}
