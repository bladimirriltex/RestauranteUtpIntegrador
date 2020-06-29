<%-- 
    Document   : verClientes
    Created on : 24/06/2020, 05:39:04 PM
    Author     : Gianpiero
--%>
<%@page import="DTO.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="SERVLETS.VerClientes"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Tus Clientes</title>
    </head>
    <body>
        <%
		List<Cliente> listClientes = (List<Cliente>) request.getAttribute("listClientes");
                
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
				for (Cliente c : listClientes) {
                                    out.print("<tr><td>" + c.getId() + "</td><td>" + c.getNombres() + "</td><td>" + c.getApellidos() + "</td><td>"+ c.getCelular() + "</td><td>"+ c.getDistrito() + "</td><td>"+ c.getDireccion()
                                    + "</td><td><a href='EditarCliente?id=" + c.getId() + "'>Editar</a><a href='EliminarCliente?id=" + c.getId() + "'>Eliminar</a></td></tr>");
				}
                            %>
                        </table>
                    </div>
                
            
    </body>
</html>
