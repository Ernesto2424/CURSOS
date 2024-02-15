<%-- 
    Document   : listadoUsuarios
    Created on : 25 nov 2023, 20:22:42
    Author     : ernes
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>

        <ul>
            <c:forEach var="usuario" items="${usuarios}">
                <li>${usuario.persona.nombre} ${usuario.persona.apellido} ${usuario.username} ${usuario.password}</li>
            </c:forEach>
        </ul>


    </body>
</html>
