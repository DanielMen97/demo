package com.proyectosgrt.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectosgrt.demo.models.Tiposactivo;
import com.proyectosgrt.demo.repository.Repository_TiposActivo;
import com.proyectosgrt.demo.controllers.Tiposactivo_Controller;


@RestController
public class Tiposactivo_Controller {

    @Autowired
    private Repository_TiposActivo rep;

    //Consulta Generica
    @GetMapping("/admintechnical/tiposact")
    public String tiposact() {
        return "Conect";
    }
    
    //Consulta Tiposctivo
    @GetMapping("/admintechnical/tiposacts")
    public List<Tiposactivo> geTiposact() {
        return rep.findAll();
    }
}


