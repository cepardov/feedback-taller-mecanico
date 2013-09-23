package com.feedback.utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseInstance {
     private static java.sql.Connection conn;
    private static String login ="root";
    private static String password ="";
    private static String url = "jdbc:derby://localhost:1527/tallermecanico";

    public static java.sql.Connection getInstanceConnection() {
        if (!(conn instanceof java.sql.Connection)) {
            System.out.println("Conectando a la BD.");
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(url, login, password);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
        }
        System.out.println(conn);
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn instanceof java.sql.Connection) {
                conn.close();
                conn = null;
                System.out.println("Se ha cerrado la conexi�n de BD con exito.");
            }

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error al cerrar la conexi�n de BD.");
            System.err.println(se.getMessage());
        }
    }
}