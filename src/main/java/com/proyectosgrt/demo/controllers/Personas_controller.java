package com.proyectosgrt.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.repository.Repository_Personas;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class Personas_controller {

  @Autowired
  private Repository_Personas rep;

  @GetMapping("")
    public String incio() {
        return "Conect";
    }
  @CrossOrigin(origins = "http://localhost:3000/")  
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

    //Crea un usuario validando documento
    @CrossOrigin(origins = "http://localhost:3000/")  
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Personas us) {
            Optional<Personas> res = rep.findPersonasBynodoc(us.getNodoc());
            Optional<Personas> resc = rep.findByCorreo(us.getCorreo());
            HashMap<String, Object> datos = new HashMap<>();

              if(res.isPresent()) {
                datos.put("error", true); 
                datos.put("mensaje", "El usuario ya esta creado");
                return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
              } else if (resc.isPresent()) {
                datos.put("error", true); 
                datos.put("mensaje", "El correo ya se encuentra registrado");
                return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
              }
              rep.save(us); 
              datos.put("data", us);
              datos.put("mensaje", "El usuario fue creado correctamente");
              return new ResponseEntity<>(datos,HttpStatus.CREATED);
            }

    @PutMapping("edituser/{nodoc}")
    public String editUser(@PathVariable String nodoc, @RequestBody Personas us) {
        @SuppressWarnings("null")
        Personas actualizarUsuario = rep.findById(nodoc).get();
        actualizarUsuario.setPnom(us.getPnom());
        actualizarUsuario.setSnom(us.getSnom());
        actualizarUsuario.setPape(us.getPape());
        actualizarUsuario.setSape(us.getSape());
        actualizarUsuario.setCorreo(us.getCorreo());
        actualizarUsuario.setCelular(us.getCelular());
        actualizarUsuario.setPass(us.getPass());
        actualizarUsuario.setIdrol(us.getIdrol());
        actualizarUsuario.setIdcargo(us.getIdcargo());
        actualizarUsuario.setIdsede(us.getIdsede());
        actualizarUsuario.setIddoc(us.getIddoc());
        actualizarUsuario.setEstado(us.isEstado());
        rep.save(actualizarUsuario);

        return "Información de usuario Actualizado";
    }
    
        
           




