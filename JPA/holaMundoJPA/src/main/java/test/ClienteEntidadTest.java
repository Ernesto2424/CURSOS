/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.persistence.*;
import mx.com.fm.sga.domain.Persona;
import org.apache.logging.log4j.*;



/**
 *
 * @author ernes
 */
public class ClienteEntidadTest {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //inica la transaccion
        tx.begin();
        //insertar nuevo registro a la BD
        Persona persona = new Persona("nombreBD", "apellidoBD", "emailBd", "micel");
        log.debug("objeto a persisistir" + persona);
        
        //persistimos en la bd
        em.persist(persona);
        
        //terminamos la transaccion
        tx.commit();
        
        log.debug("objeto persistido: "+persona);
        em.close();
    }
    
}
