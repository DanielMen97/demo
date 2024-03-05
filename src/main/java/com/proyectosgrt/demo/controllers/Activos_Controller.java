package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Activos;
import com.proyectosgrt.demo.repository.Repository_Activos;

@RestController

public class Activos_Controller {

    @Autowired
    private Repository_Activos rep;

    @GetMapping("/act")
    public String incio() {
        return "Conect";
    }

    @GetMapping("/acts")
    public List<Activos> getActivos() {
        return rep.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping("/add_act")
    public String add_act(@RequestBody Activos ac) {
            rep.save(ac);
            return "Active Add";
    }
}






