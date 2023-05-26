package edu.cibertec.gestioncitasmedicas.horario.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.horario.application.service.HorarioService;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioDTO;
import edu.cibertec.gestioncitasmedicas.horario.domain.dto.HorarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;


@RestController
@RequestMapping(value = "api/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<HorarioDTO>> lista() {
        return new ResponseEntity<>(horarioService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id_horario}", method = RequestMethod.GET)
    public ResponseEntity<HorarioDTO> obtener(@PathVariable(name = "id_horario") long id_horario) {
        return new ResponseEntity<>(horarioService.findById(id_horario), HttpStatus.OK);
    }


    @PostMapping(value = "/")
    public ResponseEntity<HorarioCreateDTO> guardar(@RequestBody HorarioCreateDTO horarioCreateDTO) {
        return new ResponseEntity<>(horarioService.save(horarioCreateDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<HorarioDTO> actualizar(@RequestBody HorarioUpdateDTO horarioUpdateDTO) {
        return new ResponseEntity<>(horarioService.update(horarioUpdateDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_horario}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminar(@PathVariable(name = "id_horario") long id_horario) {
        try {
            horarioService.delete(id_horario);
            return new ResponseEntity<>("Se elimino la especialidad con id : " + id_horario, HttpStatus.OK);

        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
