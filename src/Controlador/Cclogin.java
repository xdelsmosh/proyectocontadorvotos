/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.logindb;
import Vista.menu;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author yajai
 */
public class Cclogin {
    public void validarUsuario(JTextField usuario, JPasswordField contraseña){
        
        try{
            ResultSet rs = null;
            
            PreparedStatement ps = null;
            Controlador.Conexion objetoConexion = new Controlador.Conexion();
            String consultar = "select * from login where login.usuario = (?) and login.pass = (?);";
            String contra = String.valueOf(contraseña.getPassword());
            
            ps = objetoConexion.getConnection().prepareStatement(consultar);
            
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "El usuario es correcto :) ");
                menu newframe = new menu();
      
                newframe.setVisible(true);
                
             

                
            }
            else{
                JOptionPane.showMessageDialog(null, "el usuario es incorrecto");
            }

            

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error en usuario"+e.toString());
            System.err.println("Error: " + e);
        }
        
    }
    
}
