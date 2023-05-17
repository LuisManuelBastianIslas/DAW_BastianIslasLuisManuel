package bastian.code.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class AlumnoJB extends persona implements Serializable {

    private String matriculaAlumno;
    private int idCarrera;
    private String nombreCarrera;
    private int anoInscripcion;
    private int isEstatusAlumno;
    private String nombreEstatusAlumno;

    public AlumnoJB() {}

    public AlumnoJB(String matriculaAlumno, int idCarrera, String nombreCarrera, int anoInscripcion, int isEstatusAlumno, String nombreEstatusAlumno) {
        this.matriculaAlumno = matriculaAlumno;
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.anoInscripcion = anoInscripcion;
        this.isEstatusAlumno = isEstatusAlumno;
        this.nombreEstatusAlumno = nombreEstatusAlumno;
    }

    public AlumnoJB(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String genero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, String matriculaAlumno, int idCarrera, String nombreCarrera, int anoInscripcion, int isEstatusAlumno, String nombreEstatusAlumno) {
        super(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email);
        this.matriculaAlumno = matriculaAlumno;
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.anoInscripcion = anoInscripcion;
        this.isEstatusAlumno = isEstatusAlumno;
        this.nombreEstatusAlumno = nombreEstatusAlumno;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAnoInscripcion() {
        return anoInscripcion;
    }

    public void setAnoInscripcion(int anoInscripcion) {
        this.anoInscripcion = anoInscripcion;
    }

    public int getIsEstatusAlumno() {
        return isEstatusAlumno;
    }

    public void setIsEstatusAlumno(int isEstatusAlumno) {
        this.isEstatusAlumno = isEstatusAlumno;
    }

    public String getNombreEstatusAlumno() {
        return nombreEstatusAlumno;
    }

    public void setNombreEstatusAlumno(String nombreEstatusAlumno) {
        this.nombreEstatusAlumno = nombreEstatusAlumno;
    }
}
