package bastian.code.modelo;

import java.io.Serializable;

public class SalonJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idSalon;
    private int idTipoSalon;
    private String nombreTipoSalon;
    private String ubicacion;
    private int cantidadPupitres;

    public SalonJB() {}

    public SalonJB(String idSalon, int idTipoSalon, String nombreTipoSalon, String ubicacion, int cantidadPupitres) {
        this.idSalon = idSalon;
        this.idTipoSalon = idTipoSalon;
        this.nombreTipoSalon = nombreTipoSalon;
        this.ubicacion = ubicacion;
        this.cantidadPupitres = cantidadPupitres;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public int getIdTipoSalon() {
        return idTipoSalon;
    }

    public void setIdTipoSalon(int idTipoSalon) {
        this.idTipoSalon = idTipoSalon;
    }

    public String getNombreTipoSalon() {
        return nombreTipoSalon;
    }

    public void setNombreTipoSalon(String nombreTipoSalon) {
        this.nombreTipoSalon = nombreTipoSalon;
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
