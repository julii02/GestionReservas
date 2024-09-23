
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import java.util.List;


public interface IEspacioService {
        
        
    //alta de Espacio
    public void saveEspacio(Espacio espacio);
    
    //baja de Espacio
    public void deleteEspacio(Long idEspacio);
    
   //Traer la lista de los Espacio
    public List<Espacio> getEspacios();
    
    //lectura de un solo Espacio
    public Espacio  findEspacio(Long idEspacio);
   
    //Modificar Espacio
    public void editEspacio(Espacio espacio);
    
    
    
}
