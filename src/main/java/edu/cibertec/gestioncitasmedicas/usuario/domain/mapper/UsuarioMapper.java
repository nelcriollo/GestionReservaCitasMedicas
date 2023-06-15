package edu.cibertec.gestioncitasmedicas.usuario.domain.mapper;

import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioReservasDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioUpdateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usarioAUsuarioDTO(Usuario usuario);

    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);

    @Named("encodePassword")
    default String encodePassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    List<UsuarioDTO> listaUsuariosAUsuariosDTO(List<Usuario> listaUsuario);

    UsuarioReservasDTO usuarioAUsuarioReservasDTO(Usuario usuario);

}
