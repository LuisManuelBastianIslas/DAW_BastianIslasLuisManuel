package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.modelo.CatalogosJB.TipoJB;

import java.sql.*;
import java.util.ArrayList;

public class TipoDAO {

    private static final String selectSQL = "select * from tipoREP";

    public static ArrayList<TipoJB> select(String nombreTipo) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TipoJB> tipos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", nombreTipo);
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idTipo" + nombreTipo);
                String nombre = rs.getString("nombreTipo" + nombreTipo);

                TipoJB tipo = new TipoJB(id, nombre);
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return tipos;
    }

    public static TipoJB select(String nombreTipo, int idTipo) {
        String query = selectSQL + " where idTipo" + nombreTipo + " = " + "'"+idTipo+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoJB tipo;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", nombreTipo);
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();  //Solo es 1 row ;]

            int id = rs.getInt("idTipo" + nombreTipo);
            String nombre = rs.getString("nombreTipo" + nombreTipo);

            tipo = new TipoJB(id, nombre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return tipo;
    }
}
