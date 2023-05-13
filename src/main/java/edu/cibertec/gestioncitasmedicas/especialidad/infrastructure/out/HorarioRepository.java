package edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
