/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDao;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ernes
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario listarById(Usuario usuario) {
        return usuarioDao.findByID(usuario);
    }

    @Override
    public void insertar(Usuario usuario) {
        usuarioDao.insert(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
}
