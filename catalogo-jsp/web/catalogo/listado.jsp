<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <%@ page import="java.util.List,models.beans.*, models.entity.*"%>

<jsp:useBean id="producto" class="models.beans.ProductoBean" scope="request"></jsp:useBean>

<% List<Producto> listadoProductos = producto.findAll();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body>
<h3>Listado de Productos</h3>
<p><a href="<%=request.getContextPath() %>/catalogo/formulario.jsp">Agregar Producto (+)</a></p>
<table>
	<tr>
		<th>#</th>
		<th>Nombre</th>
		<th>Precio</th>
		<th>Cantidad</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<% for(Producto prod : listadoProductos){ %>
		<tr>
			<td><%= prod.getId() %></td>
			<td><%= prod.getNombre() %></td>
			<td><%= prod.getPrecio() %></td>
			<td><%= prod.getCantidad() %></td>
			<td><a href="<%= request.getContextPath() %>/catalogo/formulario.jsp?id=<%= prod.getId()%>">
			editar</a></td>
                        <td><a onclick="return confirm('Esta seguro?');" href="<%= request.getContextPath() %>/catalogo/eliminar.jsp?id=<%= prod.getId()%>">
			eliminar</a></td>
		</tr>
	<%} %>
</table>
</body>
</html>