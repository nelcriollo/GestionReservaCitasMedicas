package edu.cibertec.gestioncitasmedicas.springsecurity.application;


import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import edu.cibertec.gestioncitasmedicas.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Usuario usuario = usuarioRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException("el usuario con  email" + email +" no existe"));
        return new UserDetailsImpl(usuario);
    }
}
