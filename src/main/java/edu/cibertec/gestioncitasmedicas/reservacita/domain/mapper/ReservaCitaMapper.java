package edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaCitaMapper {


    ReservaCitaMapper instancia = Mappers.getMapper(ReservaCitaMapper.class);

    @Mapping(target = "nomUsuario", source = "usuario.nombre")
    @Mapping(target = "horaInicio", source = "horario.horaInicio")
    @Mapping(target = "nomPaciente", source = "paciente.nombre")
    ReservaCitaDTO reservaCitaAReservaCitaDTO(ReservaCita reservaCita);


    @Mapping(target = "usuario.idUsuario", source = "reservaCitaCreateDTO.usuarioId")
    @Mapping(target = "horario.idHorario", source = "reservaCitaCreateDTO.horarioId")
    @Mapping(target = "paciente.idPaciente", source = "reservaCitaCreateDTO.pacienteId")
    ReservaCita reservaCitaCreateDTOAReservaCita(ReservaCitaCreateDTO reservaCitaCreateDTO);

    @Mapping(target = "usuarioId", source = "usuario.idUsuario")
    @Mapping(target = "horarioId", source = "horario.idHorario")
    @Mapping(target = "pacienteId", source = "paciente.idPaciente")
    ReservaCitaCreateDTO reservaCitaAReservaCitaRegistradaDTO(ReservaCita reservaCita);


    @Mapping(target = "usuario.idUsuario", source = "reservaCitaUpdateDTO.usuarioId")
    @Mapping(target = "horario.idHorario", source = "reservaCitaUpdateDTO.horarioId")
    @Mapping(target = "paciente.idPaciente", source = "reservaCitaUpdateDTO.pacienteId")
    ReservaCita reservaCitaUpdateDTOAReservaCita(ReservaCitaUpdateDTO reservaCitaUpdateDTO);


    @Mapping(target = "nomUsuario", source = "usuario.nombre")
    @Mapping(target = "horaInicio", source = "horario.horaInicio")
    @Mapping(target = "nomPaciente", source = "paciente.nombre")
    List<ReservaCitaDTO> listaReservasCitaAReservaCitaDTO(List<ReservaCita> listaReservaCitas);

}
