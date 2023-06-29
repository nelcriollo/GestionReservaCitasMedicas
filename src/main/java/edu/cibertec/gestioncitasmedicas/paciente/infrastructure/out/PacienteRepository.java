package edu.cibertec.gestioncitasmedicas.paciente.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNroDocumento(String dni);
}
