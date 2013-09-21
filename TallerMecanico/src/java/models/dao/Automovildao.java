
package models.dao;

import com.feedback.utilities.DataBaseInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.entity.Automovil;
import models.beans.Automovilbeans;

public class Automovildao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }

//falta modificar    
public List<Automovil>findPorPatente(String nombre){
        List<Automovil> listaAutomovil = new ArrayList<Automovil>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM automovil WHERE patente LIKE ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1,"%"+nombre+"%");
            result = stmt.executeQuery();

            while (result.next()) {
                Automovil automovil = new Automovil();
                automovil.setPatente(result.getString("Patente"));
                automovil.setRutcliente(result.getString("rutcliente"));
                automovil.setColor(result.getString("color"));
                automovil.setMarca(result.getInt("materno"));
                automovil.setModelo(result.getInt("modelo"));
                automovil.setAño(result.getInt("año"));
                automovil.setCilindrada(result.getInt("cilindrada"));
                listaAutomovil.add(automovil);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaAutomovil;

}    
    
    
    
    public List<Automovil> findAll() {
        List<Automovil> listaAutomovil = new LinkedList<Automovil>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM cliente";
            Statement stmt = getConnection().createStatement();
            result = stmt.executeQuery(query);

            while (result.next()) {
                Automovil automovil = new Automovil();
                automovil.setPatente(result.getString("Patente"));
                automovil.setRutcliente(result.getString("rutcliente"));
                automovil.setColor(result.getString("color"));
                automovil.setMarca(result.getInt("materno"));
                automovil.setModelo(result.getInt("modelo"));
                automovil.setAño(result.getInt("año"));
                automovil.setCilindrada(result.getInt("cilindrada"));
                listaAutomovil.add(automovil);
            }

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return listaAutomovil;
    }

    public Automovil findByPatente(String patente) {
        ResultSet result = null;
        Automovil automovil= null;

        try {
            // Componemos la sentencia SQL para obtener los productos.
            String query = "SELECT * FROM autmovil WHERE  patente = ?";

            // Ejecutamos la query y obtenemos el resultado.
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, patente);
            result = stmt.executeQuery();

            // Vemos si no ha devuelto ningun resultado.
            if (!result.next()) {
                throw new SQLException();
            }

            // Construimos una VO para el producto.
            automovil = new Automovil();
                automovil.setPatente(result.getString("Patente"));
                automovil.setRutcliente(result.getString("rutcliente"));
                automovil.setColor(result.getString("color"));
                automovil.setMarca(result.getInt("materno"));
                automovil.setModelo(result.getInt("modelo"));
                automovil.setAño(result.getInt("año"));
                automovil.setCilindrada(result.getInt("cilindrada"));
                

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return automovil;
    }

    public void save(Automovil automovil) {

        PreparedStatement saveAuto;
        try {

            if (automovil.getPatente() == null) {
                saveAuto = getConnection().prepareStatement(
                        "INSERT INTO Automovil (patente, rutcliente, color, marca, modelo, año, cilindrada) "
                        + "VALUES (?, ?, ?, ?, ?, ?,?)");
                saveAuto.setString(1, automovil.getPatente());
                saveAuto.setString(2, automovil.getRutcliente());
                saveAuto.setString(3, automovil.getColor());
                saveAuto.setInt(4, automovil.getMarca());
                saveAuto.setInt(5, automovil.getModelo());
                saveAuto.setInt(6, automovil.getAño());
                saveAuto.setInt(7, automovil.getCilindrada());
                System.out.println("INSERT INTO ....");
            } else {
                saveAuto = getConnection().prepareStatement(
                        "UPDATE automovil SET patente = ?,rutcliente = ?, año = ?, marca = ?, modelo = ?, año = ?, cilinrdrada=? WHERE  patente = ?");
                saveAuto.setString(1, automovil.getPatente());
                saveAuto.setString(2, automovil.getRutcliente());
                saveAuto.setInt(3, automovil.getAño());
                saveAuto.setInt(4, automovil.getMarca());
                saveAuto.setInt(5, automovil.getModelo());
                saveAuto.setInt(6, automovil.getAño());
                saveAuto.setInt(7, automovil.getCilindrada());
            }

            saveAuto.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Automovil cliente) {
        PreparedStatement saveProduct;
        try {

            if (cliente.getPatente() != null) {
                saveProduct = getConnection().prepareStatement(
                        "DELETE FROM automovil WHERE Patente = ?");

                saveProduct.setString(1, cliente.getPatente());
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
