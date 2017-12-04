/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ignacio
 */
public class Datos extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos reservas</title>");
            out.println("</head>");
            out.println("<body>");

            try {
            ResultSet consulta = ConectorBD.obtenerDatos();
                if (consulta.wasNull()) {
                    out.println("<H1> Error al conectar con la base de datos </H1>");
                } else {
                    out.println("<table>");
                    out.println("<tr><td> Nombre");
                    out.println("</td><td> Apellidos");
                    out.println("</td><td> E-Mail");
                    out.println("</td><td> Telefono");
                    out.println("</td><td> Coste");
                    out.println("</td><td> Par Esquis");
                    out.println("</td><td> Par Palos");
                    out.println("</td><td> Par Botas");
                    out.println("</td><td> Tablas </td></tr>");
                    while (consulta.next()) {
                        out.println("<tr><td>" + consulta.getString("nombre"));
                        out.println("</td><td>" + consulta.getString("apellidos"));
                        out.println("</td><td>" + consulta.getString("email"));
                        out.println("</td><td>" + consulta.getInt("telefono"));
                        out.println("</td><td>" + consulta.getInt("coste"));
                        out.println("</td><td>" + consulta.getInt("esquis"));
                        out.println("</td><td>" + consulta.getInt("palos"));
                        out.println("</td><td>" + consulta.getInt("botas"));
                        out.println("</td><td>" + consulta.getInt("tablas") + " </td></tr>");
                    }
                    out.println("</table>");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                out.println("<H1> Error al acceder a la base de datos </H1>");
            }
            
            out.println("<TR><TD><a href=\"index.jsp\"> Inicio </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
