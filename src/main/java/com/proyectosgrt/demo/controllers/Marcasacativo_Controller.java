package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Marcasactivo;
import com.proyectosgrt.demo.repository.Repository_Marcasctivo;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Marcasacativo_Controller {

    @Autowired
    private Repository_Marcasctivo rep;

    //Consulta Generica
    @GetMapping("/admintechnical/marca")
    public String marcasact() {
        return "Conect";
    }
    
    // Consulta MarcasActivo
    @GetMapping("/admintechnical/marcasact")
    public List<Marcasactivo> getMarcasact(){
        return rep.findAll();
    }
}

