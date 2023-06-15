package edu.cibertec.gestioncitasmedicas.usuario.infrastructure.in;

import edu.cibertec.gestioncitasmedicas.usuario.application.service.UsuarioService;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioCreateDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioReservasDTO;
import edu.cibertec.gestioncitasmedicas.usuario.domain.dto.UsuarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import java.util.List;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/usuariosReservas/{id}")
    public ResponseEntity<UsuarioReservasDTO> listarUsuariosconReservas(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(usuarioService.listarUsuariosConReservas(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorID(@PathVariable(value = "id") long id) {
        try {
            return new ResponseEntity<>(usuarioService.findByID(id), HttpStatus.OK);
        } catch (NoResultException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return new ResponseEntity<>(usuarioService.save(usuarioCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {

        return new ResponseEntity<>(usuarioService.update(usuarioUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>("Se elimino correctamente el usuario con id: " + id, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }
}
