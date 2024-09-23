
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IEspacioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspacioService implements IEspacioService{

    @Autowired
    private IEspacioRepository espacioRepo;
      
    @Override
    public void saveEspacio(Espacio espacio) {
            
           espacioRepo.save(espacio);
    }

    @Override
    public void deleteEspacio(Long idEspacio) {

        espacioRepo.deleteById(idEspacio);
    
    }

    @Override
    public List<Espacio> getEspacios() {
        List<Espacio> listaEspacioss = espacioRepo.findAll(); 
       
        return listaEspacioss ;
    }

    @Override
    public Espacio findEspacio(Long idEspacio) {

    Espacio espacio = espacioRepo.findById(idEspacio).orElse(null);
        return espacio;
    }

    @Override
    public void editEspacio(Espacio espacio) {

        espacioRepo.save(espacio);
    
    }
    
}
