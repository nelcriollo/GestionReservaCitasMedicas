package edu.cibertec.gestioncitasmedicas.medico.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.medico.application.service.MedicoService;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoCreateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.dto.MedicoUpdateDTO;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/")
    public ResponseEntity<List<MedicoDTO>> listarMedicos(){
        return new ResponseEntity<>(medicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedicoporID(@PathVariable( value = "id") long id){
        return new ResponseEntity<>(medicoService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<MedicoCreateDTO> registrarMedico(@RequestBody MedicoCreateDTO medicoCreateDTO){
        return new ResponseEntity<>(medicoService.save(medicoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<MedicoDTO> actualizarMedico(@RequestBody MedicoUpdateDTO medicoUpdateDTO){
        return new ResponseEntity<>(medicoService.update(medicoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable(value = "id") long id){
        try {
            medicoService.delete(id);
            return new ResponseEntity<>("Se elimino el médico con id:" + id, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
