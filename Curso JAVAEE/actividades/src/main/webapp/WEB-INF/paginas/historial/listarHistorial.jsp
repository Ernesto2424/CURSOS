<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="avances">

    <div class="container">
        <div class="row">
            <div class="col-md-11">
                <div>
                    <div class="card">
                        <div class="card-header">
                            <h4>Historial de Actividades</h4>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>FECHA</th>
                                        <th>DESCRIPCION</th>
                                        <th>AVANCE (%)</th>
                                        <th>RESPONSABLE</th>
                                        <th>DOCUMENTO</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <!-- iterrar cada elemento de la lista -->
                                    <c:forEach var="avances" items="${avances}">
                                    <tr>
                                        <td>${avances.fecha}</td>
                                        <td> ${avances.descripcion} </td>
                                        <td> ${avances.avance} </td>
                                        <td>${avances.nombreEmpleado}</td>
                                        
                                        <td> <a href="C:\Users\Personal\Documents\Curso JAVAEE\actividades\src\main\webapp\files\WhatsApp Image 2022-11-05 at 11.21.45 AM (1).jpeg
">ir</a> </td>

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

<jsp:include page="/WEB-INF/paginas/historial/agregarSeguimiento.jsp"/>