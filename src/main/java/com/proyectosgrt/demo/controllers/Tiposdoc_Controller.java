package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectosgrt.demo.DTO.TiposdocDTO;
import com.proyectosgrt.demo.services.TiposdocServices;

@RestController
public class Tiposdoc_Controller {

  @Autowired
  TiposdocServices tiposdocServices;

  @GetMapping("/admin/tiposdoc")
  public List<TiposdocDTO> getListTiposdoc() {
      return tiposdocServices.getTiposdoc();
  }
}
