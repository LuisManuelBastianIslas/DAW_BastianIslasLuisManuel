package bastian.code.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class IncidenciasJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String matriculaAlumno;
    private String nombreAlumno;
    private int periodo;
    private int nrc;
    private String nombreMateria;
    private LocalDate fecha;
    private String incidencia;

    public IncidenciasJB() {}

    public IncidenciasJB(String matriculaAlumno, String nombreAlumno, int periodo, int nrc, String nombreMateria, LocalDate fecha, String incidencia) {
        this.matriculaAlumno = matriculaAlumno;
        this.nombreAlumno = nombreAlumno;
        this.periodo = periodo;
        this.nrc = nrc;
        this.nombreMateria = nombreMateria;
        this.fecha = fecha;
        this.incidencia = incidencia;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
}
