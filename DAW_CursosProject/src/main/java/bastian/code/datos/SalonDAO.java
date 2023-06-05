package bastian.code.datos;

import bastian.code.datos.CatalogosDAO.TipoDAO;
import bastian.code.modelo.CatalogosJB.TipoJB;
import bastian.code.modelo.SalonJB;

import java.sql.*;
import java.util.ArrayList;

public class SalonDAO {

    private static final String selectSQL = "select * from salon";

    /**
     * Funciones de los Select
     * @return
     */
    public static ArrayList<SalonJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<SalonJB> salones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String idSalon = rs.getString("idSalon");
                TipoJB tipoSalon = TipoDAO.select("Salon", rs.getInt("idTipoSalon") );
                String ubicacion = rs.getString("ubicacion");
                int cantidadPupitres = rs.getInt("cantidadPupitres");

                SalonJB salon = new SalonJB(idSalon, tipoSalon, ubicacion, cantidadPupitres);
                salones.add(salon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return salones;
    }

    public static SalonJB select(String IdSalon) {
        String query = selectSQL + " where idSalon = " +"'"+IdSalon+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SalonJB salon = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();

            String idSalon = rs.getString("idSalon");
            TipoJB tipoSalon = TipoDAO.select("Salon", rs.getInt("idTipoSalon") );
            String ubicacion = rs.getString("ubicacion");
            int cantidadPupitres = rs.getInt("cantidadPupitres");

            salon = new SalonJB(idSalon, tipoSalon, ubicacion, cantidadPupitres);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return salon;
    }
}
