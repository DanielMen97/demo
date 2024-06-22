package com.proyectosgrt.demo.models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idsol;

    @Column
    @Getter
    @Setter
    private String fechacre;

    @Column
    @Getter
    @Setter
    private String fechaci;

    @Column
    @Getter
    @Setter
    private String prio;

    @Column
    @Getter
    @Setter
    private String obser;

    @Column
    @Getter
    @Setter
    private String diag;

    @Column
    @Getter
    @Setter
    private String nodoccliente;

    @Column
    @Getter
    @Setter
    private String nodoctecnico;

    @Column
    @Getter
    @Setter
    private Byte idcat;
    
    @Column
    @Getter
    @Setter
    private Byte idest;

}
