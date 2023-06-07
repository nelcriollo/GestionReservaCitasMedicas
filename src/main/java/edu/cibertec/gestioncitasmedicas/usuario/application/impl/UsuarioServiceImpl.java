package edu.cibertec.gestioncitasmedicas.usuario.application.impl;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.mapper.ReservaCitaMapper;
import edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out.ReservaCitaRepository;
import edu.cibertec.gestioncitasmedicas.usuario.application.service.UsuarioService;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.*;
import edu.cibertec.gestioncitasmedicas.usuario.domain.mapper.UsuarioMapper;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import edu.cibertec.gestioncitasmedicas.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaCitaRepository reservaCitaRepository;

    @Override
    public List<UsuarioDTO> findAll() {
        return UsuarioMapper.instancia.listaUsuariosAUsuariosDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioReservasDTO listarUsuariosConReservas(long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        UsuarioReservasDTO usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioReservasDTO(usuario);
        usuarioDTO.setReservasDtos(reservaCitaRepository.findByUsuario(usuario).stream()
                .map(ReservaCitaMapper.instancia::reservaCitaAReservaCitaDTO)
                .collect(Collectors.toList()));
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO findByID(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return UsuarioMapper.instancia.usarioAUsuarioDTO(usuarioOptional.get());
        } else {
            throw new NoResultException("No se encontro el usuario con id: " + id);
        }
    }

    @Override
    public UsuarioDTO save(UsuarioCreateDTO usuarioCreateDTO) {

        Usuario usuario = UsuarioMapper.instancia.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        return UsuarioMapper.instancia.usarioAUsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO update(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        return UsuarioMapper.instancia.usarioAUsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override
    public Usuario login(String email, String password) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailAndPassword(email, password);

        if (usuarioOptional.isPresent()) {
            return  usuarioOptional.get();
        } else {
            throw new NoResultException("No se encontro el usuario con username: " + email + " y password: " + password);
        }

    }


    @Override
    public void delete(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        usuarioOptional.ifPresent(usuario -> usuarioRepository.delete(usuario));
        throw new NoResultException("No se encontro el usuario con id: " + id);
    }
}
