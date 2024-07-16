package com.proyectosgrt.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.DTO.ListPersonasDTO;
import com.proyectosgrt.demo.DTO.ListaTecnicosDTO;
import com.proyectosgrt.demo.DTO.TablaPersonasDTO;
import com.proyectosgrt.demo.DTO.UserDTO;

public interface Repository_Personas extends JpaRepository<Personas, String> {

  Optional<Personas> findByCorreo(String correo);

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaPersonasDTO (personas.nodoc, personas.pnom, personas.snom, personas.pape, personas.sape, cargos.nombre, sedes.nombre, personas.correo, personas.celular, personas.estado) FROM Personas personas INNER JOIN Cargos cargos ON personas.idcargo = cargos.idcargo INNER JOIN Sedes sedes ON personas.idsede = sedes.idsede")
  List<TablaPersonasDTO> getListTablePersonas();

  @Query("SELECT new com.proyectosgrt.demo.DTO.ListPersonasDTO(personas.nodoc, personas.pnom, personas.pape) FROM Personas personas")
  List<ListPersonasDTO> getAllPersonas();

  @Query("SELECT new com.proyectosgrt.demo.DTO.ListaTecnicosDTO (personas.nodoc, personas.pnom, personas.pape) FROM Personas personas WHERE personas.role = 'TECHNICAL'")
  List<ListaTecnicosDTO> getListTecnicos();

  @Query("SELECT new com.proyectosgrt.demo.DTO.UserDTO (personas.nodoc, personas.pnom, personas.snom, personas.pape, personas.sape, personas.celular, personas.correo, personas.idsede, personas.iddoc, personas.idcargo, personas.role, personas.estado) FROM Personas personas WHERE personas.nodoc = ?1")
  UserDTO getUserDTO(String nodoc);

}
