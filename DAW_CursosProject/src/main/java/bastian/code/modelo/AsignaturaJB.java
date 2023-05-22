package bastian.code.modelo;

import java.io.Serializable;

public class AsignaturaJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int nrc;
    private MateriaJB materia;
    private ProfesorJB profesor;
    private int cupoMinimo;
    private int cupoMaximo;

    public AsignaturaJB() {}

    public AsignaturaJB(int nrc, MateriaJB materia, ProfesorJB profesor, int cupoMinimo, int cupoMaximo) {
        this.nrc = nrc;
        this.materia = materia;
        this.profesor = profesor;
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
        return this.materia.getIdMateria();
    }

    public MateriaJB getMateria() {
        return materia;
    }

    public void setMateria(MateriaJB materia) {
        this.materia = materia;
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
