package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Tiposdoc;
import com.proyectosgrt.demo.repository.Repository_Tiposdoc;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Tiposdoc_Controller {

  @Autowired
  private Repository_Tiposdoc tip;

  @CrossOrigin(origins = "http://localhost:3000/") 
  @GetMapping("/tiposdoc")
  public List<Tiposdoc> listTiposdoc() {
      return tip.findAll();
  }
  
}
