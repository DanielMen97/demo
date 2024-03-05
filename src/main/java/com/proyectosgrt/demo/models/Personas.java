package com.proyectosgrt.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Personas {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer Id;

    
    @Column
    @Getter
    @Setter
    private String NoDoc;

    @Column
    @Getter
    @Setter
    private String PNom;

    @Column
    @Getter
    @Setter
    private String SNom;

    @Column
    @Getter
    @Setter
    private String PApe;

    @Column
    @Getter
    @Setter
    private String SApe;

    @Column
    @Getter
    @Setter
    private String Correo;

    @Column
    @Getter
    @Setter
    private Integer Celular;

    @Column
    @Getter
    @Setter
    private String Pass;

    @Column
    @Getter
    @Setter
    private String Rol;

    @Column
    @Getter
    @Setter
    private Integer IdCargo;

    @Column
    @Getter
    @Setter
    private Integer IdSede;

    @Column
    @Getter
    @Setter
    private Integer IdDoc;

}
