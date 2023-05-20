package bastian.code.datos;

import bastian.code.datos.CatalogosDAO.TipoDAO;
import bastian.code.modelo.CatalogosJB.TipoJB;
import bastian.code.modelo.ProfesorJB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProfesorDAO {

    private static final String selectSQL = "select * from profesor";

    /**
     * Funciones con el select
     */
    //Todos los Profesores
    public static ArrayList<ProfesorJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ProfesorJB> profesores = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String curp = rs.getString("curp");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apleiidoMaterno = rs.getString("apellidoMaterno");
                String genero = rs.getString("genero");
                LocalDate fechaNacimiento = LocalDate.parse( rs.getString("fechaNacimiento") );
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                int idProfesor = rs.getInt("idProfesor");
                TipoJB tipoContrato = TipoDAO.select("Contrato", rs.getInt("idTipoContrato") );

                ProfesorJB profesor = new ProfesorJB(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email, idProfesor, tipoContrato);
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return profesores;
    }

    //Un Profesor en especifico
    public static ProfesorJB select(int IdProfesor) {
        String query = selectSQL + " where idProfesor = " + IdProfesor;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProfesorJB profesor = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();
            String curp = rs.getString("curp");
            String nombre = rs.getString("nombre");
            String apellidoPaterno = rs.getString("apellidoPaterno");
            String apleiidoMaterno = rs.getString("apellidoMaterno");
            String genero = rs.getString("genero");
            LocalDate fechaNacimiento = LocalDate.parse( rs.getString("fechaNacimiento") );
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            String celular = rs.getString("celular");
            String email = rs.getString("email");
            int idProfesor = rs.getInt("idProfesor");
            TipoJB tipoContrato = TipoDAO.select("Contrato", rs.getInt("idTipoContrato") );

            profesor = new ProfesorJB(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email, idProfesor, tipoContrato);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return profesor;
    }

    //Profesores de una materia en especifico
}
