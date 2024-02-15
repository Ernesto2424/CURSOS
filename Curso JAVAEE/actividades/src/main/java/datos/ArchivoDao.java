package datos;

import dominio.Archivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esta clase tiene como objetivo manipular la información de la clase Archivo,
 * ya sea para obtener o insertar un nuevo archivo
 *
 * @author Personal
 */
public class ArchivoDao {

    /**
     * sentencias SQL para poder insertar y obtener un archivo dependiendo un id
     */
    private static final String SQL_INSERT = "INSERT INTO archivo (URL, ID_TAREA) VALUES(?, ?)";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM archivo WHERE ID_TAREA = ?";

    /**
     *
     * @param archivo. Recibe un archivo para poder obtener mas informacion del
     * mismo y se pueda insertar en la base de datos
     *
     * @return regresa el numero de registros modificados en la BD
     *
     * Este metodo nos va a permitir insertar en la base de datos un nuevo
     * archivo
     */
    public int insertar(Archivo archivo) {

        Connection cn = null;
        PreparedStatement pst = null;
        int row = 0;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, archivo.getDocumento());
            pst.setInt(2, archivo.getIdActividad());
            row = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return row;

    }

}
