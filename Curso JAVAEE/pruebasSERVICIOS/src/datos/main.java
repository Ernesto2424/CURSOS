package datos;

import domain.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static final String SQL_SELECT = "SELECT * FROM generos";

    public static List<Genero> generos() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Genero> generos = new ArrayList();
        Genero genero = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                genero = new Genero(id, nombre);
                generos.add(genero);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return generos;
    }
    
    
    public static void main(String[] args) {
       
        System.out.println("args");
        
    }
    
    
    

}
