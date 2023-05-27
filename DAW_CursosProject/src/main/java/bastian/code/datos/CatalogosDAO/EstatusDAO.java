package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.TipoJB;

import java.sql.*;
import java.util.ArrayList;

public class EstatusDAO {
    private static final String selectSQL = "select * from estatusREP";

    public static ArrayList<EstatusJB> select(String nombreEstatus) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<EstatusJB> estatuss = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", nombreEstatus);
            ps = conn.prepareStatement(query);
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

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return estatuss;
    }

    public static EstatusJB select(String nombreEstatus, int idEsttaus) {
        String query = selectSQL + " where idEstatus" +nombreEstatus + " = " + "'"+idEsttaus+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EstatusJB estatus = null;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", nombreEstatus);
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(ps.toString() + "\nPara eliminar este msg, esya en EstatusDAO");
            while ( rs.next() ) {
                int id = rs.getInt("idEstatus" + nombreEstatus);
                String nombre = rs.getString("nombreEstatus" + nombreEstatus);

                estatus = new EstatusJB(id, nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return estatus;
    }
}
