/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletOutputStream;
import java.util.Date;

/**
 *
 * @author Ignacio
 */
public class Calculador extends HttpServlet
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
            out.println("<title>Servlet Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calculator at " + request.getContextPath() + "</h1>");
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
        String CONTENT_TYPE = "text/html";
        String Encabezado = "";
        String login, password;
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        Integer AccesosInt = new Integer(0);
        login = request.getParameter("login");
        if (login == null) {
            login = "";
        }
        password = request.getParameter("password");
        if (password == null) {
            password = "";
        }
// recuperar la sesión
        javax.servlet.http.HttpSession sesion = request.getSession(true);
        if (sesion.isNew()) { // la sesión es nueva
            Encabezado = "Bienvenido";
        } else {
            Encabezado = "Has vuelto";
            Integer AccesosViejo = (Integer) sesion.getAttribute("Accesos");
            if (AccesosViejo != null) {
                AccesosInt = new Integer(AccesosViejo.intValue() + 1);
            }
        }
        sesion.setAttribute("Accesos", AccesosInt);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SESIONES");
        out.println("</title>");
        out.println("<BODY BGCOLOR=\"#FDF5E6\">");
        out.println("<H1 ALIGN=\"CENTER\">" + Encabezado + "</H1>");
        out.println("<H2>Informacion de Sesion:</H2>");
        out.println("<TABLE BORDER=1 ALIGN=CENTER>");
        out.println("<TR BGCOLOR=\"#FFAD00\">");
        out.println("<TH>Tipo <TH>Valor");
        out.println("<TR><TD>ID");
        out.println("<TD>" + sesion.getId());
        out.println("<TR><TD>Tiempo de creacion");
        out.println("<TD>" + new Date(sesion.getCreationTime()));
        out.println("<TR><TD>Tiempo de acceso");
        out.println("<TD>" + new Date(sesion.getLastAccessedTime()));
        out.println("<TR><TD>Numero de accesos previos");
        out.println("<TD>" + (Integer) sesion.getAttribute("Accesos"));
        out.println("<TR><TD>Login");
        String Login = request.getParameter("login");
        sesion.setAttribute("Login", Login);
        out.println("<TD>" + Login);
        out.println("<TR><TD>Password");
        String Password = request.getParameter("password");
        sesion.setAttribute("Password", Password);
        out.println("<TD>" + Password);
        out.println("</TABLE>");
        out.println("</BODY></HTML>");
        out.close();
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
