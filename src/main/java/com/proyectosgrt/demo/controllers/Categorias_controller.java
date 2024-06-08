package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Categorias;
import com.proyectosgrt.demo.repository.Categorias_repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Categorias_controller {

    @Autowired
    private Categorias_repository repo;
    
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/categorias")
    public List<Categorias> getCategorias() {
        return repo.findAll();
    }
    
}
