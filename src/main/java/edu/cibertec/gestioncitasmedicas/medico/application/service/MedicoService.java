package edu.cibertec.gestioncitasmedicas.medico.application.service;

import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoCreateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoUpdateDTO;

import java.util.List;

public interface MedicoService {

    List<MedicoDTO> findAll();

    MedicoDTO findByID(long id);

    MedicoCreateDTO save(MedicoCreateDTO medicoCreateDTO);

    MedicoDTO update(MedicoUpdateDTO medicoUpdateDTO);

    void delete(long id);
}
