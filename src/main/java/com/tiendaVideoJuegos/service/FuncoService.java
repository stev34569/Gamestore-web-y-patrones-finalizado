
package com.tiendaVideoJuegos.service;



import com.tiendaVideoJuegos.domain.Funco;
import java.util.List;


public interface FuncoService {
    
    public List<Funco> getFuncos();
    
    public Funco getFunco(Funco funco);
    
    public void save (Funco funco);
    
    public void delete (Funco funco);
}
