
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
        //alta de Usuario
    public void saveUsuario(Usuario usuario);
    
    //baja de Espacio
    public void deleteUsuario(Long idUsuario);
    
   //Traer la lista de los Usuario
    public List<Usuario> getUsuarios();
    
    //lectura de un solo Espacio
    public Usuario  findUsuario(Long idUsuario);
   
    //Modificar Usuario
    public void editUsuario(Usuario usuario);
    
    
}
