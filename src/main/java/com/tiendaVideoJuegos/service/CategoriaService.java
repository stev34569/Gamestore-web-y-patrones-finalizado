
package com.tiendaVideoJuegos.service;


import com.tiendaVideoJuegos.domain.Categoria;

import java.util.List;


public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activo);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
}
