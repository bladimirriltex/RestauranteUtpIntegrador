<%-- 
    Document   : verCliente
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
        <title>Tus Clientes</title>
    </head>
    <body>
        <div>
            <div>
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
                    <div>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Celular</th>
                                <th>Distrito</th>
                                <th>Direccion</th>
                            </tr>
                            <%
                        while(rs.next()){
                            %>
                            <tr>
                                <td><%= rs.getString("id")%></td>
                                <td><%= rs.getString("nombres")%></td>
                                <td><%= rs.getString("apellidos")%></td>
                                <td><%= rs.getString("celular")%></td>
                                <td><%= rs.getString("distrito")%></td>
                                <td><%= rs.getString("direccion")%></td>
                                <td>
                                    <a href="eliminarCliente.jsp?id=<%= rs.getString("id")%>">Eliminar</a>
                                </td>
                            </tr>
                            <%
                            }
                            %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
