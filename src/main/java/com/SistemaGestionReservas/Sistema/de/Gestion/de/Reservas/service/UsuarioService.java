
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public void saveUsuario(Usuario usuario) {
            
        usuarioRepo.save(usuario);
    
    }

    @Override
    public void deleteUsuario(Long idUsuario) {

        usuarioRepo.deleteById(idUsuario);
    
    }

    @Override
    public List<Usuario> getUsuarios() {

        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        
        return listaUsuarios;
    }

    @Override
    public Usuario findUsuario(Long idUsuario) {

        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        return usuario;
    
    }

    @Override
    public void editUsuario(Usuario usuario) {

        usuarioRepo.save(usuario);
    
    }
    
}
