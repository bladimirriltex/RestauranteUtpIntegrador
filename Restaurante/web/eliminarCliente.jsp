<%-- 
    Document   : eliminarCliente
    Created on : 24/06/2020, 06:43:55 PM
    Author     : Gianpiero
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Cliente</title>
    </head>
    <body>
        <%
            Connection con;
            String url="jdbc:mysql://localhost/restaurante";
            String Driver="com.mysql.jdbc.Driver";
            String user="root";
            String clave="";
            Class.forName(Driver);
            con=DriverManager.getConnection(url,user,clave);
                                
                                
            PreparedStatement ps;
            ResultSet rs;
                                
            String id=request.getParameter("id");
            ps=con.prepareStatement("delete from Clientes where id="+id);
            ps.executeUpdate();
                                
            response.sendRedirect("verClientes.jsp");
                                
                                
        %>
    </body>
</html>
