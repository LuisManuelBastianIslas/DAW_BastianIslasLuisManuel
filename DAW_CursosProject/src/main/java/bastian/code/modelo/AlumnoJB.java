package bastian.code.modelo;

import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.modelo.CatalogosJB.CarreraJB;
import bastian.code.modelo.CatalogosJB.EstatusJB;
import bastian.code.modelo.CatalogosJB.GeneroJB;
import bastian.code.modelo.CatalogosJB.PeriodoJB;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

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

    public AlumnoJB(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, GeneroJB genero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, String matriculaAlumno, CarreraJB carrera, int anoInscripcion, EstatusJB estatusAlumno, ProfesorJB profesor) {
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

    /**
     * Funciones calculadas
     */
    public int getSemestre() {
        int anoActual, mesActual, dia = 1, mesIns = 8;
        PeriodoJB periodoActual = PeriodoDAO.getPeriodoActual();
        anoActual = periodoActual.getAno();
        mesActual = periodoActual.getMesPeriodo();

        LocalDate inscripcion = LocalDate.of(this.anoInscripcion, mesIns, dia);
        LocalDate hoy = LocalDate.of(anoActual, mesActual, dia);

        return ( Period.between( inscripcion, hoy ).getMonths() / 6 ) + 1;
    }
}
