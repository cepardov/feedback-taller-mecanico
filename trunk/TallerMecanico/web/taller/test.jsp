<%-- 
    Document   : test
    Created on : 21-09-2013, 05:43:27 PM
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de ingreso de clientes</title>
    </head>
    <body>
        <form action="guardarclientes.jsp" method="post">
            <table>
                <tr><td>Rut</td><td><input type="text" name="rut"/></tr>
                <tr><td>Nombre</td><td><input type="text" name="nombre"/></tr>
                <tr><td>Apellido Paterno</td><td><input type="text" name="apellidop"/></tr>
                <tr><td>Apellido Materno</td><td><input type="text" name="apellidom"/></tr>
                <tr><td>Telefono</td><td><input type="text" name="telefono"/></tr>
                <tr><td>email</td><td><input type="text" name="email"/></tr>
                
            </table>
            <input type="submit" value="Guardar"/>
        </form>
    </body>
</html>
