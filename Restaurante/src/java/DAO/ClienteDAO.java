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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public static int delete(int id){
        int status = 0;
        try{
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from Clientes where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            
            con.close();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    
    public static Cliente getClienteById(int id){
        Cliente c = new Cliente();
        try{
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Clientes where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDni(rs.getInt(4));
                c.setCelular(rs.getInt(5));
                c.setDistrito(rs.getString(6));
                c.setDireccion(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setPassword(rs.getString(9));
                
            }
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return c;
    }
    
    public static List<Cliente> getAllClientes() {
        List<Cliente> list = new ArrayList<Cliente>();
        
        try{
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from clientes");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDni(rs.getInt(4));
                c.setCelular(rs.getInt(5));
                c.setDistrito(rs.getString(6));
                c.setDireccion(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setPassword(rs.getString(9));
                list.add(c);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public static void main (String[] args){
        System.out.println(ClienteDAO.getAllClientes());
    }
}
