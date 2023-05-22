package bastian.code.modelo;

import bastian.code.modelo.CatalogosJB.CarreraJB;
import bastian.code.modelo.CatalogosJB.EstatusJB;

import java.io.Serializable;
import java.time.LocalDate;

public class AlumnoJB extends persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String matriculaAlumno;
    private CarreraJB carrera;
    private int anoInscripcion;
    private EstatusJB estatusAlumno;
    private ProfesorJB profesor;

    public AlumnoJB() {}

    public AlumnoJB(String matriculaAlumno, CarreraJB carrera, int anoInscripcion, EstatusJB estatusAlumno, ProfesorJB profesor) {
        this.matriculaAlumno = matriculaAlumno;
        this.carrera = carrera;
        this.anoInscripcion = anoInscripcion;
        this.estatusAlumno = estatusAlumno;
        this.profesor = profesor;
    }

    public AlumnoJB(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String genero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, String matriculaAlumno, CarreraJB carrera, int anoInscripcion, EstatusJB estatusAlumno, ProfesorJB profesor) {
        super(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email);
        this.matriculaAlumno = matriculaAlumno;
        this.carrera = carrera;
        this.anoInscripcion = anoInscripcion;
        this.estatusAlumno = estatusAlumno;
        this.profesor = profesor;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public CarreraJB getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraJB carrera) {
        this.carrera = carrera;
    }

    public int getIdCarrera() {
        return carrera.getIdCarrera();
    }

    public int getAnoInscripcion() {
        return anoInscripcion;
    }

    public void setAnoInscripcion(int anoInscripcion) {
        this.anoInscripcion = anoInscripcion;
    }

    public EstatusJB getEstatusAlumno() {
        return estatusAlumno;
    }

    public void setEstatusAlumno(EstatusJB estatusAlumno) {
        this.estatusAlumno = estatusAlumno;
    }

    public int getIdEstatusAlumno() {
        return estatusAlumno.getId();
    }

    public ProfesorJB getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorJB profesor) {
        this.profesor = profesor;
    }

    public String getIdProfesor() {
        return this.profesor.getIdProfesor();
    }
}
