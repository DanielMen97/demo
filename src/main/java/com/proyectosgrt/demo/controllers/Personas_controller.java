package com.proyectosgrt.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.repository.Repository_Personas;

@RestController
public class Personas_controller {

  @Autowired
  private Repository_Personas rep;

  @GetMapping("")
    public String incio() {
        return "Conect";
    }

  @GetMapping("/users")
    public List<Personas> getUsuario() {
        return rep.findAll();
    }

    @PostMapping("/create_user")
    public String create_user(@RequestBody Personas us) {
            rep.save(us);
            return "User Create";
    }

    //Crea un usuario validando documento

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Personas us) {
            Optional<Personas> res = rep.findPersonasBynodoc(us.getNodoc());
            HashMap<String, Object> datos = new HashMap<>();

              if(res.isPresent()) {
                datos.put("error", true);
                datos.put("mensaje", "El usuario ya esta creado");
                return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
              }
              rep.save(us); 
              datos.put("data", us);
              datos.put("mensaje", "El usuario fue creado correctamente");
              return new ResponseEntity<>(datos,HttpStatus.CREATED);

            }
        
           
} 



