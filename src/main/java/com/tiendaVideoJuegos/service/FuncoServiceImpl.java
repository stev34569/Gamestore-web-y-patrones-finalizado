
package com.tiendaVideoJuegos.service;

import com.tiendaVideoJuegos.Dao.FuncoDao;
import com.tiendaVideoJuegos.domain.Funco;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class FuncoServiceImpl implements FuncoService{
     @Autowired
    private FuncoDao funcoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Funco> getFuncos() {
        return (List<Funco>) funcoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Funco getFunco(Funco funco) {
        return funcoDao.findById(funco.getIdFunco()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Funco funco) {
        funcoDao.save(funco);
    }

    @Override
    @Transactional
    public void delete(Funco funco) {
        funcoDao.delete(funco);
    }
}
