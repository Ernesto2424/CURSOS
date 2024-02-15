package datos;

import dominio.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase tiene como objetivo obtener la informacion correspondiene a las
 * tareas asi como tambien el insertar en la base de datos una nueva tarea
 *
 * @author Personal
 */
public class TareaDao {

    private static final String SQL_SELECT = "SELECT * FROM tarea";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM tarea WHERE ID = ?";
    private static final String SQL_NOMBRE_EMPLEADO = "SELECT * FROM empleado WHERE ID = ?";
    private static final String SQL_NOMBRE_PRIORIDAD = "SELECT * FROM prioridad WHERE ID = ?";
    private static final String SQL_INSERT = "INSERT INTO tarea(NOMBRE, DESCRIPCION, FECHA_INICIO, FECHA_TERMINO, ID_PRIORIDAD, ID_ESTADO, ID_EMPLEADO)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

    /**
     * Este metodo nos va a permitir recuperar el nombre del empleado buscandolo
     * mediante su id
     *
     * @param idEmpleado
     *
     * @return regresa el nombre del empleado
     */
    public static String nombreEmpleado(int idEmpleado) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre = null;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_NOMBRE_EMPLEADO);
            pst.setInt(1, idEmpleado);
            rs = pst.executeQuery();
            rs.next();

            nombre = rs.getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(TareaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return nombre;
    }

    /**
     * Este metodo nos va a permitir recuperar el nombre de la prioridad
     * buscandola mediante su id
     *
     * @param idPrioridad
     *
     * @return regresa el nombre de la prioridad buscada
     */
    public static String nombrePrioridad(int idPrioridad) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre = null;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_NOMBRE_PRIORIDAD);
            pst.setInt(1, idPrioridad);
            rs = pst.executeQuery();
            rs.next();

            nombre = rs.getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(TareaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return nombre;
    }

    /**
     * Este metodo nos va permitir obtener en una lista todas las actividades
     * existentes en nuestra base de datos
     *
     * @return. regresa una lista de tareas
     */
    public List<Tarea> listar() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> tareas = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String fechaI = rs.getString("FECHA_INICIO");
                String fechaT = rs.getString("FECHA_TERMINO");
                int idPrioridad = rs.getInt("ID_PRIORIDAD");
                //meter metodo para recuperar la prioridad
                String nombrePrioridad = TareaDao.nombrePrioridad(idPrioridad);
                int idEmpleado = rs.getInt("ID_EMPLEADO");
                //meter metodo para recuperar nombre empleado
                String nombreEmpleado = TareaDao.nombreEmpleado(idEmpleado);

                tarea = new Tarea(id, nombre, fechaI, fechaT, nombreEmpleado, nombrePrioridad);
                tareas.add(tarea);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return tareas;

    }

    /**
     * Este metodo permite agregar una nueva tarea a la base de datos
     *
     * @return regresa el numero de los registros actualizados
     */
    public int INSERT(Tarea tarea) {

        Connection cn = null;
        PreparedStatement pst = null;
        int rows = 0;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, tarea.getNombre());
            pst.setString(2, tarea.getDescripcion());
            pst.setString(3, tarea.getFechaI());
            pst.setString(4, tarea.getFechaT());
            pst.setInt(5, tarea.getIdPrioridad());
            pst.setInt(6, tarea.getIdEstado());
            pst.setInt(7, tarea.getIdEmpleado());
            rows = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return rows;

    }

    /**
     * Este metodo permite obtener solo una tarea mediante su identificador
     *
     * @param id. recibe el id de la tarea a buscar
     *
     * @return regresa un objeto tarea
     */
    public Tarea listarById(int id) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tarea tarea = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            rs.next();
            int idA = rs.getInt("ID");
            String nombre = rs.getString("NOMBRE");
            String fechaI = rs.getString("FECHA_INICIO");
            String fechaT = rs.getString("FECHA_TERMINO");
            int idPrioridad = rs.getInt("ID_PRIORIDAD");
            //meter metodo para recuperar la prioridad
            String nombrePrioridad = TareaDao.nombrePrioridad(idPrioridad);
            int idEmpleado = rs.getInt("ID_EMPLEADO");
            //meter metodo para recuperar nombre empleado
            String nombreEmpleado = TareaDao.nombreEmpleado(idEmpleado);

            tarea = new Tarea(id, nombre, fechaI, fechaT, idEmpleado, nombreEmpleado, nombrePrioridad);

        } catch (SQLException ex) {
            Logger.getLogger(TareaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return tarea;

    }

}
