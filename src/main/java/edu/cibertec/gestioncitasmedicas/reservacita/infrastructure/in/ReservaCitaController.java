package edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.reservacita.application.service.ReservaCitaService;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaCreateDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaDTO;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.dto.ReservaCitaUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/api/reservaCita")
public class ReservaCitaController {

    @Autowired
    private ReservaCitaService reservaCitaService;

    @GetMapping("/")
    public ResponseEntity<List<ReservaCitaDTO>> listarReservaCitas() {
        return new ResponseEntity<>(reservaCitaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarReservaCita(@PathVariable(value = "id") long id) {
        try {
            return new ResponseEntity<>(reservaCitaService.findByID(id), HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ReservaCitaCreateDTO> registrarReservaCita(@RequestBody ReservaCitaCreateDTO reservaCreateDTO) {
        return new ResponseEntity<>(reservaCitaService.save(reservaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ReservaCitaDTO> registrarReservaCita(@RequestBody ReservaCitaUpdateDTO reservaCitaUpdateDTO) {
        return new ResponseEntity<>(reservaCitaService.update(reservaCitaUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReservaCita(@PathVariable(value = "id") long id) {
        try {
            reservaCitaService.delete(id);
            return new ResponseEntity<>("Se elimino la cita reservada con id:" + id, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
