package br.com.apihospital.api_h.service;

import br.com.apihospital.api_h.enums.ConsultationPatientStatusEnum;
import br.com.apihospital.api_h.model.Consulta;
import br.com.apihospital.api_h.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public void create (Consulta consulta){
        consulta.setStatus(ConsultationPatientStatusEnum.CONFIRMADA);
        consultaRepository.save(consulta);
    }

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Optional<Consulta> changeState(Long id){
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);
        if (optionalConsulta.isPresent()){ // Verifica se a consulta está presente
            Consulta existingConsulta = optionalConsulta.get();
            existingConsulta.setStatus(ConsultationPatientStatusEnum.CONCLUIDA);
            consultaRepository.save(existingConsulta);
        }
        return optionalConsulta;
    }

    public Optional<Consulta> cancelledState(Long id){
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);
        if (optionalConsulta.isPresent()){
            Consulta cancellConsulta = optionalConsulta.get();
            cancellConsulta.setStatus(ConsultationPatientStatusEnum.CANCELADA);
            consultaRepository.save(cancellConsulta);
        }
        return optionalConsulta;
    }

    public Optional<Consulta> findById(Long id){
        return consultaRepository.findById(id);
    }

    public void deleteConsulta(Long id){
        consultaRepository.deleteById(id);
    }

    //Doctor departament
    public List<Consulta> findHistoryPatientId(Long id){
        return consultaRepository.findByPacienteId(id);
    }
}

