/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models.dao;

import com.feedback.utilities.DataBaseInstance;
import com.models.entity.Cliente;
import com.models.entity.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cepardov
 */
public class Trabajadordao {
    protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    public List<Cliente>findPorNombre(String nombre){
        List<Cliente> listaProducto = new ArrayList<Cliente>();
        ResultSet result = null;

        try {

            String query = "SELECT * FROM ";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1,"%"+nombre+"%");
            result = stmt.executeQuery();

            while (result.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setRut(result.getString("rut"));
                trabajador.setNombre(result.getString("nombre"));
                trabajador.setPaterno(result.getString("materno"));
                trabajador.setMaterno(result.getString("paterno"));
                //listaProducto.add(trabajador);
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
    protected void closeConnection() {
        DataBaseInstance.closeConnection();
    }
}
