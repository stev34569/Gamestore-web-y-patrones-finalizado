
package com.tiendaVideoJuegos.Controller;



import com.tiendaVideoJuegos.domain.Funco;
import com.tiendaVideoJuegos.service.FuncoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class FuncoContoller {

    @Autowired
     
    private FuncoService funcoService;

    @GetMapping("/funco/listado")
    public String inicio(Model model) {

       
        var funco = funcoService.getFuncos();
        model.addAttribute("funco", funco);
        return "/funco/listado";

    }

  @GetMapping("/funco/nuevo")
    public String nuevoFunco(Funco funco) {
        return "/funco/modificar";
    }

    @PostMapping("/funco/guardar")
    public String guardarFunco(Funco funco) {
        funcoService.save(funco);
        return "redirect:/funco/listado";
    }

    @GetMapping("/funco/modificar/{idFunco}")
    public String modificarFunco(Funco funco, Model model) {
        funco = funcoService.getFunco(funco);
        model.addAttribute("funco", funco);
        return "/funco/modificar";
    }

    @GetMapping("/funco/eliminar/{idFunco}")
    public String eliminarFunco(Funco funco) {
        funcoService.delete(funco);
        return "redirect:/funco/listado";
    }
}
