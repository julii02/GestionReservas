package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.exception.ExceptionDetails;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.exception.ReservasException;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IEspacioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EspacioController {
    
    @Autowired
    private IEspacioService espacioServ;
    
    @PostMapping("/espacio/guardar")
    public String saveEspacio(@RequestBody @Valid Espacio espacio){
        espacioServ.saveEspacio(espacio);
        return "Espacio Guardado!";
    }
    
    @GetMapping("espacio/traer")
    public List <Espacio> traerEspacios(){
        return espacioServ.getEspacios();
    }
    
    @DeleteMapping("espacio/borrar/{idEspacio}")
    public String borrarEspacio(@PathVariable Long idEspacio)throws ReservasException{
        if(idEspacio == 0 || idEspacio == null){
            throw new ReservasException("Id de usuario no valido" , 
                    new ExceptionDetails("Ha ocurrido un error inesparado","Error"));
        }
        espacioServ.deleteEspacio(idEspacio);
        return "Espacio Eliminado";
    }
    
    @PutMapping("espacio/editar")
    public Espacio editarEspacio(@RequestBody Espacio espacio){
        espacioServ.editEspacio(espacio);
        return espacio;
    }
    
    @GetMapping("/espacio/buscarPorNombre/{nombre}")
    public Espacio buscarEspacioPorNombre(@PathVariable String nombre) throws ReservasException {
         return espacioServ.buscarPorNombre(nombre)
            .orElseThrow(() -> new ReservasException(
                "El espacio con nombre '" + nombre + "' no fue encontrado",
                new ExceptionDetails("No se ha encontrado el espacio solicitado", "Error")
            ));
    }
    
    @GetMapping("/espacio/traerPorNombre/{nombre}")
    public List <Espacio> traerEspacioPorNombre(@PathVariable String nombre){
        List <Espacio> listaEspacios = espacioServ.traerEspacioPorNombre(nombre);
        if(listaEspacios.isEmpty()){
            throw new ReservasException("No se encontraron espacios con el nombre " + nombre,
                                        new ExceptionDetails("espacios no encontrados" , "Error"));
        }
        return listaEspacios;
    }
}
