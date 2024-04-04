package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.models.Activos;
import com.proyectosgrt.demo.repository.Repository_Activos;

@RestController
public class Activos_Controller {

    @Autowired
    private Repository_Activos rep;

    //Consulta Generica
    @GetMapping("/act")
    public String incio() {
        return "Conect";
    }   

    //Consulta Activo
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/acts")
    public List<Activos> getActivos() {
        return rep.findAll();
    }

    //Creacion Activo
    @CrossOrigin(origins = "http://localhost:3000/")
    @SuppressWarnings("null")
    @PostMapping("/add_act")
    public String add_act(@RequestBody Activos ac) {
            rep.save(ac);
            return "Active Add";
    }

    //Editar Usuario
    @PutMapping("/edit_act/{idserial}")
    public String edit_act(@PathVariable String idserial, @RequestBody Activos ac) {
        @SuppressWarnings("null")
        Activos actualizarActivos = rep.findById(idserial).get();
        actualizarActivos.setModelo(ac.getModelo());
        actualizarActivos.setIdtipo(ac.getIdtipo());
        actualizarActivos.setIdmarca(ac.getIdmarca());
        rep.save(actualizarActivos);
        return "Activo editado";
        
    }

    //Eliminar Activo
    @SuppressWarnings("null")
    @DeleteMapping("/delete_act/{idserial}")
    public String eliminarActivo (@PathVariable("idserial") String idseiral){
        Activos borrauActivos = rep.findById(idseiral).get();
        rep.delete(borrauActivos);
        return "Activo eliminado";
    }

    


}






