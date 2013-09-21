package com.models.beans;

import java.util.List;
import com.models.dao.Clientedao;
import com.models.entity.Cliente;

public class Clientebeans extends Cliente {
    
     private Clientedao clienteDao = new Clientedao();
    
    public List<Cliente> findPorNombre() {
        return clienteDao.findPorNombre(nombre);
    }
    
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    public Cliente findByRut() {
        Cliente cliente = null;
        if (rut != null) {
            cliente = clienteDao.findByRut(rut);
        } else {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void save() {
        clienteDao.save(this);
    }

    public void delete() {
        clienteDao.delete(this);
    }
}
