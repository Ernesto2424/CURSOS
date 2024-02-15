/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ernes
 */
public interface UsuarioService {
    
     public List<Usuario> listarUsuarios();
    
    public Usuario listarById(Usuario usuario);
    
    public void insertar(Usuario usuario);
    
    public void actualizar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
   
    
}
