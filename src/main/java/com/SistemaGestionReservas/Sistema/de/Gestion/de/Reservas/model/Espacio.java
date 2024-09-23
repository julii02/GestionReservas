
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEspacio;
    private String nombre;
    private String descripcion;
    private long precioPorHora;

    public Espacio() {
    }

    public Espacio(long idEspacio, String nombre, String descripcion, long precioPorHora) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
    }
          
}
