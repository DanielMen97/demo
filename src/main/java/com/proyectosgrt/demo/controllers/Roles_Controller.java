package com.proyectosgrt.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.RolesDTO;
import com.proyectosgrt.demo.services.RolesServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Roles_Controller {

  @Autowired
  RolesServices rolesServices;

  @GetMapping("/admin/roles")
  public List<RolesDTO> getListRoles() {
      return rolesServices.getRoles();
  }
  
}
