package edu.cibertec.gestioncitasmedicas.usuario.application.service;

import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.*;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> findAll();

    UsuarioReservasDTO listarUsuariosConReservas(long id);

    UsuarioDTO findByID(long id);

    UsuarioDTO save(UsuarioCreateDTO usuarioCreateDTO);

    UsuarioDTO update(UsuarioUpdateDTO usuarioUpdateDTO);

    Usuario login(String email, String password);
    void delete(long id);
}
