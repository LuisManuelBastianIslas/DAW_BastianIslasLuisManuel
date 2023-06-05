package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.CatalogosDAO.EstatusDAO;
import bastian.code.modelo.CatalogosJB.EstatusJB;

import java.io.Serializable;

public class CursoJB extends curso implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idEstatusCurso;

    public CursoJB() {}

    public CursoJB(int idPeriodo, int nrc, int idEstatusCurso) {
        super(idPeriodo, nrc);
        this.idEstatusCurso = idEstatusCurso;
    }

    public int getIdEstatusCurso() {
        return idEstatusCurso;
    }

    public void setIdEstatusCurso(int idEstatusCurso) {
        this.idEstatusCurso = idEstatusCurso;
    }

    public EstatusJB getEstatusCurso() {
        return EstatusDAO.select("EstatusCurso", this.idEstatusCurso);
    }
}
