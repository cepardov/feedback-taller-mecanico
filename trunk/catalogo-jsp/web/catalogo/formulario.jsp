<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.beans.*, models.entity.*"%>

<jsp:useBean id="producto" class="models.beans.ProductoBean" scope="request"></jsp:useBean>

<jsp:setProperty property="id" name="producto" />

<% Producto prod = producto.findById();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Producto</title>
</head>
<body>
<h3>Formulario Producto</h3>


<form method="post" action="<%= application.getContextPath() %>/catalogo/guardar.jsp">
    <input type="hidden" name="id" value="<%=prod.getId()%>"/>
    <table border="1">
        <tbody>
            <tr>
                <td><span>Nombre</span></td>
                <td><input size="40" type="text" name="nombre" value="<%=prod.getNombre()==null?"":prod.getNombre()%>"/></td>
            </tr>
            <tr>
                <td><span>Cantidad</span></td>
                <td><input type="text" name="cantidad" value="<%=prod.getCantidad()==0?"":prod.getCantidad()%>"/></td>
            </tr>
            <tr>
                <td><span>Precio</span></td>
                <td><input type="text" name="precio" value="<%=prod.getPrecio()==0?"":prod.getPrecio()%>"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="guardar" value="Guardar"/></td>
            </tr>
        </tbody>
    </table>
</form>
</body>
</html>