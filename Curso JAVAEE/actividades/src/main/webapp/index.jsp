
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope['empleado']!=null}">
    <% response.sendRedirect("dashBoard.jsp");%>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/9c67a9a5ec.js" crossorigin="anonymous"></script>
        
        <title>JSP Page</title>
    </head>
    <body>


        <div class="container mt-5">
            <div class="row">   
                <div class="col-sm">
        
        <form action="${pageContext.request.contextPath}/servlet" method="post">

            <div class="form-group">
                <div class="mb-3 row">
                    <label for="correo" class="col-sm-2 col-form-label">Email:</label>
                    <div class="col-sm-10">
                        <input type="email"  class="form-control" id="correo" name="correo" placeholder="email@example.com">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="password" class="col-sm-2 col-form-label">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" required="true">
                    </div>
                </div>

                    <input type="submit" class="btn btn-primary" value="Ingresar">
            </div>
            
        </form>
        
                </div>
            </div>
        </div>

        <p style="color: #ff0000">${error}</p>



    </body>
</html>
