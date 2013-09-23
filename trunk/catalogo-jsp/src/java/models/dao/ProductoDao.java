package models.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import models.entity.Producto;
import utilidades.DataBaseInstance;

public class ProductoDao {

    protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }

    public List<Producto> findAll() {
        List<Producto> listaProducto = new LinkedList<Producto>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM APP.productos";
            Statement stmt = getConnection().createStatement();
            result = stmt.executeQuery(query);

            while (result.next()) {
                Producto producto = new Producto();
                producto.setId(result.getInt("id"));
                producto.setNombre(result.getString("nombre"));
                producto.setPrecio(result.getInt("precio"));
                producto.setCantidad(result.getInt("cantidad"));
                listaProducto.add(producto);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaProducto;
    }

    public Producto findById(int productoId) {
        ResultSet result = null;
        Producto producto = null;

        try {
            // Componemos la sentencia SQL para obtener los productos.
            String query = "SELECT * FROM APP.productos WHERE  id = ?";

            // Ejecutamos la query y obtenemos el resultado.
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, productoId);
            result = stmt.executeQuery();

            // Vemos si no ha devuelto ningun resultado.
            if (!result.next()) {
                throw new SQLException();
            }

            // Construimos una VO para el producto.
            producto = new Producto();
            producto.setId(result.getInt("id"));
            producto.setNombre(result.getString("nombre"));
            producto.setPrecio(result.getInt("precio"));
            producto.setCantidad(result.getInt("cantidad"));

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return producto;
    }

    public void save(Producto producto) {

        PreparedStatement saveProduct;
        try {

            if (producto.getId() == 0) {
                saveProduct = getConnection().prepareStatement(
                        "INSERT INTO APP.productos (nombre ,precio ,cantidad) "
                        + "VALUES (?, ?, ?)");
                saveProduct.setString(1, producto.getNombre());
                saveProduct.setInt(2, producto.getPrecio());
                saveProduct.setInt(3, producto.getCantidad());
                System.out.println("INSERT INTO ....");
            } else {
                saveProduct = getConnection().prepareStatement(
                        "UPDATE APP.productos SET nombre = ?, precio = ?, cantidad = ? WHERE  id = ?");
                saveProduct.setString(1, producto.getNombre());
                saveProduct.setInt(2, producto.getPrecio());
                saveProduct.setInt(3, producto.getCantidad());
                saveProduct.setInt(4, producto.getId());
            }

            saveProduct.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Producto producto) {
        PreparedStatement saveProduct;
        try {

            if (producto.getId() > 0) {
                saveProduct = getConnection().prepareStatement(
                        "DELETE FROM APP.productos WHERE id = ?");

                saveProduct.setInt(1, producto.getId());
                saveProduct.executeUpdate();
            }


            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    protected void closeConnection() {
        DataBaseInstance.closeConnection();
    }
}
