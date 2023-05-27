package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.Conexion;

import java.sql.*;

public class LoginDAO {

    private static final String selectSQL = "select * from loginREP " +
                                            "where REP = ? and REP = ? and estatusLoginREP = true";

    public static boolean existAlumno(String user, String password) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean res = false;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Alumno");
            query = query.replaceFirst("REP", "matriculaAlumno");
            query = query.replaceFirst("REP", "contraseñaLoginAlumno");
            query = query.replaceFirst("REP", "Alumno");

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);
            System.out.println(ps.toString() + "\nPara eliminar este msg, esya en LoginDAO");
            rs = ps.executeQuery();
            String exist = null;

            while (rs.next())
                exist = rs.getString("matriculaAlumno");

            if (exist != null)
                res = true;

            System.out.println("Exist = " + exist + " Res = " + res + "\nPara eliminar este msg, esya en LoginDAO");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return res;
    }
}
