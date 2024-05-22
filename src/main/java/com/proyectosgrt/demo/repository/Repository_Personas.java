package com.proyectosgrt.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.models.Personas;

import com.proyectosgrt.demo.DTO.RolesDTO;
import com.proyectosgrt.demo.DTO.TablaPersonasDTO;

public interface Repository_Personas extends JpaRepository<Personas, String>{

  Optional<Personas> findByCorreo(String correo);

  @Query("SELECT DISTINCT new com.proyectosgrt.demo.DTO.RolesDTO (personas.rol) FROM Personas personas")
  List<RolesDTO> getListRoles();

 @Query("SELECT new com.proyectosgrt.demo.DTO.TablaPersonasDTO (tiposdoc.tipo, personas.nodoc, personas.pnom, personas.snom, personas.pape, personas.sape, cargos.nombre, sedes.nombre, personas.rol, personas.correo, personas.celular, personas.estado) FROM Personas personas INNER JOIN Cargos cargos ON personas.idcargo = cargos.idcargo INNER JOIN Tiposdoc tiposdoc ON personas.iddoc = tiposdoc.iddoc INNER JOIN Sedes sedes ON personas.idsede = sedes.idsede")
 List<TablaPersonasDTO> getListTablePersonas();

}
