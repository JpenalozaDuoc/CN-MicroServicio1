package ms_be_paciente.datos_paciente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ms_be_paciente.datos_paciente.model.Paciente;
import ms_be_paciente.datos_paciente.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
//Revisar si lleva el CrossOrigins
@CrossOrigin
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    // Obtener paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isPresent()) {
            return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    // Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteCreado = pacienteService.crearPaciente(paciente);
        return new ResponseEntity<>(pacienteCreado, HttpStatus.CREATED);
    }

  
    // Actualizar un paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteActualizado = pacienteService.updatePaciente(id, paciente);
        if (pacienteActualizado != null) {
            return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
