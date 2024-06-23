package com.proyectosgrt.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.Rol_ModulosDTO;
import com.proyectosgrt.demo.services.RolesModulosServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Rol_Modulos_Controller {

  @Autowired
  private RolesModulosServices rolesModulosServices;
  
  @GetMapping("/public/modulosxrol")
  public List<Rol_ModulosDTO> getRolModulos() {
      return rolesModulosServices.getListRolModulos(); 
  }


  
  
}
