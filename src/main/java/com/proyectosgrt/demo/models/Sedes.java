package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Sedes {

  @Id
  @Getter
  @Setter
  private Integer idsede;

  @Column
  @Getter
  @Setter
  private String direccion;

  @Column
  @Getter
  @Setter
  private String nombre;

  @Column
  @Getter
  @Setter
  private Long telefono;

  @Column
  @Getter
  @Setter
  private Integer idbarrio;

}
