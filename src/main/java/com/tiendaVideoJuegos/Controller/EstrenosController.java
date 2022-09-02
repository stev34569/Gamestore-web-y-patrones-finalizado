
package com.tiendaVideoJuegos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstrenosController {
    @RequestMapping("/estrenos/listado")
    public String Inicio(Model model) {

        return "/estrenos/listado";
}
}
