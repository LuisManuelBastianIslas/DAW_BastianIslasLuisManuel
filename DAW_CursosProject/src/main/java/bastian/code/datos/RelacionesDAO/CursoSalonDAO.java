package bastian.code.datos.RelacionesDAO;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.Conexion;
import bastian.code.modelo.RelacionesJB.CursoSalonJB;

import javax.persistence.Id;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class CursoSalonDAO {

    private static final String selectSQL = "select * from cursoSalon";

    public static ArrayList<CursoSalonJB> select(int NRC) {
        String query = selectSQL + " where nrc = " + NRC + " and idPeriodo = " + PeriodoDAO.getPeriodoActual().getIdPeriodo();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoSalonJB> cursoSalones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                String idSalon = rs.getString("idSalon");
                LocalTime hora = LocalTime.of( rs.getInt("hora"), 00 );
                int intDiaSemana = rs.getInt("diaSemana");

                CursoSalonJB cursoSalon = new CursoSalonJB(idPeriodo, nrc, idSalon, hora, intDiaSemana);
                cursoSalones.add(cursoSalon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cursoSalones;
    }

    public static ArrayList<CursoSalonJB> selectOcuped(int IdPeriodo, int IdDiaSemana) {
        String query = selectSQL + " where idPeriodo = " + IdPeriodo + " and diaSemana = " + IdDiaSemana;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CursoSalonJB> cursosSalon = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int nrc = rs.getInt("nrc");
                String idSalon = rs.getString("idSalon");
                LocalTime hora = LocalTime.of( rs.getInt("hora"), 00 );
                int intDiaSemana = rs.getInt("diaSemana");

                CursoSalonJB cursoSalon = new CursoSalonJB(idPeriodo, nrc, idSalon, hora, intDiaSemana);
                cursosSalon.add(cursoSalon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return cursosSalon;
    }

    public static ArrayList<CursoSalonJB> selectAviable(int IdPeriodo, int IdDiaSemana) {
        ArrayList<CursoSalonJB> horasOcupadas = selectOcuped(IdPeriodo, IdDiaSemana);
        ArrayList<CursoSalonJB> horasDisponibles = new ArrayList<>();

        // El horario de clases es de 7h a 19h (18h - 19h es la ultima clase)
        for (int i = 7; i < 19; i++) {

        }

        return horasDisponibles;
    }
}
