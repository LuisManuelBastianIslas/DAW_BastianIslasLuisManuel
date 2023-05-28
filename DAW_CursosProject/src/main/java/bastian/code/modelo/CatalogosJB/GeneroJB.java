package bastian.code.modelo.CatalogosJB;

import java.io.Serializable;

public class GeneroJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idGenero;
    private String nombreGenero;

    public GeneroJB() {}

    public GeneroJB(String idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}
