package br.com.apihospital.api_h.controller;

import br.com.apihospital.api_h.model.Exames;
import br.com.apihospital.api_h.service.ExamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
@CrossOrigin(origins = "http://localhost:3000")

public class ExamesController {

    @Autowired
    ExamesService examesService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Exames exames){
        examesService.createExames(exames);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Exames> findAll(){
        return examesService.findAll();
    }

    @PutMapping("/changeStateExames/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Exames> changeStateExames(@PathVariable Long id){
        return examesService.changeStateExames(id);
    }

    @PutMapping("/cancellStateExames/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Exames> cancelledStateExames(@PathVariable Long id){
        return examesService.cancelledStateExames(id);
    }



    @GetMapping("/findexames/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Exames> findById(@PathVariable Long id){
        return examesService.findById(id);
    }


    @GetMapping("/findHistoryExams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Exames> findByConsultaId(@PathVariable Long id){
        return examesService.findByConsultaId(id);
    }

}
