package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.RolesDTO;
import com.proyectosgrt.demo.models.Roles;

public interface Repository_Roles extends JpaRepository<Roles, String>{

  @Query("SELECT new com.proyectosgrt.demo.DTO.RolesDTO (roles.rol) FROM Roles roles")
  List<RolesDTO> getListRoles();


}
