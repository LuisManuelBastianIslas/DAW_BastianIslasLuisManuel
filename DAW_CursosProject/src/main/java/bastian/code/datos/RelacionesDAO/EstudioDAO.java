package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.CatalogosDAO.TipoDAO;
import bastian.code.datos.Conexion;
import bastian.code.modelo.RelacionesJB.EstudioJB;
import bastian.code.modelo.CatalogosJB.TipoJB;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

public class EstudioDAO {

    private static final String selectSQL = "select * from estudio";

    // Se obtiene un ArrayList<> de los estudios de una persona. Ya ordenado ;)
    public static ArrayList<EstudioJB> select(String curp) {
        String query =  selectSQL + " where curp = " + "'"+curp+"' " +
                        "order by anoGraduacion desc";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<EstudioJB> estudios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                String universidad = rs.getString("universidad");
                String titulo = rs.getString("titulo");
                String cedula = rs.getString("cedula");
                Year anoGraduacion = Year.of( rs.getInt("anoGraduacion") );
                TipoJB tipoEstudio = TipoDAO.select("Estudio", rs.getInt("idTipoEstudio"));

                EstudioJB estudio = new EstudioJB(universidad, titulo, cedula, anoGraduacion, tipoEstudio);
                estudios.add(estudio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return estudios;
    }
}
