
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">

    <div class="container">
        <div class="row">
            <div class="col-md-11">
                <div>
                    <div class="card">
                        <div class="card-header">
                            <h4>Listado de Actividades</h4>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>ACTIVIDAD(NOMBRE)</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA LIMITE</th>
                                        <th>RESPONSABLE</th>
                                        <th>PRIORIDAD</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <!-- iterrar cada elemento de la lista -->
                                    <c:forEach var="tarea" items="${tareas}">
                                        <tr>
                                            <td>${tarea.nombre}</td>
                                            <td> ${tarea.fechaI} </td>
                                            <td> ${tarea.fechaT} </td>
                                            <td>${tarea.nombreEmpleado}</td>
                                            <td>${tarea.nombrePrioridad}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/tareas/agregarTarea.jsp"/>
