package com.proyectosgrt.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Personas {

    @Column(name = "nodoc", nullable = false, unique = true)
    @Id
    @Getter
    @Setter
    private String nodoc;

    @Column
    @Getter
    @Setter
    private String pnom;

    @Column
    @Getter
    @Setter
    private String snom;

    @Column
    @Getter
    @Setter
    private String pape;

    @Column
    @Getter
    @Setter
    private String sape;

    @Column
    @Getter
    @Setter
    private String correo;

    @Column
    @Getter
    @Setter
    private Long celular;

    @Column
    @Getter
    @Setter
    private String pass;

    @Column
    @Getter
    @Setter
    private String rol;

    @Column
    @Getter
    @Setter
    private byte idcargo;

    @Column
    @Getter
    @Setter
    private byte idsede;

    @Column
    @Getter
    @Setter
    private byte iddoc;

}
