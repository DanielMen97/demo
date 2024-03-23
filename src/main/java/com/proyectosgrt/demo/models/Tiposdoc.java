package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Tiposdoc {
        
  @Id
  @Getter
  @Setter
  private Integer iddoc;

  @Column
  @Getter
  @Setter
  private String tipo;
}
