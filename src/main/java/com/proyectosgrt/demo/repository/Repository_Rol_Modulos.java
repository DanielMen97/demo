package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.Rol_ModulosDTO;
import com.proyectosgrt.demo.models.Rol_Modulos;

public interface Repository_Rol_Modulos extends JpaRepository<Rol_Modulos, Integer>{

  @Query("SELECT new com.proyectosgrt.demo.DTO.Rol_ModulosDTO (rm.rolid, m.id, m.label, m.icon, m._to) FROM Rol_Modulos rm INNER JOIN Modulos m on rm.moduloid = m.id")
    List<Rol_ModulosDTO> getListRolModulos();
  
}
