package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.CargosDTO;
import com.proyectosgrt.demo.services.CargosServices;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Cargos_Controller {

  @Autowired
  CargosServices cargosServices;

  @GetMapping("/admin/cargos")
  public List<CargosDTO> getMethodName() {
      return cargosServices.getCargos();
  }
  

  
  
}
