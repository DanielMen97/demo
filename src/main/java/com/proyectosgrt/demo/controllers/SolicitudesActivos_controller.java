package com.proyectosgrt.demo.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Asignaciones;
import com.proyectosgrt.demo.models.SolicitudesActivo;
import com.proyectosgrt.demo.repository.SolicitudesActivos_Repository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SolicitudesActivos_controller {

    @Autowired
    private SolicitudesActivos_Repository repo;

    @GetMapping("/asgsolact")
    public List<SolicitudesActivo> ListSolicitudesActivo() {
        return repo.findAll();
    }
    

     @PostMapping("/SolicitudesActivos")
    public ResponseEntity<Object> SolActivo(@RequestBody SolicitudesActivo as) {
        HashMap<String, Object> datos = new HashMap<>();

        repo.save(as);
        datos.put("data", as);
        datos.put("message", "El activo se asigno correctamente a la solicitud");
        return new ResponseEntity<>(datos,HttpStatus.CREATED);
    }


}
