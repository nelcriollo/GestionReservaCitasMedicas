package edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.especialidad.application.service.EspecialidadService;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/especialidad")
public class EspecialidadController {


    @Autowired
    private EspecialidadService especialidadService;


    @RequestMapping(value = "/{id_especialidad}", method = RequestMethod.GET)
    public ResponseEntity<EspecialidadDTO> obtener(@PathVariable(name = "id_especialidad") long id_especialidad) {
        return new ResponseEntity<>(especialidadService.find(id_especialidad), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<EspecialidadDTO>> lista() {
        return new ResponseEntity<>(especialidadService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<EspecialidadDTO> guardar(@RequestBody EspecialidadDTO asesorDTO) {
        return new ResponseEntity<>(especialidadService.save(asesorDTO), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<EspecialidadDTO> actualizar(@RequestBody EspecialidadDTO asesorDTO) {
        return new ResponseEntity<>(especialidadService.save(asesorDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id_especialidad}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable(name = "id_especialidad") long id_especialidad) {
        especialidadService.delete(id_especialidad);
    }


}