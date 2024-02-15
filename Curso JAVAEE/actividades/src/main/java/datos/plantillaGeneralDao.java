package datos;

import dominio.PlantillaGeneral;
import dominio.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Este clase tiene como objetivo recuperar informacion de diferentes tablas
 *
 * @author Personal
 */
public class plantillaGeneralDao {

    private static final String SQL_PRIORIDADES = "SELECT * FROM prioridad";
    private static final String SQL_ESTADOS = "SELECT * FROM estado";
    private static final String SQL_AREAS = "SELECT * FROM area";
    private static final String SQL_DEPARTAMENTOS = "SELECT * FROM departamento";
    private static final String SQL_TAREA_ESTADOS = "SELECT * FROM tarea WHERE ID_ESTADO = ?";

    /**
     *
     * @return. regresa una lista de prioridades existentes en la base de datos
     */
    public List<PlantillaGeneral> listarPrioridades() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PlantillaGeneral prioridad = null;
        List<PlantillaGeneral> lista = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_PRIORIDADES);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                prioridad = new PlantillaGeneral(id, nombre);
                lista.add(prioridad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(plantillaGeneralDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return lista;

    }

    /**
     *
     * @return. regresa una lista de todos los estados disponibles en la base de
     * datos
     *
     */
    public List<PlantillaGeneral> listarEstados() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PlantillaGeneral estado = null;
        List<PlantillaGeneral> lista = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_ESTADOS);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                estado = new PlantillaGeneral(id, nombre);
                lista.add(estado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(plantillaGeneralDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return lista;

    }

    /**
     *
     * @return regresa una lista de las areas de la empresa
     */
    public List<PlantillaGeneral> listarAreas() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PlantillaGeneral gral = null;
        List<PlantillaGeneral> lista = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_AREAS);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                gral = new PlantillaGeneral(id, nombre);
                lista.add(gral);
            }

        } catch (SQLException ex) {
            Logger.getLogger(plantillaGeneralDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return lista;

    }

    /**
     *
     * @return regresa una lista de los departamentos existentes de la empresa
     */
    public List<PlantillaGeneral> listarDepartamentos() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PlantillaGeneral gral = null;
        List<PlantillaGeneral> lista = new ArrayList();

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_DEPARTAMENTOS);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                gral = new PlantillaGeneral(id, nombre);
                lista.add(gral);
            }

        } catch (SQLException ex) {
            Logger.getLogger(plantillaGeneralDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return lista;

    }
    
    public List<Tarea> listarTareaEstados(int idEstado){
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> lista = new ArrayList();
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_TAREA_ESTADOS);
            pst.setInt(1, idEstado);
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
                lista.add(tarea);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(plantillaGeneralDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return lista;
        
    }
    
    
    
    
    

}
