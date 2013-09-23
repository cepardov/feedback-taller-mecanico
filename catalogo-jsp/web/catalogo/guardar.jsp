<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="producto" class="models.beans.ProductoBean" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="producto" />
<%
producto.save();

response.sendRedirect(request.getContextPath() + "/catalogo/listado.jsp");
%>
