package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Solicitudes;
import com.proyectosgrt.demo.repository.Solicitudes_Repository;

@RestController
public class Solicitudes_controller {

    @Autowired
    private Solicitudes_Repository repo;

    @GetMapping("/s")
    public String incio() {
        return "Conect";
}
    @GetMapping("/solicitudes")
    public List<Solicitudes> getSolicitudes() {
        return repo.findAll();
    }

@SuppressWarnings("null")
    @PostMapping("/create_solicitud")
    public String create_solicitud(@RequestBody Solicitudes so) {
            repo.save(so);
            return "Solicitud Create";
    }
}