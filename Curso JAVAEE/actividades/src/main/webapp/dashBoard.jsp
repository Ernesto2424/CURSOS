
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/9c67a9a5ec.js" crossorigin="anonymous"></script>
        <title>DashBoard</title>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
       

        <section id="dash" class="py-4 mb-4 bg-light">

            <div class="container">

                <div class="row">

                    <div class="col-md-2">

                        <div class="card text-center bg-success text-white mb-3">
                            <div class="card-body">
                                <h6>Normal</h6>
                                <h6><i class="fa-solid fa-circle"></i> ${normal} </h6>
                            </div>
                        </div>

                        <div class="card text-center bg-warning text-white mb-3">
                            <div class="card-body">
                                <h6>Alerta</h6>
                                <h6><i class="fa-solid fa-circle"></i> ${alerta} </h6>
                            </div>
                        </div>


                        <div class="card text-center bg-danger text-white mb-3">
                            <div class="card-body">
                                <h6>Critico</h6>
                                <h6><i class="fa-solid fa-circle"></i> ${critico} </h6>
                            </div>
                        </div>

                    </div>

                    <div class="col-md-5">


                        <a href="#" data-toggle="modal" data-target="#agregarEmpleadoModal">
                            <div class="card text-center bg-info text-white mb-3">
                                <div class="card-body">

                                    <h3>Registro Usuarios</h3>
                                    <h4 class="display-4"><i <i class="fa-solid fa-user-plus"></i></h4>
                                </div>
                            </div>
                        </a>

                        <a href="${pageContext.request.contextPath}/servletTareas?accion=historial">
                            <div class="card text-center bg-warning text-white mb-3">
                                <div class="card-body">
                                    <h3>Seguimiento Actividades</h3>
                                    <h4 class="display-4"><i class="fa-solid fa-list-check"></i></h4>
                                </div>
                            </div>
                        </a>

                    </div>

                    <div class="col-md-5">

                        <a href="${pageContext.request.contextPath}/servletTareas?accion=actividades">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                    <h3>Listado Actividades</h3>
                                    <h4 class="display-4"> <i class="fa-solid fa-clipboard"></i> </h4>

                                </div>
                            </div>
                        </a>

                            <a href="${pageContext.request.contextPath}/servletTareas?accion=salir">
                        <div class="card text-center bg-danger text-white mb-3">
                            <div class="card-body">
                                <h3>Log Out</h3>
                                <h4 class="display-4"><i class="fa-solid fa-right-from-bracket"></i></h4>
                            </div>
                        </div>
                            </a>

                    </div>


                </div>

            </div>


        </section>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/empleado/agregarEmpleado.jsp"/>


        

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
