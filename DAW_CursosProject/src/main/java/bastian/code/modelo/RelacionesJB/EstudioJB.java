package bastian.code.modelo.RelacionesJB;

import java.io.Serializable;

public class EstudioJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String universidad;
    private String titulo;
    private String cedula;
    private int anoGraduacion;
    private int idTipoEstudio;
    private String nombreTipoEstudio;

    public EstudioJB() {}

    public EstudioJB(String universidad, String titulo, String cedula, int anoGraduacion, int idTipoEstudio, String nombreTipoEstudio) {
        this.universidad = universidad;
        this.titulo = titulo;
        this.cedula = cedula;
        this.anoGraduacion = anoGraduacion;
        this.idTipoEstudio = idTipoEstudio;
        this.nombreTipoEstudio = nombreTipoEstudio;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getAnoGraduacion() {
        return anoGraduacion;
    }

    public void setAnoGraduacion(int anoGraduacion) {
        this.anoGraduacion = anoGraduacion;
    }

    public int getIdTipoEstudio() {
        return idTipoEstudio;
    }

    public void setIdTipoEstudio(int idTipoEstudio) {
        this.idTipoEstudio = idTipoEstudio;
    }

    public String getNombreTipoEstudio() {
        return nombreTipoEstudio;
    }

    public void setNombreTipoEstudio(String nombreTipoEstudio) {
        this.nombreTipoEstudio = nombreTipoEstudio;
    }
}
