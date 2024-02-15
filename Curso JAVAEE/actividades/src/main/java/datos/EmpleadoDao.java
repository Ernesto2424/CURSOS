package datos;

import dominio.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase puede obtener informacion referente a los empleados asi como
 * tambien el insertar un nuevo empleado en la base de datos
 *
 * @author Personal
 */
public class EmpleadoDao {

    private static final String SQL_SELECT = "SELECT * FROM empleado";

    private static final String SQL_LOGIN = "SELECT * FROM empleado WHERE CORREO = ? AND PASSWORD = ?";

    private static final String SQL_EMPLEADO_BY_ID = "SELECT * FROM empleado WHERE ID = ?";

    private static final String SQL_INSERT = "INSERT INTO empleado(NOMBRE, CORREO, PASSWORD, ID_AREA, ID_DEPARTAMENTO, ID_TIPO_USUARIO) VALUES(?, ?, ?, ?, ?, ?)";

    /**
     *
     * @return. nos va a regresar una lista de los empleados que se encuentren
     * en la base de datos
     */
    public List<Empleado> listar() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList();
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String email = rs.getString("CORREO");
                String password = rs.getString("PASSWORD");
                int area = rs.getInt("ID_AREA");
                int departamento = rs.getInt("ID_DEPARTAMENTO");
                int tipoUsuario = rs.getInt("ID_TIPO_USUARIO");
                empleado = new Empleado(id, nombre, email, password, area, departamento, tipoUsuario);
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return empleados;

    }

    /**
     *
     * @param email. correspone al email que el usuario proporcionara
     * @param password. corresponde a la contrasela del usuario
     * @return regresa un objeto del tipo empleado
     *
     * Este metodo nos va a permitir obtener un usuario existente buscando
     * mediante el correo y la contraseña, si estos se encuentran en la base de
     * datos se pasa informacion al objeto empleado, sino solo se quedara nulo
     *
     */
    public Empleado obtenerUsuario(String email, String password) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Empleado empleado = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_LOGIN);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            // rs.absolute(1); //nos posicionamos en el primer registro
            rs.next();
            String nombre = rs.getString("NOMBRE");
            String correo = rs.getString("CORREO");
            empleado = new Empleado(nombre, correo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return empleado;

    }

    /**
     * Este metodo nos va a permitir insertar un nuevo empleado a la base de
     * datos
     *
     * @param empleado. de este parametro vamos obtener informacion del empleado
     *
     * @return regresa el numero de registros modificados
     */
    public int INSERT(Empleado empleado) {

        Connection cn = null;
        PreparedStatement pst = null;
        int rows = 0;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getCorreo());
            pst.setString(3, empleado.getPassword());
            pst.setInt(4, empleado.getIdArea());
            pst.setInt(5, empleado.getIdDepartamento());
            pst.setInt(6, empleado.getIdTipoUsuario());
            rows = pst.executeUpdate(); //devuelve el numero de registros actualizados

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return rows;

    }
    
   

}
