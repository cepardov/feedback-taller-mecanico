/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feedback.controller;

import java.sql.*;
/**
 *
 * @author cepardov
 */
public class Conexion {

    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/tallermecanico";
            String usuario="root";
            String clave="";
            return DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
