
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.DTO.ReservaDTO;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IEspacioRepository;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IFacturaRepository;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IReservaRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService{

    @Autowired
    private IReservaRepository reservaRepo;
    
    @Autowired 
    private IEspacioRepository espacioRepo;
    
    @Autowired
    private IFacturaRepository facturaRepo;
    
    @Override
    public String RegistarReserva(Reserva reserva) {
        Long idEspacio = reserva.getEspacio().getIdEspacio();
        LocalDateTime inicioReserva = reserva.getInicioReserva();
        LocalDateTime finReserva = reserva.getFinReserva();

        // Verificar si el espacio existe
        Espacio espacio = espacioRepo.findById(idEspacio).orElse(null);
        if (espacio == null) {
            return "Error: El espacio con ID " + idEspacio + " no existe.";
        }

        // Obtener todas las reservas y verificar si hay conflicto de fechas
        List<Reserva> reservasExistentes = reservaRepo.findAll();

        for (Reserva reserv : reservasExistentes) {
            if (reserv.getEspacio().getIdEspacio() == idEspacio &&
                reserv.getInicioReserva().isBefore(finReserva) &&
                reserv.getFinReserva().isAfter(inicioReserva)) {
                return "Error: Ya existe una reserva para este espacio en el rango de fechas especificado.";
            }
        }
        
        // Calcular la duración en horas de la reserva
        Duration duracion = Duration.between(inicioReserva, finReserva);
        long horasReserva = duracion.toHours();
        
         // Calcular el monto total (precio por hora * horas de reserva)
        long montoTotal = horasReserva * reserva.getEspacio().getPrecioPorHora();
        
        Factura nuevaFactura = new Factura();
        nuevaFactura.setMontoTotal((double) montoTotal);
        nuevaFactura.setFechaEmision(LocalDate.now());
        nuevaFactura.setReserva(reserva);
        
        //guardar factura
        facturaRepo.save(nuevaFactura);
              
        // Guardar la nueva reserva
        reservaRepo.save(reserva);
        return "Reserva guardada exitosamente." + "espacio: " + reserva.getEspacio().getNombre() + "usuario: " + reserva.getUsuario().getNombre() +
                "inicio reserva: " + reserva.getInicioReserva() + "fin reserva: " + reserva.getFinReserva();
    }

    @Override
    public String deleteReserva(Long idReserva) {
        reservaRepo.deleteById(idReserva);
        return "Reserva eliminada correctamente";
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaRepo.findAll();
    }

    @Override
    public Reserva findReserva(Long idReserva) {
        return reservaRepo.findById(idReserva).orElse(null);
    }

    @Override
    public void editReserva(Reserva reserva) {
        this.RegistarReserva(reserva);
    }
    
}
