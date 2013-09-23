<%-- 
    Document   : guardarclientes
    Created on : 22-09-2013, 10:18:24 PM
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos Cliente</h1>
        <%
            
            String Rutin="", Nombrein="",Apellidopin="",Apellidomin="",Emailin="",Telefonoin="";
            
            if(request.getParameter("rut")!=null){
                    Rutin=request.getParameter("rut");
                            }
            if(request.getParameter("nombre")!=null){
                    Nombrein=request.getParameter("nombre");
                            }
            if(request.getParameter("apellidop")!=null){
                    Apellidopin=request.getParameter("apellidop");
                            }
            if(request.getParameter("apellidom")!=null){
                    Apellidomin=request.getParameter("apellidom");
                            }
            if(request.getParameter("telefono")!=null){
                    Telefonoin=request.getParameter("telefono");
                            }
            if(request.getParameter("email")!=null){
                    Emailin=request.getParameter("email");
                            }
        %>
        <jsp:useBean id="Cliente1" class="models.entity.Cliente" scope="session"/>
        <jsp:setProperty name="Cliente1" property="rut" value="<%=Rutin%>"/>
        <jsp:setProperty name="Cliente1" property="nombre" value="<%=Nombrein%>"/>
        <jsp:setProperty name="Cliente1" property="paterno" value="<%=Apellidopin%>"/>
        <jsp:setProperty name="Cliente1" property="materno" value="<%=Apellidomin%>"/>
        <jsp:setProperty name="Cliente1" property="telefono" value="<%=Telefonoin%>"/>
        <jsp:setProperty name="Cliente1" property="email" value="<%=Emailin%>"/>
        
       
        <form action="confirmarcliente.jsp" method="post">    
            <table>
                <tr><td>Rut Cliente</td><td><jsp:getProperty name="Cliente1" property="rut"/></tr>
                <tr><td>Nombre</td><td><jsp:getProperty name="Cliente1" property="nombre"/></tr>
                <tr><td>Apellido Paterno</td><td><jsp:getProperty name="Cliente1" property="paterno"/></tr>
                <tr><td>Apellido Materno</td><td><jsp:getProperty name="Cliente1" property="materno"/></tr>
                <tr><td>Telefono</td><td><jsp:getProperty name="Cliente1" property="telefono"/></tr>
                <tr><td>Email</td><td><jsp:getProperty name="Cliente1" property="email"/></tr>
                <input type="submit" value="Confimar"/>
            </table> 
        </form>
        
    </body>
</html>
