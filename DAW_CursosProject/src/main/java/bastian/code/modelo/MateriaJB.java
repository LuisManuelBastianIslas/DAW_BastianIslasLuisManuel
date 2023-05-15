package bastian.code.modelo;

import java.io.Serializable;

public class MateriaJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idMateria;
    private String nombreMateria;
    private int creditos;
    private int horas;
    private int idTipoMateria;
    private String nombreTipoMateria;

    public MateriaJB() {}

    public MateriaJB(int idMateria, String nombreMateria, int creditos, int horas, int idTipoMateria, String nombreTipoMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
        this.horas = horas;
        this.idTipoMateria = idTipoMateria;
        this.nombreTipoMateria = nombreTipoMateria;
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
        return idTipoMateria;
    }

    public void setIdTipoMateria(int idTipoMateria) {
        this.idTipoMateria = idTipoMateria;
    }

    public String getNombreTipoMateria() {
        return nombreTipoMateria;
    }

    public void setNombreTipoMateria(String nombreTipoMateria) {
        this.nombreTipoMateria = nombreTipoMateria;
    }
}
