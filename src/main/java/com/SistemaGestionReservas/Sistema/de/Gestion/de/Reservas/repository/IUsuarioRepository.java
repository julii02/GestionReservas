
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario , Long> {
    
}
