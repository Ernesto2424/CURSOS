/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasservicios;

import clientes.ClientePeliculas;
import datos.GeneroDao;
import domain.Genero;
import domain.Pelicula;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Personal
 */
public class PruebasSERVICIOS {
    
    
    public static List<Pelicula> Recomendacion(String[] generosID) throws ParseException {
        List<Pelicula> peliculasRecomendadas = new ArrayList<>();

        //tomar nombres de los genereros en base a los ID
        List<Genero> favoritos = new ArrayList<>();
        Genero genero = null;

        for (String string : generosID) {
            genero = new GeneroDao().listarPorId(Integer.parseInt(string));
            favoritos.add(genero);
        }

        for (Genero favorito : favoritos) {

            List<Pelicula> pelis = ClientePeliculas.peliculasPorTema(favorito.getNombre());
            for (Pelicula peli : pelis) {
                peliculasRecomendadas.add(peli);
            }

        }
        return peliculasRecomendadas;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        String[] generos = {"1","4","5"};
//        List<Pelicula> recomendadas = new ArrayList<>();
//        recomendadas = PruebasSERVICIOS.Recomendacion(generos);
//        
//        for (Pelicula recomendada : recomendadas) {
//            System.out.println("recomendada = " + recomendada);
//        }
        
            List<Pelicula> recomendadas = new ArrayList<>();
            
            List<String> favoritos = new ArrayList<>();
        Genero genero = null;

        
        
        for (String string : generos) {
            genero = new GeneroDao().listarPorId(Integer.parseInt(string));
            favoritos.add(genero.getNombre());
        }
        
        
         
        
      // List<Pelicula> r1 = ClientePeliculas.peliculasPorTema(favoritos.get(0));
        System.out.println(favoritos.get(0));
        System.out.println("Fantasy");
        
        
        
        
        
        
        
        


        
        
        
        
        
        
        
        }

        
        
    }
    

