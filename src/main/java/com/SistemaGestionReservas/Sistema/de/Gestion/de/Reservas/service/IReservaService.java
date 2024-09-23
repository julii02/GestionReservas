
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.DTO.ReservaDTO;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import java.util.List;


public interface IReservaService {
        //alta de Reserva
    public void RegistarReserva(ReservaDTO dto);
    
    //baja de Reserva
    public void deleteReserva(Long idReserva);
    
   //Traer la lista de los Espacio
    public List<Reserva> getReservas();
    
    //lectura de un solo Espacio
    public Reserva  findReserva(Long idReserva);
   
    //Modificar Espacio
    public void editReserva(Reserva reserva);
    
    
}
