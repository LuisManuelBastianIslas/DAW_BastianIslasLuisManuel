package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.Conexion;

import java.sql.*;

public class LoginDAO {

    private static final String selectSQL = "select * from loginREP " +
                                            "where REP = ? and REP = ? and estatusLoginREP = 1";
    private static final String updateSQL = "update loginREP " +
                                            "set estatusLoginREP = 0 " +
                                            "where REP = ?";
    private static final String insertSQL = "insert into loginREP(REP, REP, REP) " +
                                            "values " +
                                            "(?, ?, ?)";

    /**
     * Parte de los Alumnos
     */
    //Comprueba el login
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

    // Bloquea las contraseñas ya existentes
    public static void updateNewPasswordAlumno(String MatriculaAlumno, String Contrasena) {
        // Esto se hace en dos pasos...
            // Primero bloquea las contraseñas ya existentes
            // Para depues añadir la nueva contraseña

        String query = updateSQL;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Alumno");
            query = query.replaceFirst("REP", "Alumno");
            query = query.replaceFirst("REP", "matriculaAlumno");

            ps = conn.prepareStatement(query);
            ps.setString(1, MatriculaAlumno);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);

        // Aqui es donde se inserta la nueva contraseña
        insertNewPasswordAlumno(MatriculaAlumno, Contrasena);
    }

    // Añade una nueva contraseña
    public static void insertNewPasswordAlumno(String MatriculaAlumno, String Contrasena) {
        String query = insertSQL;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Alumno");
            query = query.replaceFirst("REP", "matriculaAlumno");
            query = query.replaceFirst("REP", "contraseñaLoginAlumno");
            query = query.replaceFirst("REP", "estatusLoginAlumno");

            ps = conn.prepareStatement(query);
            ps.setString(1, MatriculaAlumno);
            ps.setString(2, Contrasena);
            ps.setInt(3, 1);    // 1 es que es valido
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
    }

    /**
     * Parte de los Profesores
     */
    public static boolean existProfesor(String user, String password) {
        String query = selectSQL;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean res = false;

        try {
            conn = Conexion.getConnection();
            query = query.replaceFirst("REP", "Profesor");
            query = query.replaceFirst("REP", "idProfesor");
            query = query.replaceFirst("REP", "contraseñaLoginProfesor");
            query = query.replaceFirst("REP", "Profesor");

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next())
                res = rs.getString("idProfesor") != null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return res;
    }

    // Bloquea las contraseñas ya existentes

    // Añade una nueva contraseña

    /**
     * Parte de los administradores
     */
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

    // Bloquea las contraseñas ya existentes

    // Añade una nueva contraseña
}
