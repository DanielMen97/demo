package com.proyectosgrt.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.DetalleSolicitudDTO;
import com.proyectosgrt.demo.DTO.EstSolicitudDTO;
import com.proyectosgrt.demo.DTO.EstTecnicoDTO;
import com.proyectosgrt.demo.DTO.ReporteSolicitudDTO;
import com.proyectosgrt.demo.DTO.SolicitudesDTO;
import com.proyectosgrt.demo.DTO.TablaSolicitudesDTO;
import com.proyectosgrt.demo.models.Solicitudes;

public interface Solicitudes_Repository extends JpaRepository<Solicitudes, Long> {

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaSolicitudesDTO(s.idsol, s.fechacre, s.prio, p.pnom, p.pape, c.nombre, e.nombre) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest INNER JOIN Personas p ON s.nodoccliente = p.nodoc")
  List<TablaSolicitudesDTO> getListSolicitudes();

  @Query("SELECT s FROM Solicitudes s WHERE s.fechacre BETWEEN ?1 AND ?2")
  List<Solicitudes> getfech(LocalDateTime f1, LocalDateTime f2);

  // List<TablaSolicitudesDTO> findByNodoccliente(String nodoccliente);

  @Query("SELECT new com.proyectosgrt.demo.DTO.SolicitudesDTO (s.idsol, s.fechacre, c.nombre, s.obser, s.prio, e.nombre, p.pnom, p.snom, p.pape, p.sape, s.fechaci) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Personas p ON s.nodoccliente = p.nodoc INNER JOIN Estados e ON s.idest = e.idest WHERE s.idsol = ?1")
  SolicitudesDTO getDetailsSolicitud(Long idsol);

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaSolicitudesDTO(s.idsol, s.fechacre, s.prio, p.pnom, p.pape, c.nombre, e.nombre) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest INNER JOIN Personas p ON s.nodoccliente = p.nodoc WHERE nodoctecnico = ?1")
  List<TablaSolicitudesDTO> getListSolicitudPorTecnico(String nodoctecnico);

  @Query("SELECT new com.proyectosgrt.demo.DTO.SolicitudesDTO (s.idsol, s.fechacre, c.nombre, s.obser, s.prio, e.nombre, p.pnom, p.snom, p.pape, p.sape, s.fechaci) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest LEFT JOIN Personas p ON s.nodoctecnico = p.nodoc WHERE s.nodoccliente = ?1")
  List<SolicitudesDTO> getListMySolicitudes(String nodoccliente);

  @Query("SELECT new com.proyectosgrt.demo.DTO.DetalleSolicitudDTO (s.idsol, s.fechacre, c.nombre, s.obser, s.prio, e.nombre, s.diag, p1.pnom, p1.snom, p1.pape, p1.sape, p2.pnom, p2.snom, p2.pape, p2.sape, s.fechaci) FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest LEFT JOIN Personas p1 ON s.nodoccliente = p1.nodoc LEFT JOIN Personas p2 ON s.nodoctecnico = p2.nodoc WHERE s.idsol = ?1")
  DetalleSolicitudDTO getDetalleSolicitud(Long idsol);

  @Query("SELECT new com.proyectosgrt.demo.DTO.EstTecnicoDTO (COUNT(s.idsol), s.nodoctecnico, CONCAT(p.pnom, ' ', p.pape)) FROM Solicitudes s INNER JOIN Personas p ON s.nodoctecnico = p.nodoc WHERE s.idest = 3 GROUP BY s.nodoctecnico")
  List<EstTecnicoDTO> getEstTecnicos();

  @Query("SELECT new com.proyectosgrt.demo.DTO.EstSolicitudDTO (COUNT(s.idsol), e.nombre) FROM Solicitudes s INNER JOIN Estados e ON s.idest = e.idest GROUP BY s.idest")
  List<EstSolicitudDTO> getEstSolicitudEstado();

  @Query("SELECT new com.proyectosgrt.demo.DTO.ReporteSolicitudDTO (s.idsol, s.fechacre, c.nombre, e.nombre, s.prio, s.nodoccliente, TRIM(REPLACE(CONCAT(p1.pnom, ' ', COALESCE(p1.snom, ''), ' ', p1.pape, ' ', COALESCE(p1.sape, '')), '  ', ' ')), s.nodoctecnico, TRIM(REPLACE(CONCAT(p2.pnom, ' ', COALESCE(p2.snom, ''), ' ', p2.pape, ' ', COALESCE(p2.sape, '')), '  ', ' ')), s.obser, s.diag, s.fechaci) FROM Solicitudes s LEFT JOIN Personas p1 ON s.nodoccliente = p1.nodoc LEFT JOIN Personas p2 ON s.nodoctecnico = p2.nodoc INNER JOIN Estados e ON s.idest = e.idest INNER JOIN Categorias c ON s.idcat = c.idcat")
  List<ReporteSolicitudDTO> getReporteSolicitud();

  
}


