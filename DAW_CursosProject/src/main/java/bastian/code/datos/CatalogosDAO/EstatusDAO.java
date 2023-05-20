package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.TipoJB;

import java.sql.*;
import java.util.ArrayList;

public class EstatusDAO {
    private static final String selectSQL = "select * from estatus?";

    public static ArrayList<EstatusJB> select(String nombreEstatus) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<EstatusJB> estatuss = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            ps.setString(1, nombreEstatus);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEstatus" + nombreEstatus);
                String nombre = rs.getString("nombreEstatus" + nombreEstatus);

                EstatusJB estatus = new EstatusJB(id, nombre);
                estatuss.add(estatus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estatuss;
    }

    public static EstatusJB select(String nombreEstatus, int idEsttaus) {
        String query = selectSQL + " where idEstatus " + nombreEstatus + " = " + idEsttaus;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EstatusJB estatus;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nombreEstatus);
            rs = ps.executeQuery();

            rs.next();  //Solo es 1 row ;]

            int id = rs.getInt("idEstatus" + nombreEstatus);
            String nombre = rs.getString("nombreEstatus" + nombreEstatus);

            estatus = new EstatusJB(id, nombre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estatus;
    }
}
