package bastian.code.modelo;

import bastian.code.modelo.CatalogosJB.TipoJB;

import java.io.Serializable;

public class MateriaJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idMateria;
    private String nombreMateria;
    private int creditos;
    private int horas;
    private TipoJB tipoMateria;

    public MateriaJB() {}

    public MateriaJB(int idMateria, String nombreMateria, int creditos, int horas, TipoJB tipoMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
        this.horas = horas;
        this.tipoMateria = tipoMateria;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getIdTipoMateria() {
        return tipoMateria.getId();
    }

    public TipoJB getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(TipoJB tipoMateria) {
        this.tipoMateria = tipoMateria;
    }
}
