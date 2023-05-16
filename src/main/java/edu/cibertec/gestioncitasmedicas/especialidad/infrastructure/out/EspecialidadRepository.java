package edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
