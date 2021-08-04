/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Castañeda Grupo 52
 */
public class modelConexionBD {

    private Connection conexion;
    private Statement comando;
    private ResultSet registro;
    private String sentencia;

    /**
     * @param args the command line arguments
     */
    public modelConexionBD() {
        cargarDriver();
    }

    public void cargarDriver() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void conectar() {
        try
        {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/basedatosbit", "root", "");
            comando = getConexion().createStatement();
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void desconectar() {
        try
        {
            getConexion().close();
            getComando().close();
        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @return the comando
     */
    public Statement getComando() {
        return comando;
    }

    /**
     * @return the registro
     */
    public ResultSet getRegistro() {
        return registro;
    }

    /**
     * @return the sentencia
     */
    public String getSentencia() {
        return sentencia;
    }

    
    
}
