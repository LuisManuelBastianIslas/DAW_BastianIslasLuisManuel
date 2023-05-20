package bastian.code.modelo;

import bastian.code.modelo.CatalogosJB.TipoJB;

import java.io.Serializable;

public class SalonJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idSalon;
    private TipoJB tipoSalon;
    private String ubicacion;
    private int cantidadPupitres;

    public SalonJB() {}

    public SalonJB(String idSalon, TipoJB tipoSalon, String ubicacion, int cantidadPupitres) {
        this.idSalon = idSalon;
        this.tipoSalon = tipoSalon;
        this.ubicacion = ubicacion;
        this.cantidadPupitres = cantidadPupitres;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public TipoJB getTipoSalon() {
        return tipoSalon;
    }

    public void setTipoSalon(TipoJB tipoSalon) {
        this.tipoSalon = tipoSalon;
    }

    public int getIdTipoSalon () {
        return this.tipoSalon.getId();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidadPupitres() {
        return cantidadPupitres;
    }

    public void setCantidadPupitres(int cantidadPupitres) {
        this.cantidadPupitres = cantidadPupitres;
    }
}
