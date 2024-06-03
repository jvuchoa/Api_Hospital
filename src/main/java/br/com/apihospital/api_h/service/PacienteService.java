package br.com.apihospital.api_h.service;

import br.com.apihospital.api_h.model.Paciente;
import br.com.apihospital.api_h.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public void create(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findByid(Long id){
        return pacienteRepository.findById(id);
    }

    public void updated(Long id, Paciente patient){
        Optional<Paciente> pacienteFromDb = findByid(id);

        if(pacienteFromDb.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Paciente pacienteUpdated = pacienteFromDb.get();


        pacienteRepository.save(pacienteUpdated);
    }

    public void deleteById(Long id){
        pacienteRepository.deleteById(id);
    }
}


