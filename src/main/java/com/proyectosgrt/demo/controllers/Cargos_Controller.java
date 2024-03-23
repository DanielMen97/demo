package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Cargos;
import com.proyectosgrt.demo.repository.Repository_Cargos;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Cargos_Controller {

  @Autowired
  private Repository_Cargos carg;

  @CrossOrigin(origins = "http://localhost:3000/")
  @GetMapping("/cargos")
  public List<Cargos> listCargos() {
      return carg.findAll();
  }
  

}
