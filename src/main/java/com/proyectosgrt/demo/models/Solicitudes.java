package com.proyectosgrt.demo.models;

import java.math.BigInteger;
import java.security.Timestamp;

import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

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
    private BigInteger Idsol;

    @Column
    @Getter
    @Setter
    private Timestamp FechaCre;

    @Column
    @Getter
    @Setter
    private Timestamp FechaCi;

    @Column
    @Getter
    @Setter
    private TinyIntJdbcType Prio;

    @Column
    @Getter
    @Setter
    private String Obser;

    @Column
    @Getter
    @Setter
    private String Diag;

    @Column
    @Getter
    @Setter
    private TinyIntJdbcType IdEst;

    @Column
    @Getter
    @Setter
    private String NoDocCliente;

    @Column
    @Getter
    @Setter
    private String NoDocTecnico;

    @Column
    @Getter
    @Setter
    private TinyIntJdbcType IdCat;

}
