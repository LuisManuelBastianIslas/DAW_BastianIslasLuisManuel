package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.AsignaturaDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.RelacionesDAO.CursoDAO;
import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.CatalogosJB.PeriodoJB;

import java.io.Serializable;

public class curso implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idPeriodo;
    private int nrc;

    public curso() {}

    public curso(int idPeriodo, int nrc) {
        this.idPeriodo = idPeriodo;
        this.nrc = nrc;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public PeriodoJB getPeriodo(){
        return PeriodoDAO.select(this.idPeriodo);
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public AsignaturaJB getAsignatura() {
        return AsignaturaDAO.select(this.nrc);
    }

    public CursoJB getCurso() {
        return CursoDAO.select(this.nrc);
    }
}
