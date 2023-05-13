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

    @Mapping(target = "nomusuario", source = "usuario.nombre")
    /*@Mapping(target = "horainicio", source = "horario.horaInicio")
    @Mapping(target = "nompaciente", source = "paciente.nombre")*/
    ReservaCitaDTO reservaCitaAReservaCitaDTO(ReservaCita reservaCita);

    ReservaCita reservaCitaDTOAReservaCita(ReservaCitaDTO reservaCitaDTO);

    @Mapping(target = "usuario.id_Usuario", source = "reservaCitaCreateDTO.usuarioId")
    /*@Mapping(target = "horario.id_Horario", source = "reservaCitaCreateDTO.horarioId")
    @Mapping(target = "paciente.id_Paciente", source = "reservaCitaCreateDTO.pacienteId")*/
    ReservaCita reservaCitaCreateDTOAReservaCita(ReservaCitaCreateDTO reservaCitaCreateDTO);

    @Mapping(target = "usuarioId", source = "usuario.id_Usuario")
    /*@Mapping(target = "horarioId", source = "horario.id_Horario")
    @Mapping(target = "pacienteId", source = "paciente.id_Paciente")*/
    ReservaCitaCreateDTO reservaCitaAReservaCitaRegistradaDTO(ReservaCita reservaCita);


    @Mapping(target = "usuario.id_Usuario", source = "reservaCitaUpdateDTO.usuarioId")
    /*@Mapping(target = "horario.id_Horario", source = "reservaCitaUpdateDTO.horarioId")
    @Mapping(target = "paciente.id_Paciente", source = "reservaCitaUpdateDTO.pacienteId")*/
    ReservaCita reservaCitaUpdateDTOAReservaCita(ReservaCitaUpdateDTO reservaCitaUpdateDTO);


    @Mapping(target = "nomusuario", source = "usuario.nombre")
    /*@Mapping(target = "horainicio", source = "horario.horaInicio")
    @Mapping(target = "nompaciente", source = "paciente.nombre")*/
    List<ReservaCitaDTO> listaReservasCitaAReservaCitaDTO(List<ReservaCita> listaReservaCitas);

}
