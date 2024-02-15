package web;

import datos.*;
import dominio.Archivo;
import dominio.Avance;
import dominio.Empleado;
import dominio.PlantillaGeneral;
import dominio.Tarea;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * Esta clase nos va a permitir procesar las peticiones y ademas respondera con
 * una pagina jsp dependiendo el tipó de petición solicitada por el usuario
 *
 * @author Personal
 */
@MultipartConfig
@WebServlet(name = "servletTareas", urlPatterns = {"/servletTareas"})
public class servletTareas extends HttpServlet {

    private String ruta = "C:\\Users\\Personal\\Documents\\Curso JAVAEE\\actividades\\src\\main\\webapp\\files\\";
    private File upload = new File(ruta);
    private String[] extensiones = {".pdf", ".xls", ".doc", ".ppt"};

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "dash":
                    this.DatosDashBoard(request, response);
                    break;

                case "actividades":
                    this.tareas(request, response);
                    break;

                case "historial":
                    this.DatosHistorial(request, response);
                    break;

                case "Shistorial":
                    this.DatosSeguimientoHistorial(request, response);
                    break;

                case "salir":
                    this.salir(request, response);
                    break;

            }
        } else {
            this.DatosSeguimientoHistorial(request, response);
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Este metodo nos va a permitir listar en un select las tareas existentes.
     * Nos servira tanto para el formulario de un nuevo seguimiento y para
     * cargar las actividades y posteriormente seleccionar una y desplegar mas
     * información
     *
     */
    private void DatosHistorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tarea> tareas = new TareaDao().listar();
        request.setAttribute("tareas", tareas);

        request.getRequestDispatcher("HistorialActividades.jsp").forward(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Este metodo nos permitira obtener las tareas exitentes para que
     * posteriormente el usuario seleccione una de estas y se pueda mostrar el
     * historial de avance de cada actividad selecccionada
     *
     */
    private void DatosSeguimientoHistorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tarea> tareas = new TareaDao().listar();
        request.setAttribute("tareas", tareas);
        int id = Integer.parseInt(request.getParameter("actividad"));

        List<Avance> avances = new AvanceDao().listarByIdTarea(id);
        request.setAttribute("avances", avances);

        request.getRequestDispatcher("HistorialActividades.jsp").forward(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * este metodo tiene la funcion de compartir las areas y departamentos para
     * el llenado del formulario del cliente, ya que el dashBoard, tiene como
     * papel el menu principal de la aplicación, pero para el registro de un
     * nuevo usuario se debe compartir la información mencionada con
     * anteriroridad ya que se abre una ventana modal para el registro de
     * usuarios en el mismo dashBoard
     *
     */
    private void DatosDashBoard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        List<Tarea> critico = new plantillaGeneralDao().listarTareaEstados(1);
        List<Tarea> alerta = new plantillaGeneralDao().listarTareaEstados(2);
        List<Tarea> normal = new plantillaGeneralDao().listarTareaEstados(3);
        request.setAttribute("critico", critico.size());
        request.setAttribute("alerta", alerta.size());
        request.setAttribute("normal", normal.size());

        List<PlantillaGeneral> areas = new plantillaGeneralDao().listarAreas();
        List<PlantillaGeneral> departamentos = new plantillaGeneralDao().listarDepartamentos();
        request.setAttribute("areas", areas);
        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("dashBoard.jsp").forward(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * El siguiente metodo va a recuperar la información desde la base de datos
     * acerca de las tareas, para que de este modo al usuario se le pueda
     * desplegar las actividades que han sido creadas, asi como tambien el poder
     * crear una nueva actividad
     */
    private void tareas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleados = new EmpleadoDao().listar();
        List<PlantillaGeneral> prioridades = new plantillaGeneralDao().listarPrioridades();
        List<PlantillaGeneral> estados = new plantillaGeneralDao().listarEstados();
        List<Tarea> tareas = new TareaDao().listar();
        request.setAttribute("tareas", tareas);
        request.setAttribute("prioridades", prioridades);
        request.setAttribute("estados", estados);
        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("tareas.jsp").forward(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * este metodo finalizara las sesiones existentes y nos va a redireccionar
     * al inicio de sesion
     */
    private void salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("index.jsp");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":

                    this.insertarActividad(request, response);

                    break;

                case "crearUsuario":
                    this.insertarEmpleado(request, response);
                    break;

                case "insertarSeguimiento":
                    this.insertarSeguimiento(request, response);
                    break;

                case "in":
                    this.iniciarSesion(request, response);
                    break;

                default:
                    this.iniciarSesion(request, response);
            }
        } else {
            this.iniciarSesion(request, response);
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * este metodo va a recuperar la informacion que proporcione el usuario de
     * una nueva actividad que se desea crear, para que posteriormente se pueda
     * insertar la actividad a la base de datos y posteriormente se actualice la
     * pagina y se pueda mostrar la nueva actividad agregada
     *
     */
    private void insertarActividad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1 recuperar los valores del forulario Agregar actividad
        String nombre = request.getParameter("nombre");
        String fechaI = request.getParameter("fechaI");
        String fechaT = request.getParameter("fechaT");
        int prioridad = Integer.parseInt(request.getParameter("prioridad"));
        int estado = Integer.parseInt(request.getParameter("estado"));
        int empleado = Integer.parseInt(request.getParameter("empleado"));
        String descripcion = request.getParameter("descripcion");

        //creamos el objeto actividad (MODELO)
        Tarea tarea = new Tarea(nombre, descripcion, fechaI, fechaT, prioridad, estado, empleado);

        //insertamos la tarea en la base de datos
        int row = new TareaDao().INSERT(tarea);

        //redirifimos al inicio
        this.tareas(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Este metodo va a permitir obtener la informacion de un empleado nuevo que
     * se desea crear, para que posteriormente sea insertado en la base de datos
     * y en algun momento poder elegir ese nuevo usuario
     *
     */
    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos los parametros del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("email");
        String password = request.getParameter("password");
        int idArea = Integer.parseInt(request.getParameter("area"));
        int idDepartamento = Integer.parseInt(request.getParameter("departamento"));
        int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));

        //creamos el objeto empleado
        Empleado empleado = new Empleado(nombre, correo, password, idArea, idDepartamento, idTipoUsuario);

        //insertamos el empleado a la base de datos
        int row = new EmpleadoDao().INSERT(empleado);

        //redirigimos al Dashboard
        request.getRequestDispatcher("dashBoard.jsp").forward(request, response);

    }

    /**
     *
     * @param parte. se refiere a obtener el archivo que se va a seleccionar
     * como evidencia de algun seguimiento de una actividad
     *
     * @param ruta. hace referencia a la ruta en donde se van a alojar dichos
     * documentos que el usuario cargue en la aplicación
     *
     * @return. devuelve la ruta absoluta en donde seran guardados los archivos
     *
     * el metodo nos va a permitir obtner el archivo subido como evidencia y
     * posteriormente guardar el documento en la ruta absoluta.
     */
    private String saveFile(Part parte, File ruta) {
        String rutaAbsoluta = "";

        try {
            Path path = Paths.get(parte.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = parte.getInputStream();

            if (input != null) {
                File file = new File(ruta, fileName);
                rutaAbsoluta = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (Exception e) {
        }

        return rutaAbsoluta;
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Este metodo nos va a permitir crear un nuevo seguimiento de alguna
     * actividad seleccionada, y posteriormente sera almacenada en la base de
     * datos
     */
    private void insertarSeguimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos los parametros del formulario
        int idActividad = Integer.parseInt(request.getParameter("actividad"));
        String fechaA = request.getParameter("fechaA");
        int pavance = Integer.parseInt(request.getParameter("avance"));
        String descripcion = request.getParameter("descripcion");
        int idEmpleado = new TareaDao().listarById(idActividad).getIdEmpleado();

        Part part = request.getPart("documento");
        String doc = saveFile(part, upload);
        //creamos el objeto

        Archivo archivo = new Archivo(doc, idActividad);
        Avance avance = new Avance(fechaA, pavance, descripcion, idActividad, idEmpleado);

        //insertamos el empleado a la base de datos
        int row = new ArchivoDao().insertar(archivo);
        int r = new AvanceDao().INSERT(avance);
        //redirigimos al Dashboard
        DatosHistorial(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Este metodo va a validar los datos para el acceso a la aplicacion es
     * decir que si los datos son encontrados a la base de datos sera
     * direcciondo a un jsp, pero en caso contrario volveremos a la misma pagina
     * web con un mensaje de error
     *
     */
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos los parametros del formulario
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        //creamos el objeto empleado
        Empleado empleado = new Empleado(correo, password, 3);

        //verificamos en la base de datos 
        Empleado empleadoExistente = new EmpleadoDao().obtenerUsuario(empleado.getCorreo(), empleado.getPassword());

        String direccion = "";
        if (empleadoExistente == null) {
            request.setAttribute("error", "Los datos no se encuentran en la base de datos");
            direccion = "login.jsp";
        } else {
            request.setAttribute("empleado", empleadoExistente);
            direccion = "dashBoard.jsp";
        }

        request.getRequestDispatcher(ruta).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
