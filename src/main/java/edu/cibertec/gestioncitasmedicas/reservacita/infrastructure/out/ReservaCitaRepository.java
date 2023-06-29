package edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaCitaRepository extends JpaRepository<ReservaCita, Long> {
    List<ReservaCita> findByUsuario(Usuario usuario);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
            "FROM ReservaCita r " +
            "JOIN r.horario h " +
            "JOIN r.paciente p " +
            "WHERE h.fechaRegistro = :fecha " +
            "AND h.especialidad.idEspecialidad = :especialidadId " +
            "AND p.idPaciente = :pacienteId")
    boolean existsReservasCitaByFechaAndEspecialidadAndPaciente(
            @Param("fecha") LocalDate fecha,
            @Param("especialidadId") Long especialidadId,
            @Param("pacienteId") Long pacienteId);


 }
