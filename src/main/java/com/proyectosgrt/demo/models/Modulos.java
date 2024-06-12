package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Modulos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String label;
  private String icon;
  private String _to;
  
}
