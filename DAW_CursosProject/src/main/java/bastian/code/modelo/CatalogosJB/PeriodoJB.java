package bastian.code.modelo.CatalogosJB;

import java.io.Serializable;

public class PeriodoJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idPeriodo;
    private int mesPeriodo;
    private String descripcionPeriodo;

    public PeriodoJB () {}

    public PeriodoJB(int idPeriodo, int mesPeriodo, String descripcionPeriodo) {
        this.idPeriodo = idPeriodo;
        this.mesPeriodo = mesPeriodo;
        this.descripcionPeriodo = descripcionPeriodo;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getMesPeriodo() {
        return mesPeriodo;
    }

    public void setMesPeriodo(int mesPeriodo) {
        this.mesPeriodo = mesPeriodo;
    }

    public String getDescripcionPeriodo() {
        return descripcionPeriodo;
    }

    public void setDescripcionPeriodo(String descripcionPeriodo) {
        this.descripcionPeriodo = descripcionPeriodo;
    }

    public int getAno() { return idPeriodo / 10; }

    public int getPeriodo() {
        return idPeriodo % getAno();
    }

    public int getNextIdPeriodo() {
        int anoActual = getAno();
        int periodoActual = getPeriodo();

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

        return Integer.parseInt(nextIdPeriodo);
    }
}
