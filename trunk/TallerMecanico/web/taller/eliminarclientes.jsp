<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cliente" class="com.models.beans.Clientebeans" scope="request"></jsp:useBean>

<jsp:setProperty property="rut" name="cliente" />
<%
cliente.delete();

response.sendRedirect(request.getContextPath() + "/taller/listadoclientes.jsp");
%>
