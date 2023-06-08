package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.Conexion;
import bastian.code.modelo.RelacionesJB.CursoAlumnoJB;

import java.sql.*;
import java.util.ArrayList;

public class CursoAlumnoDAO {

    private static final String selectSQL = "select * from cursoAlumno";
    private static final String updateSQL = "update cursoAlumno";

    // Este manda todas las materias sin importar si fueron eliminadas o cosas asi
    public static ArrayList<CursoAlumnoJB> select(String MatriculaAlumno) {
        String query =  selectSQL + " where matriculaAlumno = " + "'"+MatriculaAlumno+"' and idPeriodo = " + PeriodoDAO.getPeriodoActual().getIdPeriodo();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoAlumnoJB> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(ps.toString() + "\nPara eliminar esto, estas en CursoAlumnoDAO");
            while (rs.next()) {
                String matriculaAlumno = rs.getString("matriculaAlumno");
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                int idEstatusCursoAlumno = rs.getInt("idEstatusCursoAlumno");
                int calificacion = rs.getInt("calificacion");

                CursoAlumnoJB curso = new CursoAlumnoJB(matriculaAlumno, idPeriodo, nrc, idEstatusCursoAlumno, calificacion);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        cursos.forEach(System.out::println);
        System.out.println("Para eliminar esto, esta en CursoAlumnoDAO");

        return cursos;
    }

    public static ArrayList<CursoAlumnoJB> selectAproved(String MatriculaAlumno) {
        String query = selectSQL + " where matriculaAlumno = " +"'"+MatriculaAlumno+"'" + " and diEstatusCursoAlumno = 2";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoAlumnoJB> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String matriculaAlumno = rs.getString("matriculaAlumno");
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                int idEstatusCursoAlumno = rs.getInt("idEstatusCursoAlumno");
                int calificacion = rs.getInt("calificacion");

                CursoAlumnoJB curso = new CursoAlumnoJB(matriculaAlumno, idPeriodo, nrc, idEstatusCursoAlumno, calificacion);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cursos;
    }

    // Obtiene la lista de alumnos de un curso
    public static ArrayList<CursoAlumnoJB> select(int NRC) {
        String query = selectSQL + " where nrc = " + NRC + " and idPeriodo = " + PeriodoDAO.getPeriodoActual().getIdPeriodo() + " and (idEstatusCursoAlumno <> 4 or idEstatusCursoAlumno <> 5)";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoAlumnoJB> alumnos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String matriculaAlumno = rs.getString("matriculaAlumno");
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                int idEstatusCursoAlumno = rs.getInt("idEstatusCursoAlumno");
                int calificacion = rs.getInt("calificacion");

                CursoAlumnoJB cursoAlumno = new CursoAlumnoJB(matriculaAlumno, idPeriodo, nrc, idEstatusCursoAlumno, calificacion);
                alumnos.add(cursoAlumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return alumnos;
    }



    // Le pone la calificacion al alumno
    public static void updateCalificar(String matriculaAlumno, int nrc, int calificacion, int idEstatusCursoAlumno) {
        String update = updateSQL +
                        " set calificacion = " + calificacion + ", idEstatusCursoAlumno = " + idEstatusCursoAlumno +
                        " where matriculaAlumno = " + "'"+matriculaAlumno+"'" + "and nrc = " + nrc;

        Connection conn = null;
        PreparedStatement ps = null;

         try {
             conn = Conexion.getConnection();
             ps = conn.prepareStatement(update);
             ps.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

         Conexion.close(ps);
         Conexion.close(conn);
    }
}
