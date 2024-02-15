/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ernes
 */
public interface UsuarioDao {
    
    public List<Usuario> findAllUsuarios();
    
    public Usuario findByID(Usuario usuario);
    
    public void insert(Usuario usuario);
    
    public void update(Usuario usuario);
    
    public void delete(Usuario usuario);
    
}
