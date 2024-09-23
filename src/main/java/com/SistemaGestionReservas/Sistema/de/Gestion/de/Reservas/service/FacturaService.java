
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IFacturaRepository facturaRepo;
    
    @Override
    public Factura editFactura(Factura factura) {
        facturaRepo.save(factura);
        return factura;
    }
    
}
