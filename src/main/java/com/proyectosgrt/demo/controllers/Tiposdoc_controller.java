package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Tiposdoc;
import com.proyectosgrt.demo.repository.Tiposdoc_repository;

@RestController
public class Tiposdoc_controller {

    @Autowired
    private Tiposdoc_repository repo;

 @GetMapping("/tiposdoc")
    public List<Tiposdoc> getTiposdocs() {
        return repo.findAll();
    }

@SuppressWarnings("null")
@PostMapping("/create_tiposdoc")
    public String create_tiposdocd(@RequestBody Tiposdoc ti) {
            repo.save(ti);
            return "Tiposdoc Create";
}
}
