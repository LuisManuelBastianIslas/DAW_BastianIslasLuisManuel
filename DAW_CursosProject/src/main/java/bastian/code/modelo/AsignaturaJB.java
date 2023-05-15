package bastian.code.modelo;

import java.io.Serializable;

public class AsignaturaJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nrc;
    private int idMateria;
    private String nombreMateria;
    private String curpProfesor;
    private String nombreProfesor;
    private int cupoMinimo;
    private int cupoMaximo;

    public AsignaturaJB() {}

    public AsignaturaJB(String nrc, int idMateria, String nombreMateria, String curpProfesor, String nombreProfesor, int cupoMinimo, int cupoMaximo) {
        this.nrc = nrc;
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.curpProfesor = curpProfesor;
        this.nombreProfesor = nombreProfesor;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCurpProfesor() {
        return curpProfesor;
    }

    public void setCurpProfesor(String curpProfesor) {
        this.curpProfesor = curpProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
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
}
