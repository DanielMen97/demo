package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Categorias;
import com.proyectosgrt.demo.repository.Categorias_repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Categorias_controller {

    @Autowired
    private Categorias_repository repo;

    @GetMapping("/categorias")
    public List<Categorias> getCategorias() {
        return repo.findAll();
    }
    
}
