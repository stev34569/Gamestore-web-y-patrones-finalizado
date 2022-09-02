
package com.tiendaVideoJuegos.Dao;

import com.tiendaVideoJuegos.domain.Articulo;
import com.tiendaVideoJuegos.domain.CarritoDetalle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;




public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {
    public Optional<CarritoDetalle> findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    public List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    public void deleteByIdCarrito(Long idCarrito);
}
