package br.com.apihospital.api_h.controller;

import br.com.apihospital.api_h.model.Paciente;
import br.com.apihospital.api_h.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "http://localhost:3000")

public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody Paciente paciente){
        pacienteService.create(paciente);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updated( @RequestBody Paciente paciente, @PathVariable Long id){
        pacienteService.updated(id, paciente);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        pacienteService.deleteById(id);
    }

}



