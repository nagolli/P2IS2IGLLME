/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ignacio
 */
public class PresupuestoParte2 extends HttpServlet
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
            out.println("<title>Servlet Presupuesto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Presupuesto at " + request.getContextPath() + "</h1>");
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
        int dias, esquis = 0, botas = 0, palos = 0, tablas = 0;
        String aux;
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        dias = Integer.parseInt(request.getParameter("dias"));
        aux = (request.getParameter("esquis"));
        if (aux != null) {
            esquis = Integer.parseInt(aux);
        }
        aux = (request.getParameter("palos"));
        if (aux != null) {
            palos = Integer.parseInt(aux);
        }
        aux = (request.getParameter("botas"));
        if (aux != null) {
            botas = Integer.parseInt(aux);
        }
        aux = (request.getParameter("tablas"));
        if (aux != null) {
            tablas = Integer.parseInt(aux);
        }

        String coste = "El alquiler del material escogido es de " + coste(dias, esquis, palos, botas, tablas,sesion) + " euros";
        String tiempo, linea1, linea2, linea3, linea4;
        sesion.setAttribute("esquis", esquis);
        sesion.setAttribute("palos", palos);
        sesion.setAttribute("botas", botas);
        sesion.setAttribute("tablas", tablas);
        if (dias > 1) {
            tiempo = "Detalle de material para " + dias + " dias";
        } else {
            tiempo = "Detalle de material para " + dias + " dia";
        }
        if (esquis > 1) {
            linea1 = esquis + " pares de esquis";
        } else {
            linea1 = esquis + " par de esquis";
        }
        if (palos > 1) {
            linea2 = palos + " pares de palos";
        } else {
            linea2 = palos + " par de palos";
        }
        if (botas > 1) {
            linea3 = botas + " pares de botas";
        } else {
            linea3 = botas + " par de botas";
        }
        if (tablas > 1) {
            linea4 = tablas + " tablas";
        } else {
            linea4 = tablas + " tabla";
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Presupuesto");
        out.println("</title>");
        out.println("<BODY BGCOLOR=\"#FDF5E6\">");
        out.println("<TABLE>");
        out.println("<TR><TD>" + coste + "</TD></TR>");
        out.println("<TR><TD>");
        out.println("<TR><TD>" + tiempo + "</TD></TR>");
        out.println("<TR><TD>");
        if (esquis > 0) {
            out.println("<TR><TD>" + linea1 + "</TD></TR>");
        }
        if (palos > 0) {
            out.println("<TR><TD>" + linea2 + "</TD></TR>");
        }
        if (botas > 0) {
            out.println("<TR><TD>" + linea3 + "</TD></TR>");
        }
        if (tablas > 0) {
            out.println("<TR><TD>" + linea4 + "</TD></TR>");
        }
        out.println("<TR><TD><a href=\"index.jsp\"> Regresar </a>");
        out.println("<TR><TD><a href=\"datos.html\"> Registrar Alquiler </a>");
        out.println("</TABLE>");
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

    private int coste(int dias, int esquis, int palos, int botas, int tablas,javax.servlet.http.HttpSession sesion) throws IOException
    {
        int e1 = 15, p1 = 4, b1 = 10, t1 = 16, e2 = 13, p2 = 3, b2 = 9, t2 = 11, e3 = 3, p3 = 4, b3 = 8, t3 = 14;
        try (BufferedReader br = new BufferedReader(new FileReader("tarifas.txt"))) {
            //La ubicación de tarifas es en la carpeta de Tomcat/bin
            e1 = Integer.parseInt(br.readLine());
            p1 = Integer.parseInt(br.readLine());
            b1 = Integer.parseInt(br.readLine());
            t1 = Integer.parseInt(br.readLine());
            e2 = Integer.parseInt(br.readLine());
            p2 = Integer.parseInt(br.readLine());
            b2 = Integer.parseInt(br.readLine());
            t2 = Integer.parseInt(br.readLine());
            e3 = Integer.parseInt(br.readLine());
            p3 = Integer.parseInt(br.readLine());
            b3 = Integer.parseInt(br.readLine());
            t3 = Integer.parseInt(br.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PresupuestoParte2.class.getName()).log(Level.SEVERE, null, ex);
        }
        int coste = 0;
        switch (dias) {
            case 1:
                coste = (e1 * esquis + p1 * palos + b1 * botas + t1 * tablas) * dias;
                break;
            case 2:
            case 3:
                coste = (e2 * esquis + p2 * palos + b2 * botas + t2 * tablas) * dias;
                break;
            default:
                coste = (e3 * esquis + p3 * palos + b3 * botas + t3 * tablas) * dias;
                break;
        }
        sesion.setAttribute("coste", coste);
        return coste;
    }
}