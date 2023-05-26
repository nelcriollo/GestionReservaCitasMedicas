package edu.cibertec.gestioncitasmedicas.horario.application.impl;

import edu.cibertec.gestioncitasmedicas.horario.application.service.HorarioService;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioUpdateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.mapper.HorarioMapper;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.infrastructure.out.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    private HorarioMapper horarioMapper = HorarioMapper.INSTANCE;

    @Override
    public List<HorarioDTO> findAll() {
        return horarioMapper.listaHorarioAHorarioDTO(horarioRepository.findAll());
    }

    @Override
    public HorarioDTO findById(long id_horario) {
        Optional<Horario> horario = horarioRepository.findById(id_horario);
        if (!horario.isPresent()) {
            throw new NoResultException("No se encontro el especialista con el id : " + id_horario);
        } else {
            return horarioMapper.horarioAHorarioDTO(horario.get());
        }

    }

    @Override
    public HorarioCreateDTO save(HorarioCreateDTO horarioCreateDTO) {
        Horario horario = HorarioMapper.INSTANCE.horarioCreateDTOHorario(horarioCreateDTO);
        return HorarioMapper.INSTANCE.horarioAHorarioRegitrarDTO(horarioRepository.save(horario));
    }

    @Override
    public HorarioDTO update(HorarioUpdateDTO horarioUpdateDTO) {
        Horario horario = HorarioMapper.INSTANCE.horarioUpdateDTOAHorario(horarioUpdateDTO);
        return HorarioMapper.INSTANCE.horarioAHorarioDTO(horarioRepository.save(horario));
    }

    @Override
    public void delete(Long id_horario) {
        Optional<Horario> horario = horarioRepository.findById(id_horario);

        if (!horario.isPresent()) {
            throw new NoResultException("No se encontro el especialista con el id: " + id_horario);

        } else {
            horarioRepository.delete(horario.get());
        }
    }
}
