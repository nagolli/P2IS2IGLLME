<%-- 
    Document   : index
    Created on : 19-dic-2017, 8:10:08
    Author     : Ignacio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reparto de regalos</h1>
        <%
            //FORMULARIO QUE PIDE 4 REGALOS: X Y (0-500) PESO (1 a 5)
            //Seleccionar persona que entrega
            //En caso de error va a página de error
        %>
        <form action="Grafico.jsp" method="post">
            <table>
                <tr><td></td><td>Coord X</td><td>Coord Y</td><td>Peso Regalo</td>
                <tr><td>Regalo 1</td>
                    <td><input type="number" min="0" max="500" value="0" name="x1"></td>
                    <td><input type="number" min="0" max="500" value="0" name="y1"></td>
                    <td><input type="number" min="1" max="5" value="1" name="p1"></td></tr> 
                <tr><td>Regalo 2</td>
                    <td><input type="number" min="0" max="500" value="0" name="x2"></td>
                    <td><input type="number" min="0" max="500" value="0" name="y2"></td>
                    <td><input type="number" min="1" max="5" value="1" name="p2"></td></tr> 
                <tr><td>Regalo 3</td>
                    <td><input type="number" min="0" max="500" value="0" name="x3"></td>
                    <td><input type="number" min="0" max="500" value="0" name="y3"></td>
                    <td><input type="number" min="1" max="5" value="1" name="p3"></td></tr> 
                <tr><td>Regalo 4</td>
                    <td><input type="number" min="0" max="500" value="0" name="x4"></td>
                    <td><input type="number" min="0" max="500" value="0" name="y4"></td>
                    <td><input type="number" min="1" max="5" value="1" name="p4"></td></tr> 
                <tr><td>Repartidor</td><td colspan= "3">
                        <select name="persona">
                            <option value="noel">Papa Noel</option>
                            <option value="melchor">Melchor</option>
                            <option value="gaspar">Gaspar</option>
                            <option value="baltasar">Baltasar</option>
                        </select>    
                    </td></tr> 

                <tr>
                    <td align="right" colspan= "2"><input type="reset" name="vaciar" value="Reset"/></td>
                    <td colspan= "2"><input type="submit" name="submit" value="Calcular"/></td>
                </tr>    
            </table>
        </form> 
    </table>
    
    
    
</body>
</html>
