package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Rol_Modulos {

  @Id
  private Integer id;
  private Integer moduloid;
  private String rolid;
  
}
