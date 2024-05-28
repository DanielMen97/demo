package com.proyectosgrt.demo.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.models.Solicitudes;

public interface Solicitudes_Repository extends JpaRepository<Solicitudes, Long> {

    @Query("SELECT s FROM Solicitudes s WHERE s.fechacre BETWEEN ?1 AND ?2")
    List<Solicitudes> getfech (LocalDateTime f1, LocalDateTime f2);

}
