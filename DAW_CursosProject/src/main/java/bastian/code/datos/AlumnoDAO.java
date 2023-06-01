package bastian.code.datos;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.datos.CatalogosDAO.EstatusDAO;
import bastian.code.datos.CatalogosDAO.GeneroDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.CatalogosJB.CarreraJB;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.GeneroJB;
import bastian.code.modelo.ProfesorJB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlumnoDAO {

    private static final String selectSQL = "select * from alumno";

    /**
     * Funciones con el select
     */
    //Llama a "todos" los alumnos
    public static ArrayList<AlumnoJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AlumnoJB> alumnos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String curp = rs.getString("curp");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apleiidoMaterno = rs.getString("apellidoMaterno");
                GeneroJB genero = GeneroDAO.select( rs.getString("idGenero") ); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse( rs.getString("fechaNacimiento") );
                String direccion = rs.getString("direccoin");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select( rs.getInt("idCarrera") );
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno") );
                ProfesorJB profesor = ProfesorDAO.select( rs.getString("idProfesor") );

                AlumnoJB alumno = new AlumnoJB(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email, matriculaAlumno, carrera, anoInscripcion, estatusAlumno, profesor);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return alumnos;
    }

    //Llama a un alumno en especifico
    public static AlumnoJB select(String MatriculaAlumno) {
        String query = selectSQL + " where matriculaALumno = " + "'"+MatriculaAlumno.toUpperCase()+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AlumnoJB alumno = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(ps.toString() + "\nPara eliminar este msg, esya en AlumnoDAO");
            while ( rs.next() ) {
                String curp = rs.getString("curp");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apleiidoMaterno = rs.getString("apellidoMaterno");
                GeneroJB genero = GeneroDAO.select( rs.getString("idGenero") ); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse(rs.getString("fechaNacimiento"));
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select(rs.getInt("idCarrera"));
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno"));
                ProfesorJB profesor = ProfesorDAO.select( rs.getString("idProfesor") );

                alumno = new AlumnoJB(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email, matriculaAlumno, carrera, anoInscripcion, estatusAlumno, profesor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        System.out.println("Se ha enviado la matricula " + alumno.getMatriculaAlumno() + "\nPara eliminar este msg, esya en AlumnoDAO");
        return alumno;
    }

    //Llama a todos los alumnos de un "curso" en especifico
    //Llama a todos los alumnos de una generacion y carrera en especifico

    //Llama a todos los alumnos tutorados de un profesor en comun
    public static ArrayList<AlumnoJB> selectTutorados(String IdProfesor) {
        String query =  selectSQL + " where idProfesor = " + "'"+IdProfesor+"'" +
                        "order by anoInscripcion desc";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AlumnoJB> alumnos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String curp = rs.getString("curp");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apleiidoMaterno = rs.getString("apellidoMaterno");
                GeneroJB genero = GeneroDAO.select( rs.getString("idGenero") ); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse(rs.getString("fechaNacimiento"));
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select(rs.getInt("idCarrera"));
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno"));
                ProfesorJB profesor = ProfesorDAO.select( rs.getString("idProfesor") );

                AlumnoJB alumno = new AlumnoJB(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email, matriculaAlumno, carrera, anoInscripcion, estatusAlumno, profesor);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return alumnos;
    }

    /**
     * Tratare de ver si me es posible haces sus variantes entre los distintos status...
     */
}
