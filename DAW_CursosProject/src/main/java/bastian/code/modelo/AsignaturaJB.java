package bastian.code.modelo;

import bastian.code.datos.CatalogosDAO.CarreraDAO;
import bastian.code.datos.MateriaDAO;
import bastian.code.datos.ProfesorDAO;
import bastian.code.modelo.CatalogosJB.CarreraJB;

import java.io.Serializable;

public class AsignaturaJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int nrc;
    private int idMateria;
    private String idProfesor;
    private int cupoMinimo;
    private int cupoMaximo;

    public AsignaturaJB() {}

    public AsignaturaJB(int nrc, int idMateria, String idProfesor, int cupoMinimo, int cupoMaximo) {
        this.nrc = nrc;
        this.idMateria = idMateria;
        this.idProfesor = idProfesor;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public int getIdMateria() {
        return this.idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public MateriaJB getMateria() {
        return MateriaDAO.select(this.idMateria);
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getIdProfesor() {
        return this.idProfesor;
    }

    public ProfesorJB getProfesor() {
        return ProfesorDAO.select(this.idProfesor);
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    /**
     * Funciones calculadas
     */
    public CarreraJB getCarrera() {
        String nrcSTR = this.getNrc() + "";
        return CarreraDAO.select( Integer.parseInt( nrcSTR.charAt(0) + "" ) );
    }
}
