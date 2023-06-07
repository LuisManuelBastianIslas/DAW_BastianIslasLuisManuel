package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.Conexion;
import bastian.code.modelo.RelacionesJB.CursoJB;

import java.sql.*;
import java.util.ArrayList;

public class CursoDAO {

    private static final String selectSQL = "select * from curso";

    //Obtiene un curso en especifico en base a un periodo y nrc
    public static CursoJB select(int NRC) {
        String query = selectSQL + " where nrc = " + NRC + " and idPeriodo = " + PeriodoDAO.getPeriodoActual().getIdPeriodo();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CursoJB curso = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                int idEstatusCurso = rs.getInt("idEstatusCurso");

                curso = new CursoJB(idPeriodo, nrc, idEstatusCurso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return curso;
    }

    //Obtiene los cursos en los que esta un profesor en especifico
    public static ArrayList<CursoJB> select(String idProfesor) {
        String query =  selectSQL +
                        " join asignatura" +
                        " on curso.nrc = asignatura.nrc" +
                        " where asignatura.idProfesor = " + "'"+idProfesor+"'" + " and curso.idPeriodo = " + PeriodoDAO.getPeriodoActual().getIdPeriodo();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoJB> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                int idEstatusCurso = rs.getInt("idEstatusCurso");

                CursoJB curso = new CursoJB(idPeriodo, nrc, idEstatusCurso);
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
}
