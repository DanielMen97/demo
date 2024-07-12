package com.proyectosgrt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.TablaActivosDTO;
import com.proyectosgrt.demo.models.Activos;

public interface Repository_Activos extends JpaRepository<Activos, String> {
    @Query("Select new com.proyectosgrt.demo.DTO.TablaActivosDTO (activos.idserial, activos.modelo, marcasactivo.nombre, tiposactivo.nombre) FROM Activos activos INNER JOIN Tiposactivo tiposactivo ON activos.idtipo = tiposactivo.idtipo INNER JOIN Marcasactivo marcasactivo ON activos.idmarca = marcasactivo.idmarca")
    List<TablaActivosDTO> getLstTableActivos();

    @Query("Select new com.proyectosgrt.demo.DTO.TablaActivosDTO (activos.idserial, activos.modelo, marcasactivo.nombre, tiposactivo.nombre) FROM Activos activos INNER JOIN Tiposactivo tiposactivo ON activos.idtipo = tiposactivo.idtipo INNER JOIN Marcasactivo marcasactivo ON activos.idmarca = marcasactivo.idmarca WHERE activos.idperson = ?1")
    List<TablaActivosDTO> getLstTableActivosByUser(String idperson);

    Activos findByIdserial(String idserial);

}
