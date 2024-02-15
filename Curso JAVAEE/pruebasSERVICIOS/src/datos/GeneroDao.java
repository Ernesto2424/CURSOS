package datos;

import domain.Genero;
import domain.Preferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneroDao {

    private static final String SQL_SELECT = "SELECT * FROM generos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM preferencias WHERE ID_USUARIO = ?";
    private static final String SQL_SELECT_BY_ID_GENERO = "SELECT * FROM generos WHERE ID = ?";

    public List<Genero> listar() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Genero genero = null;
        List<Genero> generos = new ArrayList<>();

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
    
    
    public Genero listarPorId(int idGenero) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Genero genero = null;
       

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_ID_GENERO);
            pst.setInt(1, idGenero);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                genero = new Genero(id, nombre);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return genero;

    }
    
    public List<Preferencia> obtenerGenerosFavoritos(int idUsuario){
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Preferencia preferencia = null;
        List<Preferencia> generosFavoritos = new ArrayList<>();
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                int idGenero = rs.getInt("ID_GENERO");
                String nombre = this.listarPorId(idGenero).getNombre();
                preferencia = new Preferencia(nombre);
                generosFavoritos.add(preferencia);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return generosFavoritos;
        
    }

}
