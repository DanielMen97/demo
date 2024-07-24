package com.proyectosgrt.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.proyectosgrt.demo.models.Prioridad;
import java.util.Arrays;
import java.util.List;

@RestController
public class Prioridades_Controllers {

  @GetMapping("/admin/prioridades")
  public List<String> getListPriority() {
    List<String> listaPrioridad = Arrays.asList(Prioridad.ALTA.name(), Prioridad.MEDIA.name(), Prioridad.BAJA.name(), Prioridad.PENDIENTE.name());
    return listaPrioridad;
  }
  
}
