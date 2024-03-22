package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Roles {

  @Id
  @Getter
  @Setter
  private Integer idrol;

  @Column
  @Getter
  @Setter
  private String nombre;
}
