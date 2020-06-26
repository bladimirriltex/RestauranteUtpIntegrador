/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.ConnectionManager;
import DTO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gianpiero
 */
public class ClienteDAO {
    private static Connection con = null;
    public static int save(Cliente c) {
        int status=0;
        try{
            con = ConnectionManager.getConnection();
            
            PreparedStatement ps = con.prepareStatement("insert into Cliente(nombres,apellidos,dni,celular,distrito,direccion,correo,password) values (?,?,?,?)");
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setInt(3, c.getDni());
            ps.setInt(4, c.getCelular());
            ps.setString(5, c.getDistrito());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getCorreo());
            ps.setString(8, c.getPassword());
            
            status = ps.executeUpdate();
            
            con.close();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int update(Cliente c){
        int status=0;
        try{
            con = ConnectionManager.getConnection();
            
            PreparedStatement ps = con.prepareStatement("update Cliente nombres=?,apellidos=?,dni=?,celular=?,distrito=?,direccion=?,correo=?,password=? where id=?");
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getApellidos());
            ps.setInt(4, c.getDni());
            ps.setInt(5, c.getCelular());
            ps.setString(6, c.getDistrito());
            ps.setString(7, c.getDireccion());
            ps.setString(8, c.getCorreo());
            ps.setString(9, c.getPassword());
            
            status = ps.executeUpdate();
            
            con.close();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
        
    }
    
}
