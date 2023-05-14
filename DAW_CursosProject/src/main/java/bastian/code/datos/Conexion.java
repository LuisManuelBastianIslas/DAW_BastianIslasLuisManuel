package bastian.code.datos;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class Conexion {

    private static String usuario = "postgres";
    private static String contra = "13032002Mc";
    private static String bd = "dawcursosproject";
    private static String serv = "jdbc:postgresql://localhost:5432/" + bd;
    private static String driver = "org.postgresql.Driver";

    private static BasicDataSource ds;

    public static BasicDataSource getDataSource() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setUrl(serv);
            ds.setUsername(usuario);
            ds.setPassword(contra);
            ds.setInitialSize(50);
            ds.setDriverClassName(driver);
        }
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
