package com.proyectosgrt.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Activos {

    @Id
    @Column(name = "idserial" , nullable = false)
    @Getter 
    @Setter
    private String idserial;

    @Column
    @Getter
    @Setter
    private String modelo;

    @Column
    @Getter
    @Setter
    private short idtipo;

    @Column
    @Getter
    @Setter
    private short idmarca;

}





