package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Asignaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Getter
    @Setter
    private String idserial;

    @Column
    @Getter
    @Setter
    private String nodoc;

    @Column
    @Getter
    @Setter
    private String fechae;

    @Column
    @Getter
    @Setter
    private String fechad;

}
