package com.proyectosgrt.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectosgrt.demo.DTO.TablaSolicitudesDTO;
import com.proyectosgrt.demo.models.Solicitudes;

public interface Solicitudes_Repository extends JpaRepository<Solicitudes, Long> {

  @Query("SELECT new com.proyectosgrt.demo.DTO.TablaSolicitudesDTO(s.idsol, s.fechacre, s.fechaci, s.prio, s.obser, s.diag, s.nodoccliente, s.nodoctecnico, c.nombre, e.nombre)FROM Solicitudes s INNER JOIN Categorias c ON s.idcat = c.idcat INNER JOIN Estados e ON s.idest = e.idest")
  List<TablaSolicitudesDTO> getListSolicitudes();


    @Query("SELECT s FROM Solicitudes s WHERE s.fechacre BETWEEN ?1 AND ?2")
    List<Solicitudes> getfech (LocalDateTime f1, LocalDateTime f2);

      List<TablaSolicitudesDTO> findByNodoccliente(String nodoccliente);
      
}
