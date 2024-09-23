
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {
    
    @Autowired
    private IReservaService reservaServi;
    
    @PostMapping("/reserva/crear")
    public void registrarReserva(@RequestBody Reserva reserva){
        reservaServi.RegistarReserva(reserva);
    }
    
    @GetMapping("/reserva/traer")
    public List <Reserva> TraerReservas(){
        return reservaServi.getReservas();
    }
}
