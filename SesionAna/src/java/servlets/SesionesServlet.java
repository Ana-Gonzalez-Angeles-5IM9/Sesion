/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SesionesServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre;
        String apellido;
        
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("contra");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("usu", nombre);
        sesion.setAttribute("clave", apellido);

        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();

        out.println("<a href=\"/SesionAna/catalogo.jsp\"> Link al catalogo del carrito  </a>");
        out.println("<br>");
        out.println("ID de la sesi&oacute;n: " + sesion.getId());
    }

}
