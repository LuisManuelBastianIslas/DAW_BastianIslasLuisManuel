package bastian.code.datos.CatalogosDAO;

import bastian.code.datos.Conexion;
import bastian.code.modelo.CatalogosJB.PeriodoJB;

import java.sql.*;
import java.util.ArrayList;

public class PeriodoDAO {

    // SQLs para la tabla periodo
    private static final String selectSQL = "select * from periodo";
    private static final String insertSQL = "insert into periodo(idPeriodo, mesPeriodo, descripcionPeriodo) " +
                                            "values " +
                                            "(?, ?, ?)";

    // SQL para la tabla periodoActual
    private static final String selectPActualSQL = "select * from periodoActual";
    private static final String updatePActualSQL = "update periodoActual " +
                                            "set periodoActual = ?";

    /**
     * Funciones del Select
     */
    public static ArrayList<PeriodoJB> select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<PeriodoJB> periodos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int mesPeriodo = rs.getInt("mesPeriodo");
                String descripcionPeriodo = rs.getString("descripcionPeriodo");

                PeriodoJB periodo = new PeriodoJB(idPeriodo, mesPeriodo, descripcionPeriodo);
                periodos.add(periodo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return periodos;
    }

    public static PeriodoJB select(int IdPeriodo) {
        String query = selectSQL + " where idPeriodo = " + "'"+IdPeriodo+"'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PeriodoJB periodo = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int mesPeriodo = rs.getInt("mesPeriodo");
                String descripcionPeriodo = rs.getString("descripcionPeriodo");

                periodo = new PeriodoJB(idPeriodo, mesPeriodo, descripcionPeriodo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return periodo;
    }

    public static PeriodoJB selectLast() {
        String query = selectSQL + " order by idPeriodo desc limit 1";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PeriodoJB periodo = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPeriodo = rs.getInt("idPeriodo");
                int mesPeriodo = rs.getInt("mesPeriodo");
                String descripcionPeriodo = rs.getString("descripcionPeriodo");

                periodo = new PeriodoJB(idPeriodo, mesPeriodo, descripcionPeriodo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return periodo;
    }

    /**
     * Funciones del insert
     */
    public static void insert() {
        PeriodoJB lastPeriodo = PeriodoDAO.selectLast();
        int ano = lastPeriodo.getAno();
        int periodo = lastPeriodo.getPeriodo();

        int mes = 0;
        String descripcion = "";

        switch (periodo) {
            case 1:
                periodo = 2;
                descripcion = "Ago - Ene " + ano;
                mes = 8;
                break;
            case 2:
                ano++;
                periodo = 1;
                descripcion = "Feb - Jul " + ano;
                mes = 2;
                break;
            default:
                //No deberia haber un default :)
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertSQL);
            ps.setInt(1, Integer.parseInt("" + ano + periodo));
            ps.setInt(2, mes);
            ps.setString(3, descripcion);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
    }

    /**
     * Funciones adicionales
     */
    public static PeriodoJB getPeriodoActual() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PeriodoJB periodoActual = null;   //igual no deberia de haber problema con esto

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPActualSQL);
            rs = ps.executeQuery();

            while (rs.next())
                periodoActual = PeriodoDAO.select( rs.getInt("periodoActual") );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(conn);

        return periodoActual;
    }

    public static PeriodoJB getNextPeriodo() {
        int anoActual = getPeriodoActual().getAno();
        int periodoActual = getPeriodoActual().getPeriodo();

        // Calcula el siguiente idPeriodo
        switch (periodoActual) {
            case 1:
                periodoActual = 2;
                break;
            case 2:
                periodoActual = 1;
                anoActual++;
                break;
            default:
        }

        String nextIdPeriodo = anoActual + "" + periodoActual;

        return select( Integer.parseInt(nextIdPeriodo) );
    }

    public static void setPeriodoActual(int periodoActual) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePActualSQL);
            ps.setInt(1, periodoActual);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
    }
}
