package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.repository.Repository;

@RestController
public class Personas_controller {

  @Autowired
  private Repository rep;

  @GetMapping("")
    public String incio() {
        return "Conect";
    }

  @GetMapping("/users")
    public List<Personas> getUsuario() {
        return rep.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping("/create_user")
    public String create_user(@RequestBody Personas us) {
            rep.save(us);
            return "User Create";
    }

}
