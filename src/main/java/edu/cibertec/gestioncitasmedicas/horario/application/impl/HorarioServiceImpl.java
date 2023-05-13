package edu.cibertec.gestioncitasmedicas.horario.application.impl;

import edu.cibertec.gestioncitasmedicas.horario.application.service.HorarioService;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.mapper.HorarioMapper;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.infraestructure.out.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    private HorarioMapper horarioMapper = HorarioMapper.INSTANCE;


    @Override
    public HorarioDTO find(Long id_horario) {
    Optional<Horario> horario = horarioRepository.findById(id_horario);
    if (horario.isPresent()){
        return horarioMapper.horarioAHorarioDTO(horario.get());
    }
    throw new RuntimeException();

    }


    @Override
    public List<HorarioDTO> findAll() {
        return horarioMapper.listaHorarioAHorarioDTO(horarioRepository.findAll());
    }

    @Override
    public HorarioDTO save(HorarioDTO horarioDTO) {
        return horarioMapper.horarioAHorarioDTO(horarioRepository.save(horarioMapper.horarioDTOAHorario(horarioDTO)));
    }

    @Override
    public void delete(Long id_horario) {
        horarioRepository.deleteById(id_horario);
    }
}