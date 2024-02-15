
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div class="modal fade" id="agregarActividadModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Actividad</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/servletTareas?accion=insertar" method="POST" class="was-validated">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="nombre">ACTIVIDAD:</label>
                        <input type="text" name="nombre" class="form-control" autocomplete="OFF" required="true">
                    </div>

                    <div class="form-group">
                        <label for="fechaI">FECHA INICIO:</label>
                        <input type="date" name="fechaI" class="form-control" required="true">
                    </div>

                    <div class="form-group">
                        <label for="fechaT">FECHA LIMITE:</label>
                        <input type="date" name="fechaT" class="form-control" required="rue">
                    </div>

                    <div class="form-group">
                        <label for="prioridad">PRIORIDAD:</label>
                        <select id="prioridad" class="form-control" name="prioridad">
                            <c:forEach var="prioridad" items="${prioridades}">
                                <option value="${prioridad.id}">${prioridad.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="estado">ESTADO:</label>
                        <select id="estado" class="form-control" name="estado">
                            <c:forEach var="state" items="${estados}">
                                <option value="${state.id}">${state.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="empleado">EMPLEADO ASIGNADO:</label>
                        <select id="empleado" class="form-control" name="empleado">
                            <c:forEach var="empleado" items="${empleados}">
                                <option value="${empleado.id}">${empleado.nombre}</option>
                            </c:forEach>

                        </select>

                    </div>

                    <div class="form-group">
                        <label for="descripcion">DESCRIPCIÓN:</label>
                        <textarea id="descripcion" name="descripcion" rows="5" cols="10" class="form-control" required="true"></textarea>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn-primary" type="submit" style="border-radius: 4px">Guardar</button>
                    <button class="btn-primary" type="reset" style="border-radius: 4px">Limpiar Campos</button>
                </div>
            </form>

        </div>

    </div>
</div>