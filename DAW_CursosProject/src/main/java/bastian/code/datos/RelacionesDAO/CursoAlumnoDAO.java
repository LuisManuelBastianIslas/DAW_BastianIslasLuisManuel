package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.Conexion;
import bastian.code.modelo.RelacionesJB.CursoAlumnoJB;

import java.sql.*;
import java.util.ArrayList;

public class CursoAlumnoDAO {

    private static final String selectSQL = "select * from cursoAlumno";

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
                int NRC = rs.getInt("nrc");
                int idEstatusCursoAlumno = rs.getInt("idEstatusCursoAlumno");
                int calificacion = rs.getInt("calificacion");

                CursoAlumnoJB curso = new CursoAlumnoJB(matriculaAlumno, idPeriodo, NRC, idEstatusCursoAlumno, calificacion);
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
}
