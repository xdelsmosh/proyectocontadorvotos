package Controlador;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conn;
    private String url = "jdbc:mysql://127.0.0.1:3306/db_tiendae";
    private String user = "root";
    private String pass = "root";
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null,"Conexión establecida");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error de conexcion con la base de datos"+e.toString());
            System.err.println("Error: " + e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
}
