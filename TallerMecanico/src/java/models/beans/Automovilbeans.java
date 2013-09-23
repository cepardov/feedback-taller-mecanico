
package models.beans;

import java.util.List;
import models.dao.Automovildao;
import models.entity.Automovil;

public class Automovilbeans extends Automovil {
    private Automovildao automovilDao = new Automovildao();

    
    public List<Automovil> findPorPatente() {
        
        return automovilDao.findPorPatente(patente);
    }
    
    public List<Automovil> findAll() {
        return automovilDao.findAll();
    }

    public Automovil findByRut() {
        Automovil automovil = null;
        if (rutcliente == null) {
            automovil = new Automovil();
        } else {
            automovil = automovilDao.findByPatente(patente);
        }
        return automovil;
    }

    public void save() {
        automovilDao.save(this);
    }

    public void delete() {
        automovilDao.delete(this);
    }
}
