<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="modal fade" id="agregarSeguimientoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Actividad</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/servletTareas?accion=insertarSeguimiento" method="POST" class="was-validated" enctype="multipart/form-data">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="nombre">ACTIVIDAD:</label>
                        <select id="actividad" class="form-control" name="actividad">
                            <c:forEach var="tarea" items="${tareas}">
                                <option value="${tarea.id}">${tarea.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="fechaA">FECHA ACTUAL:</label>
                        <input type="date" name="fechaA" class="form-control" required="true">
                    </div>

                    <div class="form-group">
                        <label for="fechaT">AVANCE(%)</label>
                        <input type="number" name="avance" class="form-control" required="rue">
                    </div>

                    <div class="form-group">
                        <label for="descripcion">DESCRIPCIÓN:</label>
                        <textarea id="descripcion" name="descripcion" rows="5" cols="10" class="form-control" required="true"></textarea>
                    </div>

                    <div class="form-group">
                        
                        <input type="file" name="documento">
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