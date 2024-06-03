package br.com.apihospital.api_h.service;


import br.com.apihospital.api_h.enums.ExamsPatientStatusEnum;
import br.com.apihospital.api_h.model.Exames;
import br.com.apihospital.api_h.repository.ExamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExamesService {
    @Autowired
    ExamesRepository examesRepository;

    public void createExames(Exames exames){
        exames.setStatus(ExamsPatientStatusEnum.PENDENTE);
        examesRepository.save(exames);
    }

    public Optional<Exames> changeStateExames (Long id){
        Optional<Exames> examesFromDb = examesRepository.findById(id);
        if (examesFromDb.isPresent()){
            Exames examesRealization = examesFromDb.get();
            examesRealization.setStatus(ExamsPatientStatusEnum.REALIZADO);
            examesRepository.save(examesRealization);
        }
        return examesFromDb;
    }

    public Optional<Exames> cancelledStateExames (Long id){
        Optional<Exames> examesFromDb = examesRepository.findById(id);
        if (examesFromDb.isPresent()){
            Exames examesCancelled = examesFromDb.get();
            examesCancelled.setStatus(ExamsPatientStatusEnum.CANCELADO);
            examesRepository.save(examesCancelled);
        }
        return examesFromDb;
    }

    public List<Exames> findAll(){
        return examesRepository.findAll();
    }

    public Optional<Exames> findById(Long id){
        return examesRepository.findById(id);
    }

    public List<Exames> findByConsultaId(Long id){
        return  examesRepository.findByConsultaId(id);
    }



}
