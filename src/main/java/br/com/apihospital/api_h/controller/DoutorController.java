package br.com.apihospital.api_h.controller;

import br.com.apihospital.api_h.model.Doutor;
import br.com.apihospital.api_h.service.DoutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doutor")
@CrossOrigin(origins = "http://localhost:3000")

public class DoutorController {
    @Autowired
    DoutorService doutorService;



    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Doutor doutor){
        doutorService.create(doutor);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Doutor> findAll(){
        return doutorService.findAll();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updated(@RequestBody Doutor doutor, @PathVariable Long id){
        doutorService.updated(id, doutor);
    }



}
