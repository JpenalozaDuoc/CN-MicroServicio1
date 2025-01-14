package ms_be_paciente.datos_paciente.service;

import java.util.List;
import java.util.Optional;

import ms_be_paciente.datos_paciente.model.Paciente;

public interface PacienteService {

    //obtener todos los pacientes
    List<Paciente> getAllPacientes();
    
    //obtener paciente por id
    Optional<Paciente> getPacienteById(Long id);

    //Crear nuevos pacientes
    Paciente crearPaciente(Paciente paciente);

    //Actualizar datos del pacientes
    Paciente updatePaciente(Long id, Paciente paciente);

    //Borrar Paciente - No deberiamos usar un Borrar.
    void deletePaciente(Long id);
}
