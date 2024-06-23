package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.SedesDTO;
import com.proyectosgrt.demo.services.SedesServices;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Sedes_Controller {

  @Autowired
  SedesServices sedesServices;

  @GetMapping("/admin/sedes")
  public List<SedesDTO> getListRoles() {
      return sedesServices.getSedes();
  }
}
