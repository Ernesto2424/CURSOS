package datos;

import domain.Preferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreferenciaDao {

    private static final String SQL_INSERT = "INSERT INTO preferencias(ID_GENERO, ID_USUARIO) VALUES(?,?)";

    public int INSERT(Preferencia preferencia) {

        Connection cn = null;
        PreparedStatement pst = null;
        int row = 0;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setInt(1, preferencia.getIdGenero());
            pst.setInt(2, preferencia.getIdUsuario());
            row = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }

        return row;
    }

}
