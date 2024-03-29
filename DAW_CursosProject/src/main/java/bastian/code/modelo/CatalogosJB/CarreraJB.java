package bastian.code.modelo.CatalogosJB;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.modelo.ProfesorJB;

import java.io.Serializable;

public class CarreraJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idCarrera;
    private String nombreCarrera;
    private TipoJB tipoCarrera;
    private ProfesorJB profesor;

    public CarreraJB() {}

    public CarreraJB(int idCarrera, String nombreCarrera, TipoJB tipoCarrera, ProfesorJB profesor) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.tipoCarrera = tipoCarrera;
        this.profesor = profesor;
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

    public TipoJB getTipoCarrera() {
        return tipoCarrera;
    }

    public void setTipoCarrera(TipoJB tipoCarrera) {
        this.tipoCarrera = tipoCarrera;
    }

    public int getIdTipoCarerra() {
        return this.tipoCarrera.getId();
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
    public int getCantidadSemestres() {
        return CarreraDAO.getCantidadSemestres(this.idCarrera);
    }

    public int getCantidadCreditos() {
        return CarreraDAO.getCantidadCreditos(this.idCarrera);
    }
}
