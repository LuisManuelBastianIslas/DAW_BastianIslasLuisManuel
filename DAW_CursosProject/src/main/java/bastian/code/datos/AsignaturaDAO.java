package bastian.code.datos;

import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.MateriaJB;
import bastian.code.modelo.ProfesorJB;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class AsignaturaDAO {

    private static final String selectSQL = "select * from asignatura";
    private static final String insertSQL = "insert into asignatura(nrc, idMateria, curpProfesor, cupoMinimo, cupoMaximo) values (?, ?, ?, ?, ?)";

    /**
     * PRIMERA PARTE: Funciones con selectSQL
     */
    //Lista todas las aignatras sin discriminacion
    public static ArrayList<AsignaturaJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AsignaturaJB> asignaturas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int nrc = rs.getInt("nrc");
                int idMateria = rs.getInt("idMateria");
                String idProfesor = rs.getString("idProfesor");
                int cupoMinimo = rs.getInt("cupoMinimo");
                int cupoMaximo = rs.getInt("cupoMaximo");

                AsignaturaJB asignatura = new AsignaturaJB(nrc, idMateria, idProfesor, cupoMinimo, cupoMaximo);
                asignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return asignaturas;
    }

    //Una asignatura en especifico
    public static AsignaturaJB select(int NRC) {
        String query = selectSQL + " where nrc = " + NRC;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AsignaturaJB asignatura = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int nrc = rs.getInt("nrc");
                int idMateria = rs.getInt("idMateria");
                String idProfesor = rs.getString("idProfesor");
                int cupoMinimo = rs.getInt("cupoMinimo");
                int cupoMaximo = rs.getInt("cupoMaximo");

                asignatura = new AsignaturaJB(nrc, idMateria, idProfesor, cupoMinimo, cupoMaximo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return asignatura;
    }

    //Lista las asignaturas que impate un Profesor en especifico
    //Lista las asignaturas que son de una materia en especifico
    //Lista las asignaturas que son de una carrera en especifico

    //Lista las asignaturas que son de una carrera en especifico y que aun no se oferta para el siguiente semestre
    public static ArrayList<AsignaturaJB> selectAviable(int IdPeriodo, int IdCarrera, int NextPeriodo) {
        // Creditos del query a W3 y un tipo randon de Microsoft Developer Network ;)
        String query =  selectSQL + " where  cast(nrc as varchar(6)) like '" + IdCarrera + NextPeriodo + "%' and not exists (" +
                        " select curso.nrc from curso" +
                        " where curso.idPeriodo = " + IdPeriodo + " and curso.nrc = asignatura.nrc)";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AsignaturaJB> asignaturas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(ps.toString() + "\nPara eliminar esto, esta en AsignaturaDAO.selectAviable()");
            while (rs.next()) {
                int nrc = rs.getInt("nrc");
                int idMateria = rs.getInt("idMateria");
                String idProfesor = rs.getString("idProfesor");
                int cupoMinimo = rs.getInt("cupoMinimo");
                int cupoMaximo = rs.getInt("cupoMaximo");

                AsignaturaJB asignatura = new AsignaturaJB(nrc, idMateria, idProfesor, cupoMinimo, cupoMaximo);
                asignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return asignaturas;
    }

    //Lista las asignaturas que son de un alumno en especifico en un periodo en especifico


    /**
     * SEGUNDA PARTE: Funciones con insertSQL
     */
    public static void insert(AsignaturaJB asignatura) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertSQL);

            ps.setInt(1, asignatura.getNrc());
            ps.setInt(2, asignatura.getIdMateria());
            ps.setString(3, asignatura.getIdProfesor());
            ps.setInt(4, asignatura.getCupoMinimo());
            ps.setInt(5, asignatura.getCupoMaximo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
    }
}
