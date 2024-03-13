package com.proyectosgrt.demo.controllers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Solicitudes;
import com.proyectosgrt.demo.repository.Solicitudes_Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class Solicitudes_controller {

    @Autowired
    private Solicitudes_Repository repo;

     @GetMapping("/s")
    public String incio() {
        return "Conect";
}
 @GetMapping("/solicitudes")
    public List<Solicitudes> getSolicitudes() {
        return repo.findAll();
    }

@SuppressWarnings("null")
@PostMapping("/create_solicitud")
    public String create_solicitud(@RequestBody Solicitudes so) {
            repo.save(so);
            return "Solicitud Create";
            
}
@PutMapping("cerrar/{idsol}")
public String actulizar(@PathVariable Long idsol, @RequestBody Solicitudes so) {
 
    @SuppressWarnings("null")
    Solicitudes actualizar_estado = repo.findById(idsol).get();
    actualizar_estado.setIdest(so.getIdest());
    repo.save(actualizar_estado);
    return "Estado de soliictud actualizado";
}


@PutMapping("/modificar/{idsol}")
public String actualizarsol (@PathVariable long idsol, @RequestBody Solicitudes so){
    Solicitudes actualizarsol = repo.findById(idsol).get();
    actualizarsol.setFechaci(so.getFechaci());
    actualizarsol.setPrio(so.getPrio());
    actualizarsol.setObser(so.getObser());
    actualizarsol.setDiag(so.getDiag());
    actualizarsol.setIdest(so.getIdest());
    actualizarsol.setNodoccliente(so.getNodoccliente());
    actualizarsol.setNodoctecnico(so.getNodoctecnico());
    actualizarsol.setIdcat(so.getIdcat());
    repo.save(actualizarsol);
    return "Solicitud actualizada";
}

@GetMapping("/solicitud_fecha")
    public List <Solicitudes> Solicitudes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    LocalDateTime f1 = LocalDateTime.parse("2024-03-10T03:08:17.000+00:00", formatter);
    LocalDateTime f2 = LocalDateTime.parse("2024-03-15T03:08:17.000+00:00", formatter);
        return repo.getfech(f1, f2);
}

}