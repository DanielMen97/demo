package com.proyectosgrt.demo.controllers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000/")
 @GetMapping("/solicitudes")
    public List<Solicitudes> getSolicitudes() {
        return repo.findAll();
    }
@SuppressWarnings("null")
@GetMapping("/solicitudid/{idsol}")
public Solicitudes solicitudid(@PathVariable Long idsol) {
    return repo.findById(idsol).orElse(null);
}

@SuppressWarnings("null")
@CrossOrigin(origins = "http://localhost:3000/")
@PostMapping("/create_solicitud")
    public String create_solicitud(@RequestBody Solicitudes so) {
            repo.save(so);
            return "Solicitud Creada    ";
            
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
    public List <Solicitudes> Solicitudes(@RequestBody Map<String, String> body) {
        String fecha1 = body.get("fecha1");
        String fecha2 = body.get("fecha2");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    LocalDateTime f1 = LocalDateTime.parse(fecha1, formatter);
    LocalDateTime f2 = LocalDateTime.parse(fecha2, formatter);
        return repo.getfech(f1, f2);
}

}