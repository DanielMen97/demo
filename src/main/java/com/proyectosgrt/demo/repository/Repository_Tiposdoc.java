package com.proyectosgrt.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.TiposdocDTO;
import com.proyectosgrt.demo.models.Tiposdoc;

public interface Repository_Tiposdoc extends JpaRepository<Tiposdoc, Integer>{

  @Query("SELECT new com.proyectosgrt.demo.DTO.TiposdocDTO (tiposdoc.iddoc, tiposdoc.tipo) FROM Tiposdoc tiposdoc")
  List<TiposdocDTO> getListTiposdoc();

}
