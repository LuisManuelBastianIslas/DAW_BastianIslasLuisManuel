package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private static final String selectSQL = "select * from login? " +
                                            "where ? = ? and ? = ? and estatusLogin? = true";

    public static boolean existAlumno(String user, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean res = false;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            ps.setString(1, "Alumno");
            ps.setString(2, "matriculaAlumno");
            ps.setString(4, "contraseñaLoginAlumno");
            ps.setString(6, "Alumno");

            String control = ps.toString();
            control = control.replaceAll("'", "");  //quita las comillas porque me estorban :)
            ps = conn.prepareStatement(control);

            ps.setString(1, user);
            ps.setString(2, password);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            String exist = null;

            while (rs.next())
                exist = rs.getString("matriculaAlumno");

            if (exist != null)
                res = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return res;
    }
}
