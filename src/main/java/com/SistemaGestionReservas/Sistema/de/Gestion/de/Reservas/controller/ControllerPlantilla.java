
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPlantilla {


    @GetMapping("/plantilla")
    public String mostrarPlantilla() {
        return "plantilla";  // Nombre del archivo HTML (sin extensión)
    }

}
