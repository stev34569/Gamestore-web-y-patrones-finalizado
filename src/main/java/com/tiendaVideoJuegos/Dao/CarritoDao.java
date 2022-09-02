
package com.tiendaVideoJuegos.Dao;

import com.tiendaVideoJuegos.domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;




public interface CarritoDao extends CrudRepository<Carrito, Long>  {
    Optional<Carrito> findByIdCliente(Long idCliente);
}
