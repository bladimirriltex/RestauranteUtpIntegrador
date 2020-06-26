<%-- 
    Document   : verClientes
    Created on : 24/06/2020, 05:39:04 PM
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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Tus Clientes</title>
    </head>
    <body>
        
                <div>
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
                        ps=con.prepareStatement("select * from Clientes");
                        rs=ps.executeQuery();
                    %>
                    <div class="container">
                        <table class="table table-bordered">
                            <tr>
                                <th class="text-center">Id</th>
                                <th class="text-center">Nombres</th>
                                <th class="text-center">Apellidos</th>
                                <th class="text-center">Celular</th>
                                <th class="text-center">Distrito</th>
                                <th class="text-center">Direccion</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                            <%
                        while(rs.next()){
                            %>
                            <tr>
                                <td class="text-center"><%= rs.getString("id")%></td>
                                <td class="text-center"><%= rs.getString("nombres")%></td>
                                <td class="text-center"><%= rs.getString("apellidos")%></td>
                                <td class="text-center"><%= rs.getString("celular")%></td>
                                <td class="text-center"><%= rs.getString("distrito")%></td>
                                <td class="text-center"><%= rs.getString("direccion")%></td>
                                <td>
                                    <a class="btn btn-warning btn-sm" href="eliminarCliente.jsp?id=<%= rs.getString("id")%>">Editar</a>
                                    <a class="btn btn-danger btn-sm" href="eliminarCliente.jsp?id=<%= rs.getString("id")%>">Eliminar</a>
                                </td>
                            </tr>
                            <%
                            }
                            %>
                        </table>
                    </div>
                </div>
            
    </body>
</html>
