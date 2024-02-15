<%-- 
    Document   : login
    Created on : 8 ene 2023, 16:20:03
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="${pageContext.request.contextPath}/servletTareas?accion=in" method="POST">
        
               correo: <input type="email" name="correo" id="correo">
               password: <input type="password" name="password" id="password">
               <input type="submit" value="Button">
        
        </form>
        
    </body>
</html>
