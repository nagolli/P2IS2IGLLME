<%-- 
    Document   : index
    Created on : 28-nov-2017, 18:15:22
    Author     : Ignacio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Presupuesto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Presupuesto2" method="post">
        <table>
                
        <tr><td colspan= "4"><p id="center"><b>Presupuestos de alquiler </b></p></td></tr>  
        <tr><td>Pares de esquis</td><td colspan= "2"><input type="number" min="0" max="255" value="0" name="esquis"></td><td></td></tr> 
        <tr><td>Pares de palos</td><td colspan= "2"><input type="number" min="0" max="255" value="0" name="palos"></td><td></td></tr> 
        <tr><td>Pares de botas</td><td colspan= "2"><input type="number" min="0" max="255" value="0" name="botas"></td><td></td></tr> 
        <tr><td>Tablas de Snowboard</td><td colspan= "2"><input type="number" min="0" max="255" value="0" name="tablas"></td><td></td></tr> 
        <tr><td>Dias Alquiler</td><td colspan= "2"><input type="number" min="1" max="365" required name="dias"></td><td></td></tr> 
        
        <tr>
        <td align="right" colspan= "2"><input type="reset" name="vaciar" value="Reset"/></td>
        <td colspan= "2"><input type="submit" name="submit" value="Calcular"/></td>
        </tr>    
        </table>
        </form> 
    </body>
</html>



