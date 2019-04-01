/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que controla las conexión a la base de datos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class GestionSql {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVER = "jdbc:mysql://127.0.0.1/";
    private static final String DATABASE = "bdffcompany";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }
    
    /**
     * Método que crea/abre la conexión a la base de datos
     * 
     * @return Connection La conexión creada/abierta
     */
    public static Connection openConnection() {
        try {
            Connection con = DriverManager.getConnection(SERVER + DATABASE, 
                    USERNAME, PASSWORD);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        return null;
    }
    
    /**
     * Procedimiento que cierra la conexión a la base de datos
     * 
     * @param con Conexión a cerrar
     */
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }
    
    
    
}
