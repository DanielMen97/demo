package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.models.Personas;

public interface Repository extends JpaRepository<Personas, Integer> {

  @Query (value= "{call ConsultUser ()}", nativeQuery = true)
  List <Personas> ConsultUser();

}
