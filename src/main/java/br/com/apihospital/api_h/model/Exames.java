package br.com.apihospital.api_h.model;

import br.com.apihospital.api_h.enums.ExamsPatientStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Exames {



    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String typeOfExams;
    private String description;

    private String result;

    private String DateTime;

    @Enumerated(EnumType.STRING)
    private ExamsPatientStatusEnum status;


    @ManyToOne
    @JoinColumn(name = "consultation_id")
    Consulta consulta;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTypeOfExams() {
        return typeOfExams;
    }

    public void setTypeOfExams(String typeOfExams) {
        this.typeOfExams = typeOfExams;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public ExamsPatientStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ExamsPatientStatusEnum status) {
        this.status = status;
    }

    public Consulta getConsultation() {
        return consulta;
    }

}
