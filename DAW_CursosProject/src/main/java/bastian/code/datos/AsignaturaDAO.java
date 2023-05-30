package bastian.code.datos;

import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.MateriaJB;
import bastian.code.modelo.ProfesorJB;

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
                String curpPorfesor = rs.getString("curpProfesor");
                int cupoMinimo = rs.getInt("cupoMinimo");
                int cupoMaximo = rs.getInt("cupoMaximo");
                MateriaJB materia = MateriaDAO.select(idMateria);
                ProfesorJB profesor = new ProfesorJB();   //Aun en proceso  ////No se te olvide!!!

                AsignaturaJB asignatura = new AsignaturaJB(nrc, materia, profesor, cupoMinimo, cupoMaximo);
                asignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return asignaturas;
    }

    //Una asignatura en especifico

    //Lista las asignaturas que impate un Profesor en especifico
    //Lista las asignaturas que son de una materia en especifico
    //Lista las asignaturas que son de una carrera en especifico
    //Lista las asignaturas que son de una carrera en especifico y para un semestre en especifico

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
