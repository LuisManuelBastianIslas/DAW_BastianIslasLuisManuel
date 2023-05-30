package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.modelo.CatalogosJB.GeneroJB;

import java.sql.*;
import java.util.ArrayList;

public class GeneroDAO {

    private static final String selectSQL = "Select * from genero";

    public static ArrayList<GeneroJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<GeneroJB> generos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String idGenero = rs.getString("idGenero");
                String nombreGenero = rs.getString("nombreGenero");

                GeneroJB genero = new GeneroJB(idGenero, nombreGenero);
                generos.add(genero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return generos;
    }

    public static GeneroJB select(String IdGenero) {
        String query = selectSQL + " where idGenero = " + "'"+IdGenero+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        GeneroJB genero = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String idGenero = rs.getString("idGenero");
                String nombreGenero = rs.getString("nombreGenero");

                genero = new GeneroJB(idGenero, nombreGenero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return genero;
    }
}
