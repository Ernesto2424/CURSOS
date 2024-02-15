/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.jpql;

import java.util.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author ernes
 */
public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        /*
        // 1. Consulta de los objetos persona
        
        log.debug("\n1. Consulta de todas las personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
         */

 /*
        //2. consulta de la persona con id = 1
        
        log.debug("\n2. consulta de la persona con id = 3: ");
        jpql = "select p from Persona p where p.idPersona = 3";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(persona);
         */
 /*
        //3. consutla de la persona por nombre
        log.debug("\n3. consulta por nombre Maria");
        jpql = "select p from Persona p where p.nombre = 'Maria' ";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
         */
 /**/
 /*4. consulta de datos individuales, se crea un arreglo(tupla) de tipo
             Object (ya que puede ser de distintos tipos de datos)*/
 /*
        log.debug("\n4. consulta de datos individuales");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Correo from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
         tupla = (Object[]) iter.next();
         String nombre = (String) tupla[0];
         String apellido = (String) tupla[1];
         String email = (String) tupla[2];
         log.debug("Nombre: "+nombre+ " Apellido: "+apellido+ " Correo: "+email);
        }
         */
 /*
        //5.obtiene el objeto persona y el id
        log.debug("5.obtiene el objeto persona y el id");
        jpql = "select p, p.idPersona from Persona p"; 
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("objeto persona" + persona);
            log.debug("objeto id" + idPersona);
            
        }
         */
 /*
        //6.  consulta de todas las personas solo con el id
        jpql = "select new mx.com.gm.sga.domain.Persona( p.idPersona ) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
         */
 /*
         //7. consulta de personas con el id minimo y el maximo
         jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
         iter = em.createQuery(jpql).getResultList().iterator();
         while(iter.hasNext()){
             tupla = (Object[]) iter.next();
             Integer min = (Integer) tupla[0];
             Integer max = (Integer) tupla[1];
             Long cont = (Long) tupla[2];
             log.debug("MIN: "+min+ " MAX: "+max+ " CONT: "+cont);

         
}
         */
 
 
         //8. consulta de personas con nombres distintoa.
         jpql = "select count(distinct p.nombre) from Persona p";
         Long cont = (Long) em.createQuery(jpql).getSingleResult();
         log.debug("numero de personas con nombre distinto: "+cont);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }

}
