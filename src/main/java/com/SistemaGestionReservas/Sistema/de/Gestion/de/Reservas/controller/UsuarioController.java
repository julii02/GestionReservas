
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import ch.qos.logback.core.model.Model;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IUsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UsuarioController {
    
    @Autowired
    public IUsuarioService usuarioServ;
    
    @PostMapping("usuario/guardar1")
    public String saveUsuario( @Valid @RequestBody Usuario usuario){
        usuarioServ.saveUsuario(usuario);
        return "Guardado Correctamente!";
    }
    
    @GetMapping("usuario/traer")
    public List <Usuario> traerUsuarios(){
        return usuarioServ.getUsuarios();
    }
    
    @DeleteMapping("usuario/borrar/{idUsuario}")
    public String borrarUsuario(@PathVariable long idUsuario){
        usuarioServ.deleteUsuario(idUsuario);
        return "Usuario Eliminado";
    }
    
    @PutMapping("usuario/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        usuarioServ.editUsuario(usuario);
        return usuario;
    }
    
    // Método para guardar el usuario
    @PostMapping("/usuario/guardar2")
    public String saveUsuario2(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServ.saveUsuario(usuario);
        return "redirect:/usuarios";  // Redirige a la lista de usuarios después de guardar
    }

    // Método para traer los usuarios y renderizar la plantilla con Thymeleaf
    @GetMapping("/usuarios")
   public String traerUsuarios(Map<String, Object> model) {
    List<Usuario> usuarios = usuarioServ.getUsuarios();
    model.put("usuarios", usuarios);  // Añadir la lista de usuarios al mapa
    return "plantilla";  // Nombre de la plantilla Thymeleaf en resources/templates/plantilla.html
}
    
    
    
}
