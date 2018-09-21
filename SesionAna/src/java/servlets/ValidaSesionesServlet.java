/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidaSesionesServlet extends HttpServlet {

    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String clave;
        String usu;
        
        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        Connection c = null;
        Statement s = null;
        ResultSet r;
        
        String titulo = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/LAB3", "root", "n0m3l0");
            s = c.createStatement();
            System.out.println("Se ha conectado a la base de datos");
        }catch(SQLException e){
            System.out.println("No se conecto a la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidaSesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        clave = (String) sesion.getAttribute("clave");
        usu = (String) sesion.getAttribute("usu");

        try {
            
            r = s.executeQuery("select * from usuarios where usu='" + usu + "' and contra='" + clave + "';");
            if (r.next()) {
                titulo = "llave correcta continua la sesion";
            }else{
                titulo = "llave incorrecta inicie nuevamente sesion";
            }

       
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ValidaSesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        //Mostramos los  valores en el cliente
        PrintWriter out = response.getWriter();
        out.println("¿Continua la Sesion y es valida?: " + titulo);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());

    }

}
