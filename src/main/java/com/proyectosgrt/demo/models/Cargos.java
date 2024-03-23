package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Cargos {

  @Id
  @Getter
  @Setter
  private Integer idcargo;

  @Column
  @Getter
  @Setter
  private String nombre;

  @Column
  @Getter
  @Setter
  private Integer idarea;

}
