package edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.in;


import edu.cibertec.gestioncitasmedicas.especialidad.application.service.EspecialidadService;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadCreateDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadDTO;
import edu.cibertec.gestioncitasmedicas.especialidad.domain.dto.EspecialidadUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("api/especialidad")
public class EspecialidadController {


    @Autowired
    private EspecialidadService especialidadService;


    @GetMapping(value = "/")
    public ResponseEntity<List<EspecialidadDTO>> lista() {
        return new ResponseEntity<>(especialidadService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id_especialidad}", method = RequestMethod.GET)
    public ResponseEntity<EspecialidadDTO> obtener(@PathVariable(name = "id_especialidad") long id_especialidad) {
        return new ResponseEntity<>(especialidadService.findById(id_especialidad), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<EspecialidadCreateDTO> guardar(@RequestBody EspecialidadCreateDTO especialidadCreateDTO) {
        return new ResponseEntity<>(especialidadService.save(especialidadCreateDTO), HttpStatus.CREATED);

    }

    @PutMapping(value = "/")
    public ResponseEntity<EspecialidadDTO> actualizar(@RequestBody EspecialidadUpdateDTO especialidadUpdateDTO) {
        return new ResponseEntity<>(especialidadService.update(especialidadUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{idEspecialidad}")
    public ResponseEntity<?> eliminar(@PathVariable(value = "idEspecialidad") long idEspecialidad) {


        try {
            especialidadService.delete(idEspecialidad);
            return new ResponseEntity<>("Se elimino la especialidad con id : " + idEspecialidad, HttpStatus.OK);

        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}