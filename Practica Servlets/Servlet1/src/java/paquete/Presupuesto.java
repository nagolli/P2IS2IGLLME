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
public class Presupuesto extends HttpServlet
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
        String CONTENT_TYPE = "text/html";
        int dias, esquis=0, botas=0, palos=0, tablas=0;
        String aux;
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        dias = Integer.parseInt(request.getParameter("dias"));
        aux = (request.getParameter("esquis"));
        if(aux!=null)
            esquis=Integer.parseInt(aux);
        aux = (request.getParameter("palos"));
        if(aux!=null)
            palos=Integer.parseInt(aux);
        aux = (request.getParameter("botas"));
        if(aux!=null)
            botas=Integer.parseInt(aux);
        aux = (request.getParameter("tablas"));
        if(aux!=null)
            tablas=Integer.parseInt(aux);
        
        String coste="El alquiler del material escogido es de "+coste(dias,esquis,palos,botas,tablas)+" euros";
        String tiempo;
        if(dias>1)
        tiempo="Detalle de material para "+dias+" dias";
        else
        tiempo="Detalle de material para "+dias+" dia";    
        String linea1 = esquis+" pares de esquis";
        String linea2 = palos+" pares de palos";
        String linea3 = botas+" pares de botas";
        String linea4 = tablas+" pares de tablas";
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Presupuesto");
        out.println("</title>");
        out.println("<BODY BGCOLOR=\"#FDF5E6\">");
        out.println("<TABLE>");
        out.println("<TR><TD>"+ coste+"</TD></TR>");
        out.println("<TR><TD>");
        out.println("<TR><TD>"+tiempo+"</TD></TR>");
        out.println("<TR><TD>");
        if(esquis>0)
        out.println("<TR><TD>"+linea1+"</TD></TR>");
        if(palos>0)
        out.println("<TR><TD>"+linea2+"</TD></TR>");
        if(botas>0)
        out.println("<TR><TD>"+linea3+"</TD></TR>");
        if(tablas>0)
        out.println("<TR><TD>"+linea4+"</TD></TR>");
        out.println("<TR><TD><a href=\"index.jsp\"> Regresar </a>");
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

    private int coste(int dias, int esquis, int palos, int botas, int tablas)
    {
        int coste=0;
        switch(dias){
            case 1: coste=(15*esquis+4*palos+10*botas+16*tablas)*dias;
                break;
            case 2:
            case 3:coste=(13*esquis+3*palos+9*botas+15*tablas)*dias;
                break;
            default:coste=(11*esquis+3*palos+8*botas+14*tablas)*dias;
                break;
        }
        return coste;
    }

}
