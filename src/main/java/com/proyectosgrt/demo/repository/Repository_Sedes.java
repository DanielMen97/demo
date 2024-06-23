package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.SedesDTO;
import com.proyectosgrt.demo.models.Sedes;

public interface Repository_Sedes extends JpaRepository<Sedes, Integer> {

  @Query("SELECT new com.proyectosgrt.demo.DTO.SedesDTO (sedes.idsede, sedes.nombre) FROM Sedes sedes")
  List<SedesDTO> getListSedes();

  

}
