package edu.cibertec.gestioncitasmedicas.horario.infraestructure.out;

import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
