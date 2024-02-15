/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.asociaciones.jpa;

import java.util.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.*;
import org.apache.logging.log4j.*;


/**
 *
 * @author ernes
 */
public class ClienteAsocioanes {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        em.close();
        
        for (Persona persona : personas) {
            log.debug("persona: "+persona);
            
            for (Usuario user : persona.getUsuarioList()) {
                log.debug("usuarios: "+user);
            }
        }
    }
    
}
