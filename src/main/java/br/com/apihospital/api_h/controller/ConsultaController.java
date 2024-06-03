package br.com.apihospital.api_h.controller;

import br.com.apihospital.api_h.model.Consulta;
import br.com.apihospital.api_h.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "http://localhost:3000")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody Consulta consulta){
        consultaService.create(consulta);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Consulta> findAll(){
        return consultaService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        consultaService.deleteConsulta(id);
    }



    @PutMapping("/changeState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Consulta> changeState(@PathVariable Long id){
        return consultaService.changeState(id);
    }

    @PutMapping("/cancelledState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Consulta> cancelledState(@PathVariable Long id){
        return consultaService.cancelledState(id);
    }
    //Doctor operational departament

    @GetMapping("/findhistorycpatient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Consulta> findHistoryPatientId(@PathVariable Long id){
        return consultaService.findHistoryPatientId(id);
    }




}
