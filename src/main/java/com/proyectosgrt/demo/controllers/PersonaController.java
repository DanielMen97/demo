package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.PersonasDTO;
import com.proyectosgrt.demo.DTO.RolesDTO;
import com.proyectosgrt.demo.DTO.TablaPersonasDTO;
import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.services.PersonasManagementService;

@RestController
public class PersonaController {

  @Autowired
  private PersonasManagementService personasManagementService;

  @PostMapping("/auth/create")
   public ResponseEntity<Personas> createUser(@RequestBody PersonasDTO dto) {
    Personas createdPersonas = personasManagementService.createUser(dto);
    return ResponseEntity.ok(createdPersonas);
  }

  @PostMapping("/auth/login")
  public ResponseEntity<PersonasDTO> loginUser(@RequestBody PersonasDTO dto) {
    PersonasDTO loginPersonas = personasManagementService.login(dto);
      return ResponseEntity.ok(loginPersonas);
  }

  @GetMapping("/admin/listaroles")
  public List<RolesDTO> listaRoles(){
    return personasManagementService.getListRoles();
  }

  @GetMapping("/admin/listatablapersonas")
  public List<TablaPersonasDTO> listaTablaPersonas(){
    return personasManagementService.getListTablaPersonas();
  }
  

  @GetMapping("/public/hola")
  public String hola(){
    return personasManagementService.prueba();
  }

  @PostMapping("/admin/hola2")
  public String postMethodName() {
      
      return personasManagementService.prueba2();
  }
  
}
