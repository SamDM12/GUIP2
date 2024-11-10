/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;
/**
 *
 * @author chedr
 */
public class DataBaseConnection {
    private final String URL = "jdbc:mysql://localhost:3306/ParalympicGames";
    private final String USER = "root";
    private final String PASSWORD = "baseDatos1";
    
    private Connection conn = null;
    public DataBaseConnection(){
        try{
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);      
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void desconectar(){
        try{
           if (this.conn != null) conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
