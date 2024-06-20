package com.proyectosgrt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.DTO.CargosDTO;
import com.proyectosgrt.demo.repository.Repository_Cargos;

@Service
public class CargosServices {

  @Autowired
  Repository_Cargos repository_Cargos;

  public List<CargosDTO> getCargos(){
    List<CargosDTO> cargos = repository_Cargos.getListCargos();
    return cargos;
  }
}
