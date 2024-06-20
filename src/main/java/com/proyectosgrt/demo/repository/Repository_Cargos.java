package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.CargosDTO;
import com.proyectosgrt.demo.models.Cargos;

public interface Repository_Cargos extends JpaRepository<Cargos, Integer>{

  @Query("SELECT new com.proyectosgrt.demo.DTO.CargosDTO (cargos.idcargo, cargos.nombre) FROM Cargos cargos")
  List<CargosDTO> getListCargos();

}
