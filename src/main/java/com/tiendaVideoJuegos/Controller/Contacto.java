
package com.tiendaVideoJuegos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Contacto {
    
    @RequestMapping("/contacto/listado")
    public String Inicio(Model model) {
        
        return "/contacto/listado";
    }
}
