package com.proyectosgrt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.DTO.SedesDTO;
import com.proyectosgrt.demo.repository.Repository_Sedes;

@Service
public class SedesServices {

  @Autowired
  Repository_Sedes repository_Sedes;

  public List<SedesDTO> getSedes(){
    List<SedesDTO> sedes = repository_Sedes.getListSedes();
    return sedes;
  }
}
