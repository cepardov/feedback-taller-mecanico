package com.models.dao;

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
import com.models.entity.Cliente;

public class Clientedao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }

    
public List<Cliente>findPorNombre(String nombre){
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM cliente WHERE nombre LIKE ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1,"%"+nombre+"%");
            result = stmt.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(result.getString("rutcliente"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setPaterno(result.getString("apellidop"));
                cliente.setMaterno(result.getString("apellidom"));
                cliente.setTelefono(result.getInt("telefono"));
                cliente.setEmail(result.getString("email"));
                listaClientes.add(cliente);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaClientes;

}    
    
    
    
    public List<Cliente> findAll() {
        List<Cliente> listaClientes = new LinkedList<Cliente>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM cliente";
            Statement stmt = getConnection().createStatement();
            result = stmt.executeQuery(query);

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(result.getString("rutcliente"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setPaterno(result.getString("apellidop"));
                cliente.setMaterno(result.getString("apellidom"));
                cliente.setTelefono(result.getInt("telefono"));
                cliente.setEmail(result.getString("email"));
                listaClientes.add(cliente);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaClientes;
    }

    public Cliente findByRut(String clienteRut) {
        ResultSet result = null;
        Cliente cliente = null;

        try {
            // Componemos la sentencia SQL para obtener los productos.
            String query = "SELECT * FROM cliente WHERE  rutcliente = ?";

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
            cliente.setRut(result.getString("rutcliente"));
            cliente.setNombre(result.getString("nombre"));
            cliente.setPaterno(result.getString("apellidop"));
            cliente.setMaterno(result.getString("apellidom"));
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

    public void save(Cliente cliente) {

        PreparedStatement saveCliente;
        try {

            if (cliente.getRut() == null) {
                saveCliente = getConnection().prepareStatement(
                        "INSERT INTO cliente (rutcliente, nombre, apellidop, apellidom, telefono , email) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                saveCliente.setString(1, cliente.getRut());
                saveCliente.setString(2, cliente.getNombre());
                saveCliente.setString(3, cliente.getPaterno());
                saveCliente.setString(4, cliente.getMaterno());
                saveCliente.setInt(5, cliente.getTelefono());
                saveCliente.setString(6, cliente.getEmail());
                System.out.println("INSERT INTO ....");
            } else {
                saveCliente = getConnection().prepareStatement(
                        "UPDATE productos SET rutcliente = ?, nombre = ?, apellidop = ?,"
                        + " apellidom = ?, telefono = ?, email = ? WHERE  rutcliente = ?");
                saveCliente.setString(1, cliente.getRut());
                saveCliente.setString(2, cliente.getNombre());
                saveCliente.setString(3, cliente.getPaterno());
                saveCliente.setString(4, cliente.getMaterno());
                saveCliente.setInt(5, cliente.getTelefono());
                saveCliente.setString(6, cliente.getEmail());
            }

            saveCliente.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Cliente cliente) {
        PreparedStatement delCliente;
        try {

            if (cliente.getRut() != null) {
                delCliente = getConnection().prepareStatement(
                        "DELETE FROM cliente WHERE rutcliente = ?");

                delCliente.setString(1, cliente.getRut());
                delCliente.executeUpdate();
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
