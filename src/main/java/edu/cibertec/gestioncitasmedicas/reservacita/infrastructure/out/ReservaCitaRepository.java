package edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaCitaRepository extends JpaRepository<ReservaCita, Long> {
    List<ReservaCita> findByUsuario(Usuario usuario);

}
