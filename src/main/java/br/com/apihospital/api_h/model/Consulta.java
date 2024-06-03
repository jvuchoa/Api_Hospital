package br.com.apihospital.api_h.model;

import br.com.apihospital.api_h.enums.ConsultationPatientStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appointmentDateTime;
    private String Description;

    @Enumerated(EnumType.STRING)
    private ConsultationPatientStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doutor doutor;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    Paciente paciente;


}
