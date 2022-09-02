
package com.tiendaVideoJuegos.service;

import com.tiendaVideoJuegos.domain.Carrito;




public interface CarritoService {
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarritoCliente(long idCliente);
}
