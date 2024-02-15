/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author ernes
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;
    
    
    @Override
    public List<Usuario> findAllUsuarios() {
       return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findByID(Usuario usuario) {
        return  (Usuario) em.createNamedQuery("Usuario.findByIdUsuario").getSingleResult();
    }

    @Override
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        em.remove(usuario);
    }
    
}
