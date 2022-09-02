package com.tiendaVideoJuegos.Controller;


import com.tiendaVideoJuegos.Dao.UsuarioDao;
import com.tiendaVideoJuegos.domain.Carrito;
import com.tiendaVideoJuegos.domain.CarritoDetalle;
import com.tiendaVideoJuegos.domain.Usuario;
import com.tiendaVideoJuegos.service.ArticuloService;
import com.tiendaVideoJuegos.service.CarritoDetalleService;
import com.tiendaVideoJuegos.service.CarritoService;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private CarritoDetalleService carritoDetalleService;
    
    @Autowired
    private CarritoService carritoService;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {        
        //Obtener el usuario llegado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }
        //Validar si es usuario de un cliente
        boolean esCliente = false;
        if (user.getAuthorities().size() == 1) {
            for (var rol : user.getAuthorities()) {
                if (rol.getAuthority().equals("ROLE_USER")) {
                    esCliente = true;
                }
            }
        }
        if (esCliente) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
            request.getSession().setAttribute("idCliente", usuario.getIdCliente());
            request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
            //Consultar los items
            List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            int cantidadArticulosCarrito = carritoDetalles.size();
            model.addAttribute("cantidadArticulosCarrito", cantidadArticulosCarrito);
        }
        log.info("Ahora se usa arquitectura MVC");
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);
        return "index";
    }
    

}
