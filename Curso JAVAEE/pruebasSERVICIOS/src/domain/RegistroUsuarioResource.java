/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package domain;


import datos.UsuarioDao;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Personal
 */
@Path("registroUsuario")
public class RegistroUsuarioResource {

    @Context
    private UriInfo context;
    private static String idUsuario = "";
    private static List<Usuario> usuarios = new ArrayList<>();

    /**
     * Creates a new instance of RegistroUsuarioResource
     */
    public RegistroUsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of domain.RegistroUsuarioResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() throws ClassNotFoundException {
        
        List<Usuario> listaRegistrada;
        listaRegistrada = new UsuarioDao().listar();
        
        return listaRegistrada.toString();


        
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response crearCliente(@FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido,
            @FormParam("edad") int edad,
            @FormParam("genero") String genero,
            @FormParam("correo") String correo,
            @FormParam("password") String password,
            @FormParam("estado") int estado) throws ClassNotFoundException {

        Usuario usuario = new Usuario(nombre, apellido, edad, genero, correo, password);
        
        
        usuarios.add(usuario);
        int row = new UsuarioDao().INSERT(usuario);
        
        
        
        
        

        System.out.println("Usuario creado " + usuario.toString());
        return Response.created(URI.create("/registroUsuario/" + usuario.getNombre())).build();
       

    }

    /**
     * PUT method for updating or creating an instance of
     * RegistroUsuarioResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
