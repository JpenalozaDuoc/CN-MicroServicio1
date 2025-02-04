package ms_be_paciente.datos_paciente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_be_paciente.datos_paciente.model.Paciente;
import ms_be_paciente.datos_paciente.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        if(pacienteRepository.existsById(id)){
            paciente.setPatientId(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}
