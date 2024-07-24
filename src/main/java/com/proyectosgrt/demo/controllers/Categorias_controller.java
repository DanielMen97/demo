package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Categorias;
import com.proyectosgrt.demo.repository.Categorias_repository;

@RestController
public class Categorias_controller {

    @Autowired
    private Categorias_repository repo;

    @GetMapping("/adminuser/categorias")
    public List<Categorias> getCategorias() {
        return repo.findAll();
    }
    
}
