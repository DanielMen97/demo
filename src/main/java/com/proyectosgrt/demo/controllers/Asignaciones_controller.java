package com.proyectosgrt.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Activos;
import com.proyectosgrt.demo.models.Asignaciones;
import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.repository.Repository_Asignaciones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Asignaciones_controller {

    @Autowired
    private Repository_Asignaciones asg;

    @GetMapping("/asignacionactivo")
    public List<Asignaciones> asignacionActivo() {
        return asg.findAll();
    }

    @PostMapping("/asignaractivo")
    public ResponseEntity<Object> asignarActivo(@RequestBody Asignaciones as) {
        HashMap<String, Object> datos = new HashMap<>();

        return new ResponseEntity<>(datos,HttpStatus.CREATED);
    }
    

}
