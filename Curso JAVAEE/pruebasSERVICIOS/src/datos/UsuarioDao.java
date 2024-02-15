package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_SELECT_BY_CORREO = "SELECT * FROM usuario WHERE CORREO = ? AND CONTRASEÑA = ?";
    private static final String SQL_ISERT = "INSERT INTO usuario(NOMBRE, APELLIDO, EDAD, GENERO, CORREO, CONTRASEÑA, ESTADO) VALUES(?, ?, ?, ?, ?, ?, ?)";

    public int INSERT(Usuario usuario) {

        Connection cn = null;
        PreparedStatement pst = null;
        int row = 0;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_ISERT);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setInt(3, usuario.getEdad());
            pst.setString(4, usuario.getGenero());
            pst.setString(5, usuario.getCorreo());
            pst.setString(6, usuario.getPassword());
            pst.setInt(7, 1);
            row = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return row;
    }

    public List<Usuario> listar() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                int edad = rs.getInt("EDAD");
                String genero = rs.getString("GENERO");
                String correo = rs.getString("CORREO");
                String password = rs.getString("CONTRASEÑA");
                int estado = rs.getInt("ESTADO");
                usuario = new Usuario(id, nombre, apellido, edad, genero, correo, password, estado);
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return usuarios;

    }
    
    public Usuario obtenerDatos(Usuario user) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;
        

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_CORREO);
            pst.setString(1, user.getCorreo());
            pst.setString(2, user.getPassword());
            rs = pst.executeQuery();

                rs.next();
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                int edad = rs.getInt("EDAD");
                String genero = rs.getString("GENERO");
                String correo = rs.getString("CORREO");
                String password = rs.getString("CONTRASEÑA");
                int estado = rs.getInt("ESTADO");
                usuario = new Usuario(id, nombre, apellido, edad, genero, correo, password, estado);
                

            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return usuario;

    }

}
