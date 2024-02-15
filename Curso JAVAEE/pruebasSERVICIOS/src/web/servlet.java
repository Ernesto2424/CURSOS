/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import clientes.ClientePeliculas;
import datos.GeneroDao;
import datos.PreferenciaDao;
import datos.UsuarioDao;
import domain.ClienteApi;
import domain.Genero;
import domain.Pelicula;
import domain.Preferencia;
import domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Personal
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        request.getRequestDispatcher("login.jsp").forward(request, response);

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
                case "insertarGeneros":
                {
                    try {
                        this.insertarGeneros(request, response);
                    } catch (ParseException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                    break;

                default:
                    throw new AssertionError();
            }

        } else {
            this.iniciarSesion(request, response);
        }

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        List<Genero> generos = new GeneroDao().listar();

        //obtenemos los parametros del formulario
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        //creamos el objeto empleado
        Usuario usuario = new Usuario(correo, password);

        //verificamos en la base de datos 
        Usuario usuarioValido = new UsuarioDao().obtenerDatos(usuario);

        String ruta = "login.jsp";
        if (usuarioValido == null) {
            request.setAttribute("error", "Los datos no se encuentran en la base de datos");

        } else {
            sesion.setAttribute("usuario", usuarioValido);
            sesion.setAttribute("generos", generos);
            if (usuarioValido.getEstado() == 1) {
                ruta = "RegistroGeneros.jsp";
            } else {
                ruta = "RegistroUsuario.html";
            }

        }

        request.getRequestDispatcher(ruta).forward(request, response);

    }

    public List<Pelicula> Recomendacion(int idUsuario) throws ParseException {
        List<Pelicula> peliculasRecomendadas = new ArrayList<>();
        //obtener los generos favoritos del usuario en una lista
        List<Preferencia> generosFavoritos = new GeneroDao().obtenerGenerosFavoritos(idUsuario);

        //Consultar la api de peliculas e ir guardando las peliculas en una lista
        
        //primero recorremos los generos favoritos para buscar peliculas en la api por genero (tema)
        for (Preferencia generosFavorito : generosFavoritos) {
            //buscamos las peliculas por temas
            List<Pelicula> peliculas = ClientePeliculas.peliculasPorTema(generosFavorito.getNombreGenero());
            
            //recorrer las peliculas por tema para guardarlas en la lista general de peliculas
            
            for (Pelicula pelicula : peliculas) {
                peliculasRecomendadas.add(pelicula);
            }
            
            
        }
        
        return peliculasRecomendadas;
    }

    private void insertarGeneros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        //obtenemos los parametros del formulario
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String[] generos = request.getParameterValues("genero");

        //creamos los objetos preferencias y subir a la bd
        for (String genero : generos) {
            Preferencia prefe = new Preferencia(Integer.parseInt(genero), id);
            int row = new PreferenciaDao().INSERT(prefe);
        }
        
        List<Pelicula> recomendadas = this.Recomendacion(id);
        request.setAttribute("recomendadas", recomendadas);

        request.getRequestDispatcher("Recomendacion.jsp").forward(request, response);

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
