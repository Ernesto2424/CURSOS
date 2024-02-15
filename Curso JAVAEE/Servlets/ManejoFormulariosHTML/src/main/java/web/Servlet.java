
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musicaFav[] = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado del servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>parametros procesados por el servlet</h1>");
        out.println("<table border = '1' >");
        
        out.println("<tr>");
        out.println("<td> Usuario: </td>");
        out.println("<td>");
        out.println(usuario);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td> Contraseña: </td>");
        out.println("<td>");
        out.println(password);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td> Tecnologias de Internet: </td>");
        out.println("<td>");
        for (String tecnologia : tecnologias) {
            out.println(tecnologia + "<br/>");
        }
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td> Genero: </td>");
        out.println("<td>");
        out.println(genero);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td> Ocupación: </td>");
        out.println("<td>");
        out.println(ocupacion);
        out.println("</td>");
        out.println("</tr>");
        
        
         out.println("<tr>");
        out.println("<td> Musica Favorita: </td>");
        out.println("<td>");
        if(musicaFav!=null){
        for (String music : musicaFav) {
            out.println(music + "<br/>");
        }
        }else{
            out.println("**musica favorita no seleccionada**");
        }
        
        out.println("</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td> Comentarios: </td>");
        out.println("<td>");
        if(!comentario.equals("Escribir un texto")){
        out.println(comentario);
        }else{
            out.println("**Sin comentarios**");
        }
        out.println("</td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
       // out.close();
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}
