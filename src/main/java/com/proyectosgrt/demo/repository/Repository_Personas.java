package com.proyectosgrt.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectosgrt.demo.models.Personas;

public interface Repository_Personas extends JpaRepository<Personas, String>{

  Optional<Personas> findByCorreo(String correo);

}
