package models.beans;

import java.util.List;
import models.dao.Clientedao;
import models.entity.Cliente;

public class Clientebeans extends Cliente {
    
     private Clientedao clienteDao = new Clientedao();

    
    public List<Cliente> findPorNombre() {
        return clienteDao.findPorNombre(nombre);
    }
    
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

//    public Cliente findById() {
//        Cliente cliente = null;
//        if (id > 0) {
//            cliente = clienteDao.findById(id);
//        } else {
//            cliente = new Cliente();
//        }
//        return cliente;
//    }
//
//    public void save() {
//        clienteDao.save(this);
//    }
//
//    public void delete() {
//        clienteDao.delete(this);
//    }
}
