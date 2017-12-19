<%-- 
    Document   : Grafico
    Created on : 19-dic-2017, 12:05:07
    Author     : Ignacio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="P6.Utilidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        int x1=Integer.parseInt(request.getParameter("x1"));
        int y1=Integer.parseInt(request.getParameter("y1"));
        int p1=Integer.parseInt(request.getParameter("p1"));
        int x2=Integer.parseInt(request.getParameter("x2"));
        int y2=Integer.parseInt(request.getParameter("y2"));
        int p2=Integer.parseInt(request.getParameter("p2"));
        int x3=Integer.parseInt(request.getParameter("x3"));
        int y3=Integer.parseInt(request.getParameter("y3"));
        int p3=Integer.parseInt(request.getParameter("p3"));
        int x4=Integer.parseInt(request.getParameter("x4"));
        int y4=Integer.parseInt(request.getParameter("y4"));
        int p4=Integer.parseInt(request.getParameter("p4"));
        String pers=request.getParameter("persona");
        String color="red";
        if(pers.equalsIgnoreCase("melchor"))
        {
            color="blue";
        }
        if(pers.equalsIgnoreCase("gaspar"))
        {
            color="green";
        }
        if(pers.equalsIgnoreCase("baltasar"))
        {
            color="yellow";
        }
        ArrayList<ArrayList<Integer>> datos=Utilidades.montarDatos(x1, y1, p1, x2, y2, p2, x3, y3, p3, x4, y4, p4);
        ArrayList<Integer> camino = Utilidades.MejorCamino(datos);
        
        

        %>
        
        
        
        
        <h1>Ruta a seguir:</h1>
        <svg height="500" width="500">
        <polyline points="0,0 0,500 500,500 500,0 0,0" style="fill:white;stroke:black;stroke-width:3" />
        <polyline points="0,0 <%=datos.get(camino.get(0)-1).get(0)%>,<%=datos.get(camino.get(0)-1).get(1)
                  %> <%=datos.get(camino.get(1)-1).get(0)%>,<%=datos.get(camino.get(1)-1).get(1)
                  %> <%=datos.get(camino.get(2)-1).get(0)%>,<%=datos.get(camino.get(2)-1).get(1)
                  %> <%=datos.get(camino.get(3)-1).get(0)%>,<%=datos.get(camino.get(3)-1).get(1)
                  %> " style="fill:white;stroke:<%=color%>;stroke-width:3" />

        <circle cx="<%=datos.get(camino.get(0)-1).get(0)%>" cy="<%=datos.get(camino.get(0)-1).get(1)%>" r="<%=datos.get(camino.get(0)-1).get(2)%>" stroke="black" stroke-width="<%=datos.get(camino.get(0)-1).get(2)%>" fill="<%=color%>" />
        <circle cx="<%=datos.get(camino.get(1)-1).get(0)%>" cy="<%=datos.get(camino.get(1)-1).get(1)%>" r="<%=datos.get(camino.get(1)-1).get(2)%>" stroke="black" stroke-width="<%=datos.get(camino.get(1)-1).get(2)%>" fill="<%=color%>" />
        <circle cx="<%=datos.get(camino.get(2)-1).get(0)%>" cy="<%=datos.get(camino.get(2)-1).get(1)%>" r="<%=datos.get(camino.get(2)-1).get(2)%>" stroke="black" stroke-width="<%=datos.get(camino.get(2)-1).get(2)%>" fill="<%=color%>" />
        <circle cx="<%=datos.get(camino.get(3)-1).get(0)%>" cy="<%=datos.get(camino.get(3)-1).get(1)%>" r="<%=datos.get(camino.get(3)-1).get(2)%>" stroke="black" stroke-width="<%=datos.get(camino.get(3)-1).get(2)%>" fill="<%=color%>" />

        </svg>
        
    </body>
</html>
