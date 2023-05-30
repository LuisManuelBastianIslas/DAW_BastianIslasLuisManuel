package bastian.code.datos;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.datos.CatalogosDAO.TipoDAO;
import bastian.code.modelo.MateriaJB;
import bastian.code.modelo.CatalogosJB.TipoJB;

import java.sql.*;
import java.util.ArrayList;

public class MateriaDAO {

    public static final String selectSQL = "select * from materia"; //Siempre obtendre todo...

    /**
     * Funciones que usan el select
     */
    //Listar todas las materias
    public static ArrayList<MateriaJB> select() {
        ArrayList<MateriaJB> materias = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idmateria = rs.getInt("idMateria");
                String nombreMateria = rs.getString("nombreMateria");
                int creditos = rs.getInt("creditos");
                int horas = rs.getInt("horas");
                int idTipoMateria = rs.getInt("idTipoMateria");
                TipoJB tipoMateria = TipoDAO.select("Materia", idTipoMateria);

                MateriaJB materia = new MateriaJB(idmateria, nombreMateria, creditos, horas, tipoMateria);
                materias.add(materia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return materias;
    }

    //Listas las materias de una carrera en especifico
    public static ArrayList<MateriaJB> select(String idCarrera) {
        String query = "";

        ArrayList<MateriaJB> materias = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idmateria = rs.getInt("idMateria");
                String nombreMateria = rs.getString("nombreMateria");
                int creditos = rs.getInt("creditos");
                int horas = rs.getInt("horas");
                int idTipoMateria = rs.getInt("idTipoMateria");
                TipoJB tipoMateria = TipoDAO.select("Materia", idTipoMateria);

                MateriaJB materia = new MateriaJB(idmateria, nombreMateria, creditos, horas, tipoMateria);
                materias.add(materia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return materias;
    }

    //Listar una materia en especifico
    public static MateriaJB select(int idMateria) {
        String query = selectSQL + " where idMateria = " + idMateria;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MateriaJB materia = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();

            int idmateria = rs.getInt("idMateria");
            String nombreMateria = rs.getString("nombreMateria");
            int creditos = rs.getInt("creditos");
            int horas = rs.getInt("horas");
            int idTipoMateria = rs.getInt("idTipoMateria");
            TipoJB tipoMateria = TipoDAO.select("Materia", idTipoMateria);

            materia = new MateriaJB(idmateria, nombreMateria, creditos, horas, tipoMateria);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return materia;
    }

    // Materias de una carrera en especifico y semestre en especifico
    public static ArrayList<MateriaJB> select(int IdCarrera, int Semestre) {
        String query =  selectSQL +
                        " join materiaCarrera " +
                        "on materia.idMateria = materiaCarrera.idMateria " +
                        "where materiaCarrera.idCarrera = " + IdCarrera + " and materiaCarrera.semestre = " + Semestre;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MateriaJB> materias = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idmateria = rs.getInt("idMateria");
                String nombreMateria = rs.getString("nombreMateria");
                int creditos = rs.getInt("creditos");
                int horas = rs.getInt("horas");
                int idTipoMateria = rs.getInt("idTipoMateria");
                TipoJB tipoMateria = TipoDAO.select("Materia", idTipoMateria);

                MateriaJB materia = new MateriaJB(idmateria, nombreMateria, creditos, horas, tipoMateria);
                materias.add(materia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return materias;
    }

    // Sobrecarga de metodos para obtener la curricula
    public  static ArrayList<ArrayList<MateriaJB>> getCurricula(int IdCarrera) {
        int maxSemestre = CarreraDAO.getCantidadSemestres(IdCarrera);
        ArrayList<ArrayList<MateriaJB>> matrizMaterias = new ArrayList<>();

        for (int i = 1; i <= maxSemestre; i++) {
            //ArrayList<MateriaJB> materias = MateriaDAO.select(IdCarrera, i);
            //matrizMaterias.add(materias);
            matrizMaterias.add( MateriaDAO.select(IdCarrera, i) );
        }

        return matrizMaterias;
    }
}
