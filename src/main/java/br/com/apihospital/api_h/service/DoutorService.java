package br.com.apihospital.api_h.service;

import br.com.apihospital.api_h.model.Doutor;
import br.com.apihospital.api_h.repository.DoutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoutorService {

    @Autowired
    DoutorRepository doutorRepository;

    public void create (Doutor doutor){
        doutorRepository.save(doutor);
    }

    public List<Doutor> findAll(){
        return doutorRepository.findAll();
    }

    public Optional<Doutor> findById(Long id){
        return doutorRepository.findById(id);
    }

    public void deleteById(Long id){
        doutorRepository.deleteById(id);
    }

    public void updated(Long id, Doutor doutor){
        Optional<Doutor> doutorFromDB = findById(id);

        if (doutorFromDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Doutor doutorUpdated = doutorFromDB.get();



        doutorRepository.save(doutorUpdated);
    }
}
