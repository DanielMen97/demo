package com.proyectosgrt.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ActivosPersonas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Getter
    @Setter
    // @ManyToOne
    // @JoinColumn(name="idserial")
    private String aidserial;

    @Column
    @Getter
    @Setter
    // @ManyToOne
    // @JoinColumn(name="nodoc")
    private String pnodoc; 

    @Column
    @Getter
    @Setter
    private String fechae;

    @Column
    @Getter
    @Setter
    private String fechad;

}
