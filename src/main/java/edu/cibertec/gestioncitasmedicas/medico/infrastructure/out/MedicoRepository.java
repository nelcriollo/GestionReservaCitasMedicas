package edu.cibertec.gestioncitasmedicas.medico.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
