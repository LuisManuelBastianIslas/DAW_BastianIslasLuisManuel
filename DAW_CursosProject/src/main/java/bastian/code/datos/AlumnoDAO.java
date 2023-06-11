package bastian.code.datos;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.datos.CatalogosDAO.EstatusDAO;
import bastian.code.datos.CatalogosDAO.GeneroDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
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
    private static final String insertSQL = "insert into alumno(curp, nombre, apellidomaterno, apellidopaterno, idgenero, fechanacimiento, direccion, telefono, celular, email, matriculaalumno, idcarrera, anoinscripcion, idestatusalumno, idprofesor)" +
                                            " VALUES" +
                                            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                GeneroJB genero = GeneroDAO.select(rs.getString("idGenero")); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse(rs.getString("fechaNacimiento"));
                String direccion = rs.getString("direccoin");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select(rs.getInt("idCarrera"));
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno"));
                ProfesorJB profesor = ProfesorDAO.select(rs.getString("idProfesor"));

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
        String query = selectSQL + " where matriculaALumno = " + "'" + MatriculaAlumno.toUpperCase() + "'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AlumnoJB alumno = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(ps.toString() + "\nPara eliminar este msg, esya en AlumnoDAO");
            while (rs.next()) {
                String curp = rs.getString("curp");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apleiidoMaterno = rs.getString("apellidoMaterno");
                GeneroJB genero = GeneroDAO.select(rs.getString("idGenero")); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse(rs.getString("fechaNacimiento"));
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select(rs.getInt("idCarrera"));
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno"));
                ProfesorJB profesor = ProfesorDAO.select(rs.getString("idProfesor"));

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
        String query = selectSQL + " where idProfesor = " + "'" + IdProfesor + "'" +
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
                GeneroJB genero = GeneroDAO.select(rs.getString("idGenero")); //Ya cambió a objeto :)
                LocalDate fechaNacimiento = LocalDate.parse(rs.getString("fechaNacimiento"));
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String matriculaAlumno = rs.getString("matriculaAlumno");
                CarreraJB carrera = CarreraDAO.select(rs.getInt("idCarrera"));
                int anoInscripcion = rs.getInt("anoInscripcion");
                EstatusJB estatusAlumno = EstatusDAO.select("Alumno", rs.getInt("idEstatusAlumno"));
                ProfesorJB profesor = ProfesorDAO.select(rs.getString("idProfesor"));

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

    /**
     * Funciones se insert
     */
    public static void insert(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String idGenero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, String matriculaAlumno, int idCarrera, int anoInscripcion, int idEstatusAlumno, String idProfesor) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertSQL);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, apellidoPaterno);
            ps.setString(4, apleiidoMaterno);
            ps.setString(5, idGenero);
            ps.setDate(6, Date.valueOf(fechaNacimiento));
            ps.setString(7, direccion);
            ps.setString(8, telefono);
            ps.setString(9, celular);
            ps.setString(10, email);
            ps.setString(11, matriculaAlumno);
            ps.setInt(12, idCarrera);
            ps.setInt(13, anoInscripcion);
            ps.setInt(14, idEstatusAlumno);
            ps.setString(15, idProfesor);
            System.out.println(ps.toString() + "\nPara eliminar esto, esta en AlumnoDAO.insert");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
    }

    /**
     * Funciones que no son tan importantes para tener en static
     */
    // Esta funcion se usará en el JSP con la finalidad de discernir si es posible o no añadir
    // un nuevo alumno para el siguiente periodo
    public boolean AddingIsPosible() {
        // Simplemente compara el ultimo perido registrado en la BD y si el periodo es Feb - Jul
        System.out.println(PeriodoDAO.getPeriodoActual().getPeriodo() + "\nPara eliminar esto, esya en AlumnoDAO.AddingIsPosible()");
        return PeriodoDAO.selectLast().getIdPeriodo() > PeriodoDAO.getPeriodoActual().getIdPeriodo() && PeriodoDAO.getPeriodoActual().getPeriodo() == 1;
        // Si existe un periodo mayor al periodo actual, siginifica que se pueden inscribir alumnos para el siguiente periodo
    }

    // Me da la siguiente matricula para el siguiente semestre
    // Para esto, ya se sabe que esta en el perido Feb - Jul
    public String getNextMatricula() {
        int ano = PeriodoDAO.getPeriodoActual().getAno(); // Variable de referencia

        // Necesito obtener el siguiente id. Es la cantidad de alumnos del periodo + 1
        int nextId = getCantAlumnos( ano ) + 1;

        String anoStr = ano + "";

        return  "B" + anoStr.substring(2) + String.format("%04d", nextId);
    }

    // Obtiene la cantidad de alumnos en general
    public int getCantAlumnos(int AnoInscripcion) {
        String query =  "select count(matriculaAlumno) as cantAlumnos from alumno" +
                        " where anoInscripcion = " + AnoInscripcion;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int  cantAlumnos = 0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                cantAlumnos = rs.getInt("cantAlumnos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cantAlumnos;
    }

    // Obtiene la cantidad del alumnos en una carrera en especifico
    public int getCantAlumnos(int AnoInscripcion, int IdCarrera) {
        String query =  "select count(matriculaAlumno) as cantAlumnos from alumno" +
                " where anoInscripcion = " + AnoInscripcion + " and idCarrera = " + IdCarrera;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int  cantAlumnos = 0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                cantAlumnos = rs.getInt("cantAlumnos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cantAlumnos;
    }
}
