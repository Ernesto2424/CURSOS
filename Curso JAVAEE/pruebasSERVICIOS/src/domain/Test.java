/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import bd.UtileriasBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Personal
 */
public class Test {
    
    public void usuarios() throws SQLException, ClassNotFoundException{
        
       // Conexion.getConnection();
        
    }
    
    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
       
//        List<String> generos = ClienteApi.obtieneGeneros();
//        HashSet<String> ConjuntoGeneros = new HashSet<>(generos);
//        UtileriasBD.registarGeneros(ConjuntoGeneros);
        
        
         List<String> actores = ClienteApi.obtieneActores();
        HashSet<String> ConjuntoActores = new HashSet<>(actores);
        UtileriasBD.registarGeneros(ConjuntoActores);
        
        
        
    }
    
}
