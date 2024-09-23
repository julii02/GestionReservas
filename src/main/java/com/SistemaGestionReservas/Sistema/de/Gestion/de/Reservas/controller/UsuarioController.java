
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    public IUsuarioService usuarioServ;
    
    @PostMapping("usuario/guardar")
    public String saveUsuario(@RequestBody Usuario usuario){
        usuarioServ.saveUsuario(usuario);
        return "Guardado Correctamente!";
    }
    
    @GetMapping("usuario/traer")
    public List <Usuario> traerUsuarios(){
        return usuarioServ.getUsuarios();
    }
    
}
