package com.proyectosgrt.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.SolicitudesDTO;
import com.proyectosgrt.demo.DTO.TablaSolicitudesDTO;
import com.proyectosgrt.demo.models.Solicitudes;

public interface Solicitudes_Repository extends JpaRepository<Solicitudes, Long> {

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaSolicitudesDTO(s.idsol, s.fechacre, s.prio, p.pnom, p.pape, c.nombre, e.nombre) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest INNER JOIN Personas p ON s.nodoccliente = p.nodoc")
  List<TablaSolicitudesDTO> getListSolicitudes();

  @Query("SELECT s FROM Solicitudes s WHERE s.fechacre BETWEEN ?1 AND ?2")
  List<Solicitudes> getfech(LocalDateTime f1, LocalDateTime f2);

  // List<TablaSolicitudesDTO> findByNodoccliente(String nodoccliente);

  @Query("SELECT new com.proyectosgrt.demo.DTO.SolicitudesDTO (s.idsol, s.fechacre, c.nombre, s.obser, s.prio, p.pnom, p.snom, p.pape, p.sape) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Personas p ON s.nodoccliente = p.nodoc WHERE s.idsol = ?1")
  SolicitudesDTO getDetailsSolicitud(Long idsol);

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaSolicitudesDTO(s.idsol, s.fechacre, s.prio, p.pnom, p.pape, c.nombre, e.nombre) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest INNER JOIN Personas p ON s.nodoccliente = p.nodoc WHERE nodoctecnico = ?1")
  List<TablaSolicitudesDTO> getListSolicitudPorTecnico(String nodoctecnico);

}
