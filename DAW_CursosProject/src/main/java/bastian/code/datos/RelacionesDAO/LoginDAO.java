package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.Conexion;

import java.sql.*;

public class LoginDAO {

    private static final String selectSQL = "select * from loginREP " +
                                            "where REP = ? and REP = ? and estatusLoginREP = 1";

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

    public static boolean existProfesor(String user, String password) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean res = false;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Profesor");
            query = query.replaceFirst("REP", "usuarioProfesor");
            query = query.replaceFirst("REP", "contraseñaLoginProfesor");
            query = query.replaceFirst("REP", "Profesor");

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next())
                res = rs.getString("usuarioProfesor") != null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return res;
    }

    public static boolean existAdministrador(String user, String password) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean res = false;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Administrador");
            query = query.replaceFirst("REP", "usuarioAdministrador");
            query = query.replaceFirst("REP", "contraseñaLoginAdministrador");
            query = query.replaceFirst("REP", "Administrador");

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next())
                res = rs.getString("usuarioAdministrador") != null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return res;
    }
}
