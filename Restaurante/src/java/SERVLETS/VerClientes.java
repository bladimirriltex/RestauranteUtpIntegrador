/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.ClienteDAO;
import DTO.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gianpiero
 */
@WebServlet(name = "VerClientes", urlPatterns = {"/VerClientes"})
public class VerClientes extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
  response.setContentType("text/html");
  List<Cliente> list=ClienteDAO.getAllClientes();
  request.setAttribute("listClientes", list);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/verClientes_1.jsp");
  view.forward(request,response);
 }
}
