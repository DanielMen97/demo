package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Sedes;
import com.proyectosgrt.demo.repository.Repository_Sedes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Sedes_Controller {

@Autowired
private Repository_Sedes sed;

@CrossOrigin(origins = "http://localhost:3000/") 
@GetMapping("/sedes")
public List<Sedes> listSedes() {
    return sed.findAll();
}
}
