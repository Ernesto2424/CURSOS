package datos;

import dominio.Avance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esta clase nos va a permitir inserttar en la base de datos el seguimiento de
 * cada activdad, asi como tambien recuperar los avances de cada una de las
 * actividades que se seleccionen
 *
 * @author Personal
 */
public class AvanceDao {

    private static final String SQL_INSERT = "INSERT INTO avances(FECHA, P_AVANCE, DESCRIPCION, ID_TAREA, ID_ESTADO, ID_EMPLEADO) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_BY_ID_TAREA = "SELECT * FROM avances WHERE ID_TAREA = ?";

    /**
     *
     * @param avance. recibe un onjeto del tipo avance para poder obtener
     * informacion de esta instancia
     *
     * @return regresa el numero de registros actualizados
     *
     * este metodo nos va a permitir insertar un avance de una actividad
     * especifica en la base de datos
     *
     */
    public int INSERT(Avance avance) {

        Connection cn = null;
        PreparedStatement pst = null;
        int row = 0;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, avance.getFecha());
            pst.setInt(2, avance.getAvance());
            pst.setString(3, avance.getDescripcion());
            pst.setInt(4, avance.getIdTarea());
            pst.setInt(5, 1);
            pst.setInt(6, avance.getIdEmpleado());
            row = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AvanceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return row;

    }

    /**
     *
     * @param id. este parametro corrresponde al id tarea
     *
     * @return regresa una lista de avances de una actividad especifica
     *
     * Este metodo nos va a permitir obtener los avances (historial) de cada
     * actividad dependiendo cual sea seleccionada y ser guardados en una lista
     */
    public List<Avance> listarByIdTarea(int id) {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Avance avance = null;
        List<Avance> lista = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_ID_TAREA);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("FECHA");
                int pAvance = rs.getInt("P_AVANCE");
                String descripcion = rs.getString("DESCRIPCION");
                int idEmpleado = rs.getInt("ID_EMPLEADO");
                String empleado = TareaDao.nombreEmpleado(idEmpleado);
                avance = new Avance(fecha, pAvance, descripcion, empleado);
                lista.add(avance);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AvanceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return lista;
    }

}
