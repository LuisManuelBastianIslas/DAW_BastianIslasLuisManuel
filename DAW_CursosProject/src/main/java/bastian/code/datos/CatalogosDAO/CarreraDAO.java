package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.datos.ProfesorDAO;
import bastian.code.modelo.CatalogosJB.CarreraJB;
import bastian.code.modelo.CatalogosJB.TipoJB;
import bastian.code.modelo.ProfesorJB;

import java.sql.*;
import java.util.ArrayList;

/**
 * En general, yo se que es lo mismo que mis clases tipo y estatus,
 * pero para que se entienda y no se me olvide, lo separo
 */
public class CarreraDAO {

    private static final String selectSQL = "select * from carrera";

    /**
     * Funciones para el select
     */
    public static ArrayList<CarreraJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CarreraJB> carreras = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCarrera = rs.getInt("idCarrera");
                String nombreCarrera = rs.getString("nombreCarrera");
                TipoJB tipoCarrera = TipoDAO.select("Carrera", rs.getInt("idTipoCarrera"));
                ProfesorJB profesor = ProfesorDAO.select( rs.getString("idProfesor") );

                CarreraJB carrera = new CarreraJB(idCarrera, nombreCarrera, tipoCarrera, profesor);
                carreras.add(carrera);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return carreras;
    }

    public static CarreraJB select(int IdCarerra) {
        String query = selectSQL + " where idCarrera = " + "'"+IdCarerra+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CarreraJB carrera = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();
            int idCarrera = rs.getInt("idCarrera");
            String nombreCarrera = rs.getString("nombreCarrera");
            TipoJB tipoCarrera = TipoDAO.select("Carrera", rs.getInt("idTipoCarrera"));
            ProfesorJB profesor = ProfesorDAO.select(rs.getString("idProfesor"));

            carrera = new CarreraJB(idCarrera, nombreCarrera, tipoCarrera, profesor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return carrera;
    }

    /**
     * Operaciones que tienen que ver, pero no tanto
     */
    public static int getCantidadSemestres(int IdCarerra) {
        String query =  "select max(semestre) as maxSemestre from materiaCarrera " +
                        "where idCarrera = " +IdCarerra;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int maxSemestre = -1;   //No deberia de pasar este...

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next())
                maxSemestre = rs.getInt("maxSemestre");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return maxSemestre;
    }

    public static int getCantidadCreditos(int IdCarrera) {
        String query =  "select sum(materia.creditos) as sumCreditos from materia " +
                        "join materiaCarrera " +
                        "on materia.idMateria = materiaCarrera.idMateria " +
                        "where materiaCarrera.idCarrera = " + IdCarrera;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cantidadCreditos = -1;  //Nomas para inicializarlo

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next())
                cantidadCreditos = rs.getInt("sumCreditos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cantidadCreditos;
    }
}
