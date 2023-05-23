package edu.cibertec.gestioncitasmedicas.paciente.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.paciente.application.service.PacienteService;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteCreateDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteDTO;
import edu.cibertec.gestioncitasmedicas.paciente.domain.dto.PacienteUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @RequestMapping(value = "/{id_paciente}", method = RequestMethod.GET)
    public ResponseEntity<PacienteDTO> obtener(@PathVariable(name = "id_paciente") long id_paciente) {
        return new ResponseEntity<>(pacienteService.find(id_paciente), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> lista() {
        return new ResponseEntity<>(pacienteService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<PacienteCreateDTO> guardar(@RequestBody PacienteCreateDTO pacienteCreateDTO) {
        return new ResponseEntity<>(pacienteService.save(pacienteCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/")
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteUpdateDTO pacienteUpdateDTO) {
        return new ResponseEntity<>(pacienteService.update(pacienteUpdateDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_paciente}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_paciente") long id_paciente) {
        pacienteService.delete(id_paciente);
    }


}
