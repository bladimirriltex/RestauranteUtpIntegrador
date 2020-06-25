/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author Gianpiero
 */
public class ConnectionManager {
    private static String url="jdbc:mysql://localhost/votacion";
    private static String user="root";
    private static String password="";
    private static Connection conn;
    
    public static Connection getConnection(){
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL server succesfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
        getConnection();
    }
}
