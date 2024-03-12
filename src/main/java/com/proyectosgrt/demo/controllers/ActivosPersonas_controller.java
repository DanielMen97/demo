package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.ActivosPersonas;
import com.proyectosgrt.demo.repository.Repository_ActivosPersonas;

@RestController

public class ActivosPersonas_controller {

@Autowired
private Repository_ActivosPersonas acpe;

@GetMapping("/activopersona")
public List<ActivosPersonas> getActPer() {
    return acpe.findAll();
}
}
