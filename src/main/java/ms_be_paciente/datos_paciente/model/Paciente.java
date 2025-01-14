package ms_be_paciente.datos_paciente.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "patients")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_admission")
    private LocalDateTime dateOfAdmission;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructor sin parámetros (esto es lo que Hibernate necesita)
    public Paciente() {
        // Constructor vacío necesario para la instanciación de Hibernate
    }
    

    public Paciente(Long patientId, String name, LocalDateTime birthDate, String diagnosis, String status,
            LocalDateTime dateOfAdmission, LocalDateTime updatedAt) {
        this.patientId = patientId;
        this.name = name;
        this.birthDate = birthDate;
        this.diagnosis = diagnosis;
        this.status = status;
        this.dateOfAdmission = dateOfAdmission;
        this.updatedAt = updatedAt;
    }


    @PrePersist
    protected void onCreate() {
        dateOfAdmission = LocalDateTime.now();
    }
}
