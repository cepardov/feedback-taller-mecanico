<%-- 
    Document   : confirmarcliente
    Created on : 23-09-2013, 12:43:14 PM
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="Cliente" class="models.beans.Clientebeans" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="Cliente" />
<%
Cliente.save();

response.sendRedirect(request.getContextPath() + "/taller/ingresoautos.jsp");
%>

