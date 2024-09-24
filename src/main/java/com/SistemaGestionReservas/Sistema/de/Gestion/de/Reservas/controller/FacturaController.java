
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaController {
    
    @Autowired
    private IFacturaService facturaServ;
    
    @PutMapping("/factura/editarEstado/{idFactura}")
    public Factura editarEstadoFactura (@PathVariable long idFactura){
        return facturaServ.editFacturaEstado(idFactura);
    }
    

}
