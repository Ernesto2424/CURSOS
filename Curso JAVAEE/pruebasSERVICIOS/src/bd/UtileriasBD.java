/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Personal
 */
public class UtileriasBD {
    
     static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
     static final String URL = "jdbc:mysql://localhost/recomendacion";
     static final String USER = "root";
     static final String PASS = "010324";
    
    public static void registarGeneros(HashSet lista) throws SQLException, ClassNotFoundException {
        
        Connection conn;
        Statement stmt;
      
         //PASO 2: Registrar el JDBC driver
            Class.forName(JDBC_DRIVER);

            //PASO 3: Abrir una conexion
            System.out.println("Conectandose a la base de datos...");
            conn = (Connection) DriverManager.getConnection(URL, USER, PASS);

            System.out.println("Creando la base de datos...");
            stmt = conn.createStatement();
            
            Iterator iter = lista.iterator();
            int i=1;
            
            while(iter.hasNext()){
                String sql = "INSERT INTO actores VALUES(" + i + ",\"" +iter.next()+"\")";
                stmt.executeUpdate(sql);
               ++i;
            }
            
            stmt.close();
            conn.close();
    }
    
}
