package com.proyectosgrt.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosgrt.demo.DTO.TablaActivosDTO;
import com.proyectosgrt.demo.models.Activos;
import com.proyectosgrt.demo.repository.Repository_Activos;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Activos_Controller {

    @Autowired
    private Repository_Activos rep;

    //Consulta Generica
    @Operation(summary = "EndPoint conexión de prueba")
    @GetMapping("/admintechnical/act")
    public String incio() {
        return "Conect";
    }   

    //Consulta Activo
    @Operation(summary = "Obtener lista de activos registrados")
    @GetMapping("/admintechnical/acts")
    public List<Activos> getActivos() {
        return rep.findAll();
    }

    //Creacion Activo
    @Operation(summary = "Añadir activo")
    @PostMapping("/admintechnical/add_act")
    public String add_act(@RequestBody Activos ac) {
            rep.save(ac);
            return "Active Add";
    }

    //Editar Usuario
    @Operation(summary = "Editar información de activo registrado")
    @PutMapping("/admintechnical/edit_act/{idserial}")
    public String edit_act(@PathVariable String idserial, @RequestBody Activos ac) {
        Activos actualizarActivos = rep.findById(idserial).get();
        actualizarActivos.setModelo(ac.getModelo());
        actualizarActivos.setIdtipo(ac.getIdtipo());
        actualizarActivos.setIdmarca(ac.getIdmarca());
        rep.save(actualizarActivos);
        return "Activo editado";        
    }

    //Eliminar Activo
    @Operation(summary = "Eliminar activo")
    @DeleteMapping("/admintechnical/delete_act/{idserial}")
    public String eliminarActivo (@PathVariable("idserial") String idseiral){
        Activos borrauActivos = rep.findById(idseiral).get();
        rep.delete(borrauActivos);
        return "Activo eliminado";
    }

    @GetMapping("/admintechnical/listtableacts")
    public List<TablaActivosDTO> getTableActs() {
        List<TablaActivosDTO> listactivos = rep.getLstTableActivos();
        return listactivos;
    }

    @GetMapping("/adminuser/listactsuser/{idperson}")
    public List<TablaActivosDTO> getListActsPers(@PathVariable String idperson) {
        List<TablaActivosDTO> activosUser = rep.getLstTableActivosByUser(idperson);
        return activosUser;
    }
    
}






