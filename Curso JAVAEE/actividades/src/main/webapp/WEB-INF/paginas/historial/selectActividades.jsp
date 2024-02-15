
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div class="container">
    <div class = "mb-3">
        <form action="${pageContext.request.contextPath}/servletTareas?accion=Shistorial">
        <label for="actividad">ACTIVIDAD:</label>
        <select id="actividad" class="form-control" name="actividad">
            <option value="0">---SELECCIONAR---</option>
            <c:forEach var="tarea" items="${tareas}">
                <option value="${tarea.id}">${tarea.nombre}</option>
            </c:forEach>
        </select>
        </div>
        <div class="mb-3">
        <div class="col-md-3 ">
        <input type="submit" value="Mostrar Historial" class="btn btn-primary btn-block" >
        </div>
        </div>
            
        </form><!-- comment -->

    
</div>