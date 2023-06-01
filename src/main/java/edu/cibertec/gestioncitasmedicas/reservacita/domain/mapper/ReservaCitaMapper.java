package edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaCitaMapper {

    ReservaCitaMapper instancia = Mappers.getMapper(ReservaCitaMapper.class);

    ReservaCitaDTO reservaCitaAReservaCitaDTO(ReservaCita reservaCita);

    ReservaCita reservaCitaCreateDTOAReservaCita(ReservaCitaCreateDTO reservaCitaCreateDTO);

    ReservaCitaCreateDTO reservaCitaAReservaCitaRegistradaDTO(ReservaCita reservaCita);

    ReservaCita reservaCitaUpdateDTOAReservaCita(ReservaCitaUpdateDTO reservaCitaUpdateDTO);

    List<ReservaCitaDTO> listaReservasCitaAReservaCitaDTO(List<ReservaCita> listaReservaCitas);

}
