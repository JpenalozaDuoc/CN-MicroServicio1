package ms_be_paciente.datos_paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ms_be_paciente.datos_paciente.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{

}
