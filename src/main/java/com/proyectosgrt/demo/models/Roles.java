package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Roles {

  @Id
  private String rol;
  
}
