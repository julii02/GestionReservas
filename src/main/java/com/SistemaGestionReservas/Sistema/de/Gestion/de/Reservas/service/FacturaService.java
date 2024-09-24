
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IFacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IFacturaRepository facturaRepo;
    
    @Override
    public Factura editFacturaEstado(long idFactura) {
        Factura factu = facturaRepo.findById(idFactura).orElse(null);
        factu.setEstado("Pagado");
        facturaRepo.save(factu);
        return factu;
    }

    @Override
    public List<Factura> traerFacturas() {
        return facturaRepo.findAll();
    }
    
}
