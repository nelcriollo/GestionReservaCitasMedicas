package edu.cibertec.gestioncitasmedicas.usuario.domain.mapper;

import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioReservasDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioUpdateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usarioAUsuarioDTO(Usuario usuario);

    Usuario usarioDTOAUsuario(UsuarioDTO usuarioDTO);

    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);

    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    List<UsuarioDTO> listaUsuariosAUsuariosDTO(List<Usuario> listaUsuario);

    UsuarioReservasDTO usuarioAUsuarioReservasDTO(Usuario usuario);

}
