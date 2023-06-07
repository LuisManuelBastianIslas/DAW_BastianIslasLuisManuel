package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.AlumnoDAO;
import bastian.code.datos.AsignaturaDAO;
import bastian.code.datos.CatalogosDAO.EstatusDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.RelacionesDAO.CursoSalonDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.PeriodoJB;

import java.io.Serializable;
import java.util.ArrayList;

public class CursoAlumnoJB extends curso implements Serializable {

    private static final long serialVersionUID = 1L;
    private String matriculaAlumno;
    private int idEstatusCursoAlumno;
    private int calificacion;
    // No se si me convenga hacer un ArrayList de el horario
    private ArrayList<CursoSalonJB> cursoSalon;

    public CursoAlumnoJB() {}

    public CursoAlumnoJB(String matriculaAlumno, int idPeriodo, int nrc, int idEstatusCursoAlumno, int calificacion) {
        super(idPeriodo, nrc);
        this.matriculaAlumno = matriculaAlumno;
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

     private void initializeCursoSalon() {
        cursoSalon = createCursoSalon();
    }

    public ArrayList<CursoSalonJB> getCursoSalon () {
        // Si es null, lo crea. Si ya existe, solo lo devuelve
        if (cursoSalon == null)
            initializeCursoSalon();

        return cursoSalon;
    }

    public String getSalones() {
        // Comprueba si ya esxiste cursoSalon, sino lo inicializa
        if (cursoSalon == null)
            initializeCursoSalon();

        String salones = "";

        for (CursoSalonJB curso : cursoSalon)
            if ( !salones.contains( curso.getSalon().getIdSalon() ) )
                salones += " " + curso.getIdSalon() + ",";

        return salones.substring(0, salones.length()-1);
    }
}
