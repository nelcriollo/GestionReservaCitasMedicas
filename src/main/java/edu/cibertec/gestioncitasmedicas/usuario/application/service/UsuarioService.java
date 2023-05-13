package edu.cibertec.gestioncitasmedicas.usuario.application.service;

import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioReservasDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> findAll();

    UsuarioReservasDTO listarUsuariosConReservas(long id);

    UsuarioDTO findByID(long id);

    UsuarioDTO save(UsuarioCreateDTO usuarioCreateDTO);

    UsuarioDTO update(UsuarioUpdateDTO usuarioUpdateDTO);

    void delete(long id);
}
