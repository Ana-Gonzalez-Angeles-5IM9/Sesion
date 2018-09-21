package servlets;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Conexion {
    //Variables de conexion
    Connection con = null;
    Statement state;
    ResultSet res;
    
    public Conexion(){
        
    }
    public void conecta(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Lab3","root","n0m3l0");
        System.out.println("Si conecta");
        
        }catch(Exception eeee){
            System.out.print("No conecta");
        }
    }
    public void cierra() throws SQLException{
        con.close();
    }
    public int update(String update) throws SQLException{
        state = con.createStatement();
        return state.executeUpdate(update);
    }
    public ResultSet query(String query) throws SQLException{
        return state.executeQuery(query);
    }
}
