package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Esta clase tiene como objetivo conectar la aplicacion con una base de datos,
 * de igual forma poder desconectar de la base de datos
 *
 * @author Personal
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registroactividades?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    private static BasicDataSource dataSource;

    /**
     * metodo que nos va permitir realizar la conexion a la base de datos
     *
     * @return regresa una conexion, si hay una existente, regresara la conexion
     * actual, sino va a retornar una conexion nueva
     *
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }

        return dataSource;
    }

    /**
     *
     * metodo que hace la llamada para conectarse a la base de datos
     *
     * @return reresa la conexion, ya sea actual o nueva
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement pst) {
        try {
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

}
