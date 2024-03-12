package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    
import com.proyectosgrt.demo.models.Sedes;
import com.proyectosgrt.demo.repository.Repository_Sedes;

@RestController

public class Sedes_Controller {

    @Autowired
    private Repository_Sedes rep;
    
    //Consulta Generica
    @GetMapping("/sedes")
    public String incio() {
        return "Conect";
    }

    //Consulta Sede
    @GetMapping("/sede")
    public List<Sedes> getSedes() {
        return rep.findAll();
    }

    //Creacion Sede
    @SuppressWarnings("null")
    @PostMapping("/addsede")
    public String add_sede(@RequestBody Sedes se){
            rep.save(se);
            return "Sede Add";
    }
}
