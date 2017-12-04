/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class ConectorBD
{
    static private Connection conexionBD;
    
    static public void abrirConexionBD() throws ClassNotFoundException, SQLException {
        if (conexionBD == null) { 
            String nombreConexionBD = "jdbc:mysql://localhost/ski"; //Ruta
                Class.forName("com.mysql.jdbc.Driver");
                conexionBD = DriverManager.getConnection(nombreConexionBD, "root", "");
        }
    }
    
    
    static public boolean insertarDatos(String nombre, String apellidos, String email, int telefono, int coste, int esquis, int palos, int botas, int tabla) {
        boolean ok = false;
        int clavePrimaria = -1;
        try {
            abrirConexionBD();
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }

        try {
            String con;

            Statement s = conexionBD.createStatement();
            con = "INSERT INTO reservas ( nombre, apellidos, email, telefono, coste, esquis, palos, botas, tablas)" + 
                    " VALUES ('" + nombre + "', '" + apellidos + "', '" + email + "', '" + telefono + "', '" + coste + "', '" + esquis + "', '" + palos + "',  '" + botas + "',  '" + tabla + "')";
            clavePrimaria = s.executeUpdate(con);

            if (clavePrimaria > 0) {
                ok = true;
            }
        } catch (Exception e) {
            System.out.println("Error ejecutando la inserción de la reserva en la BB.DD....");
        }
        return ok;
    }
    
    static public ResultSet obtenerDatos() throws SQLException, ClassNotFoundException {

        abrirConexionBD();

        ResultSet resultados = null;
            String con;
            Statement s = conexionBD.createStatement();
            con = "SELECT nombre, apellidos, email, telefono, coste, esquis, palos, botas, tablas FROM reservas";
            resultados = s.executeQuery(con);
        return resultados;
    }
        /*
            ResultSet resultado = ConectorBD.obtenerDatos();
              
            while (resultado.next()) {
                        resultado.getInt("nombre");
            }
        */        
}
