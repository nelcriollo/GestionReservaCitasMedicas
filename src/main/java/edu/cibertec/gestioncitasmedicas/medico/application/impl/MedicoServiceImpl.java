package edu.cibertec.gestioncitasmedicas.medico.application.impl;

import edu.cibertec.gestioncitasmedicas.medico.application.service.MedicoService;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoCreateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoUpdateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.mapper.MedicoMapper;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import edu.cibertec.gestioncitasmedicas.medico.infrastructure.out.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    @Override
    public List<MedicoDTO> findAll() {
        return MedicoMapper.instancia.listaMedicosAMedicoDTO(medicoRepository.findAll());
    }

    @Override
    public MedicoDTO findByID(long id) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);

        if (!medicoOptional.isPresent()) {
            throw new NoResultException("No se encontro el médico con el id: " + id);
        } else {
            return MedicoMapper.instancia.medicoAMedicoDTO(medicoOptional.get());
        }
    }

    @Override
    public MedicoCreateDTO save(MedicoCreateDTO medicoCreateDTO) {
        Medico medico = MedicoMapper.instancia.medicoCreateDTOAMedico(medicoCreateDTO);
        return MedicoMapper.instancia.medicoAMedicoRegistradoDTO(medicoRepository.save(medico));
    }

    @Override
    public MedicoDTO update(MedicoUpdateDTO medicoUpdateDTO) {
        Medico medico = MedicoMapper.instancia.medicoUpdateDTOAMedico(medicoUpdateDTO);
        return MedicoMapper.instancia.medicoAMedicoDTO(medicoRepository.save(medico));
    }

    @Override
    public void delete(long id) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);

        if (!medicoOptional.isPresent()) {
            throw new NoResultException("No se encontro el médico con el id: " + id);
        } else {

            medicoRepository.delete(medicoOptional.get());
        }
    }

}
