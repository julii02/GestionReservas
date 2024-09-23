package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IEspacioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EspacioController {
    
    @Autowired
    private IEspacioService espacioServ;
    
    @PostMapping("espacio/guardar")
    public String saveEspacio(@RequestBody Espacio espacio){
        espacioServ.saveEspacio(espacio);
        return "Espacio Guardado!";
    }
    
    @GetMapping("espacio/traer")
    public List <Espacio> traerEspacios(){
        return espacioServ.getEspacios();
    }
    
}
