

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL variables implicitas</title>
    </head>
    <body>
        <h1>EL variables implicitas</h1>
        <br><!-- comment -->
        
        <ul>
            
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath} </li>
            <li>nombre del navegador:${header["User-Agent"]} </li>
            <li> ${cookie.JSESSIONID.value} </li>
            <li>SERVIDOR: ${pageContext.servletContext.serverInfo} </li>
            <li>valor del parametro ${param.nombre}</li>
            <br><!-- comment -->
            <br><!-- comment -->
            <a href="index.jsp">link al inicio</a>
            
        </ul>
        
    </body>
</html>
