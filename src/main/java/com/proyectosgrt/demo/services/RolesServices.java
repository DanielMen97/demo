package com.proyectosgrt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.DTO.Rol_ModulosDTO;
import com.proyectosgrt.demo.repository.Repository_Rol_Modulos;

@Service
public class RolesServices {

  @Autowired
  Repository_Rol_Modulos repository_Rol_Modulos;
  
  public List<Rol_ModulosDTO> getListRolModulos(){
    List<Rol_ModulosDTO> listaRolesModulos = repository_Rol_Modulos.getListRolModulos();
    return listaRolesModulos;
  }
  
}
