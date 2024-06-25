package com.proyectosgrt.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.TablaSolicitudesDTO;
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
 @GetMapping("/admin/solicitudes")
    public List<TablaSolicitudesDTO> getSolicitudes() {
        List<TablaSolicitudesDTO> listaSolicitudes = repo.getListSolicitudes();
        return listaSolicitudes;
    }
    
@GetMapping("/solicitudid/{idsol}")
public Solicitudes solicitudid(@PathVariable Long idsol) {
    return repo.findById(idsol).orElse(null);

}

@GetMapping("/auth/Solicitudes/{nodoccliente}")
public List<TablaSolicitudesDTO> solicitudesPersonas(@PathVariable String nodoccliente) {
    return repo.findByNodoccliente(nodoccliente);
}

@PostMapping("/adminuser/create_solicitud")
    public String create_solicitud(@RequestBody Solicitudes so) {
            repo.save(so);
            return "Solicitud Creada";
}

@PutMapping("/adminuser/cerrar/{idsol}")
public String actulizar(@PathVariable Long idsol, @RequestBody Solicitudes so) {
    Solicitudes actualizar_estado = repo.findById(idsol).get();
    actualizar_estado.setIdest(so.getIdest());
    repo.save(actualizar_estado);
    return "Estado de soliictud actualizado";
}

@PutMapping("/adminuser/modificar/{idsol}")
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

@PutMapping("/adminuser/modificarobser/{idsol}")
public String actualizarobser (@PathVariable long idsol, @RequestBody Solicitudes so){
    Solicitudes actualizarsol = repo.findById(idsol).get();
    actualizarsol.setObser(so.getObser());
    repo.save(actualizarsol);
    return "Observacion actualizada";
}


@PutMapping("/admin/modificarTec/{idsol}")
public String actualizarsolTec (@PathVariable long idsol, @RequestBody Solicitudes so){
    Solicitudes actualizarsol = repo.findById(idsol).get();
    actualizarsol.setPrio(so.getPrio());
    actualizarsol.setIdest(so.getIdest());
    actualizarsol.setNodoctecnico(so.getNodoctecnico());
    repo.save(actualizarsol);
    return "Solicitud actualizada";
}
}