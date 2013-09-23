package models.beans;

import java.util.List;
import models.dao.ProductoDao;
import models.entity.Producto;

public class ProductoBean extends Producto {

    private ProductoDao productoDao = new ProductoDao();

    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    public Producto findById() {
        Producto producto = null;
        if (id > 0) {
            producto = productoDao.findById(id);
        } else {
            producto = new Producto();
        }
        return producto;
    }

    public void save() {
        productoDao.save(this);
    }

    public void delete() {
        productoDao.delete(this);
    }
}
