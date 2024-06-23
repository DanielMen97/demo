package com.proyectosgrt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.DTO.TiposdocDTO;
import com.proyectosgrt.demo.repository.Repository_Tiposdoc;

@Service
public class TiposdocServices {

  @Autowired
  Repository_Tiposdoc repository_Tiposdoc;

  public List<TiposdocDTO> getTiposdoc(){
    List<TiposdocDTO> tiposdoc = repository_Tiposdoc.getListTiposdoc();
    return tiposdoc;
  }
}
