package edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.especialidad.application.service.HorarioService;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.HorarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;
    @RequestMapping(value = "/{id_horario}", method = RequestMethod.GET)
    public ResponseEntity<HorarioDTO> obtener(@PathVariable(name = "id_horario") long id_horario) {
        return new ResponseEntity<>(horarioService.find(id_horario), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<HorarioDTO>> lista() {
        return new ResponseEntity<>(horarioService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<HorarioDTO> guardar(@RequestBody HorarioDTO horarioDTO) {
        return new ResponseEntity<>(horarioService.save(horarioDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<HorarioDTO> actualizar(@RequestBody HorarioDTO horarioDTO) {
        return new ResponseEntity<>(horarioService.save(horarioDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_horario}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_horario") long id_horario) {
        horarioService.delete(id_horario);
    }
}
