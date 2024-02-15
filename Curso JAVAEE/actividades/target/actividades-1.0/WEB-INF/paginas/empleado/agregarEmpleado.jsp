<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Empleado</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/servletTareas?accion=crearUsuario" method="POST" class="was-validated">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="nombre">NOMBRE COMPLETO:</label>
                        <input type="text" name="nombre" class="form-control" autocomplete="OFF" required="true" style="text-transform: capitalize">
                    </div>

                    <div class="form-group">
                        <label for="email">EMAIL</label>
                        <input type="email" name="email" class="form-control" required="true">
                    </div>
                        
                    <input type="hidden" id="password" name="password" value="" />
                    
                    <div class="form-group">
                        <label for="area">AREA:</label>
                        <select id="area" class="form-control" name="area">
                            <c:forEach var="area" items="${areas}">
                                <option value="${area.id}">${area.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="departamento">DEPARTAMENTO:</label>
                        <select id="departamento" class="form-control" name="departamento" >
                            <c:forEach var="departamento" items="${departamentos}">
                                <option value="${departamento.id}">${departamento.nombre}</option>
                                
                            </c:forEach>
                        </select>
                        
                    </div>
                        
                    <input type="hidden" id="usuario" name="tipoUsuario" value="3" />
                    

                <div class="modal-footer">
                    <button class="btn-primary" type="submit" style="border-radius: 4px">Guardar</button>
                    <button class="btn-primary" type="reset" style="border-radius: 4px">Limpiar Campos</button>
                </div>
            </form>

        </div>

    </div>
</div>