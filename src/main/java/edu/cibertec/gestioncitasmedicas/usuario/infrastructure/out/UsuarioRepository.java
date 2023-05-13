package edu.cibertec.gestioncitasmedicas.usuario.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
