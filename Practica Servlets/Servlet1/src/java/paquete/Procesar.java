/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ignacio
 */
public class Procesar extends HttpServlet
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
            out.println("<title>Servlet Procesar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Procesar at " + request.getContextPath() + "</h1>");
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
        javax.servlet.http.HttpSession sesion = request.getSession(true);
        String CONTENT_TYPE = "text/html";
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        int coste = (Integer) sesion.getAttribute("coste");
        int esquis = (Integer) sesion.getAttribute("esquis");
        int botas = (Integer) sesion.getAttribute("botas");
        int palos = (Integer) sesion.getAttribute("palos");
        int tabla = (Integer) sesion.getAttribute("tablas");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        int telefono = Integer.parseInt(request.getParameter("tel"));
        
        boolean exito=insertarDatos(nombre,apellidos,email,telefono,coste,esquis,palos,botas,tabla);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Gracias");
        out.println("</title>");
        out.println("</head>");
        out.println("<BODY BGCOLOR=\"#FDF5E6\">");
        if (exito) {
            out.println("<H1>");
            out.println("Gracias " + nombre + " " + apellidos + "<br>");
            out.println("Se ha registrado la reserva de su material de esqui por un coste de " + coste + " euros<br>");
            out.println("GRACIAS por disfrutar de tu tiempo libre con nosotros</H1>");
        } else {
            out.println("<H1> Error al introducir los datos </H1>");
            out.println("<TR><TD><a href=\"index.jsp\"> Inicio </a>");
        }
        out.println("</BODY></HTML>");
        out.close();
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

    //Para insertar datos en MYSQL
    private boolean insertarDatos(String nombre, String apellidos, String email, int telefono, int coste, int esquis, int palos, int botas, int tabla)
    {
        return true;
    }

}
