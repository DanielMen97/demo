package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "roles")
public class Roles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Enumerated(EnumType.STRING)
  private RolesEnum rol;
  
}
