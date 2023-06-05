package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.AlumnoDAO;
import bastian.code.datos.AsignaturaDAO;
import bastian.code.datos.CatalogosDAO.EstatusDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.PeriodoJB;

import java.io.Serializable;

public class CursoAlumnoJB implements Serializable {

    /**
     * Funciona de manera curiosa, en la BD hay muchas relaciones.
     * Pero en el objeto solo alamecnará datos puntuales,
     * omitiendo algunos datos como los foreign keys
     */
    private static final long serialVersionUID = 1L;
    private String matriculaAlumno;
    private int idPeriodo;
    private int NRC;
    private int idEstatusCursoAlumno;
    private int calificacion;
    // No se si me convenga hacer un ArrayList de el horario

    public CursoAlumnoJB() {}

    public CursoAlumnoJB(String matriculaAlumno, int idPeriodo, int NRC, int idEstatusCursoAlumno, int calificacion) {
        this.matriculaAlumno = matriculaAlumno;
        this.idPeriodo = idPeriodo;
        this.NRC = NRC;
        this.idEstatusCursoAlumno = idEstatusCursoAlumno;
        this.calificacion = calificacion;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public AlumnoJB getAlumno() {
        return AlumnoDAO.select(this.matriculaAlumno);
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public PeriodoJB getPeriodo() {
        return PeriodoDAO.select(this.idPeriodo);
    }

    public int getNRC() {
        return NRC;
    }

    public void setNRC(int NRC) {
        this.NRC = NRC;
    }

    public AsignaturaJB getAsignatura() {
        return AsignaturaDAO.select(this.NRC);
    }

    public int getIdEstatusCursoAlumno() {
        return idEstatusCursoAlumno;
    }

    public void setIdEstatusCursoAlumno(int idEstatusCursoAlumno) {
        this.idEstatusCursoAlumno = idEstatusCursoAlumno;
    }

    public EstatusJB getEstatusCursoAlumno() {
        return EstatusDAO.select("CursoAlumno", this.idEstatusCursoAlumno);
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
