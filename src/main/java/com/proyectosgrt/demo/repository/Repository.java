package com.proyectosgrt.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.models.Personas;

public interface Repository extends JpaRepository<Personas, String>{

  @Query (value= "{call ConsultUser ()}", nativeQuery = true)
  List <Personas> ConsultUser();

  Optional<Personas> findPersonasBynodoc(String nodoc);

}
