

package models.dao;

import com.feedback.utilities.DataBaseInstance;
import static com.feedback.utilities.DataBaseInstance.closeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.entity.Cliente;

public class Clientedao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }

    
public List<Cliente>findPorNombre(String nombre){
        List<Cliente> listaProducto = new ArrayList<Cliente>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM cliente WHERE nombre LIKE ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1,"%"+nombre+"%");
            result = stmt.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(result.getString("rut"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setPaterno(result.getString("materno"));
                cliente.setMaterno(result.getString("paterno"));
                cliente.setTelefono(result.getInt("telefono"));
                cliente.setEmail(result.getString("email"));
                listaProducto.add(cliente);
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
    
    
    
    public List<Cliente> findAll() {
        List<Cliente> listaCliente = new LinkedList<Cliente>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM cliente";
            Statement stmt = getConnection().createStatement();
            result = stmt.executeQuery(query);

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(result.getString("rut"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setPaterno(result.getString("paterno"));
                cliente.setMaterno(result.getString("materno"));
                cliente.setTelefono(result.getInt("telefono"));
                cliente.setEmail(result.getString("email"));
                listaCliente.add(cliente);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaCliente;
    }

    public Cliente findByRut(String clienteRut) {
        ResultSet result = null;
        Cliente cliente = null;

        try {
            // Componemos la sentencia SQL para obtener los productos.
            String query = "SELECT * FROM cliente WHERE  rut = ?";

            // Ejecutamos la query y obtenemos el resultado.
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, clienteRut);
            result = stmt.executeQuery();

            // Vemos si no ha devuelto ningun resultado.
            if (!result.next()) {
                throw new SQLException();
            }

            // Construimos una VO para el producto.
            cliente = new Cliente();
            cliente.setRut(result.getString("rut"));
            cliente.setNombre(result.getString("nombre"));
            cliente.setPaterno(result.getString("paterno"));
            cliente.setMaterno(result.getString("materno"));
            cliente.setTelefono(result.getInt("telefono"));
            cliente.setEmail(result.getString("email"));

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return cliente;
    }

//    public void save(Cliente cliente) {
//
//        PreparedStatement saveProduct;
//        try {
//
//            if (cliente.getRut() == null) {
//                saveProduct = getConnection().prepareStatement(
//                        "INSERT INTO cliente (rut, nombre, paterno, materno, precio ,cantidad) "
//                        + "VALUES (?, ?, ?)");
//                saveProduct.setString(1, producto.getNombre());
//                saveProduct.setInt(2, producto.getPrecio());
//                saveProduct.setInt(3, producto.getCantidad());
//                System.out.println("INSERT INTO ....");
//            } else {
//                saveProduct = getConnection().prepareStatement(
//                        "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE  id = ?");
//                saveProduct.setString(1, producto.getNombre());
//                saveProduct.setInt(2, producto.getPrecio());
//                saveProduct.setInt(3, producto.getCantidad());
//                saveProduct.setInt(4, producto.getId());
//            }
//
//            saveProduct.executeUpdate();
//            closeConnection();
//        } catch (SQLException se) {
//            System.err.println("Se ha producido un error de BD.");
//            System.err.println(se.getMessage());
//        }
//    }
//
//    public void delete(Producto producto) {
//        PreparedStatement saveProduct;
//        try {
//
//            if (producto.getId() > 0) {
//                saveProduct = getConnection().prepareStatement(
//                        "DELETE FROM productos WHERE id = ?");
//
//                saveProduct.setInt(1, producto.getId());
//                saveProduct.executeUpdate();
//            }
//
//
//            closeConnection();
//        } catch (SQLException se) {
//            System.err.println("Se ha producido un error de BD.");
//            System.err.println(se.getMessage());
//        }
//    }
//
//    protected void closeConnection() {
//        DataBaseInstance.closeConnection();
//    }
}
