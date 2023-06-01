package bastian.code.modelo.RelacionesJB;

import bastian.code.modelo.CatalogosJB.TipoJB;

import java.io.Serializable;
import java.time.Year;

public class EstudioJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String universidad;
    private String titulo;
    private String cedula;
    private Year anoGraduacion;
    private TipoJB tipoEstudio;

    public EstudioJB() {}

    public EstudioJB(String universidad, String titulo, String cedula, Year anoGraduacion, TipoJB tipoEstudio) {
        this.universidad = universidad;
        this.titulo = titulo;
        this.cedula = cedula;
        this.anoGraduacion = anoGraduacion;
        this.tipoEstudio = tipoEstudio;
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

    public Year getAnoGraduacion() {
        return anoGraduacion;
    }

    public void setAnoGraduacion(Year anoGraduacion) {
        this.anoGraduacion = anoGraduacion;
    }

    public TipoJB getTipoEstudio() {
        return tipoEstudio;
    }

    public void setTipoEstudio(TipoJB tipoEstudio) {
        this.tipoEstudio = tipoEstudio;
    }
}
