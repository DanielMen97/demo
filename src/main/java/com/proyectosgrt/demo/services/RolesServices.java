package com.proyectosgrt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.repository.Repository_Roles;

import com.proyectosgrt.demo.DTO.RolesDTO;

@Service
public class RolesServices {

  @Autowired
  Repository_Roles repository_Roles;

  public List<RolesDTO> getRoles(){
    List<RolesDTO> roles = repository_Roles.getListRoles();
    return roles;
  }

}
