package bastian.code.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class ProfesorJB extends persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idTipoContrato;
    private String nombreTipoContrato;

    public ProfesorJB() {}

    public ProfesorJB(int idTipoContrato, String nombreTipoContrato) {
        this.idTipoContrato = idTipoContrato;
        this.nombreTipoContrato = nombreTipoContrato;
    }

    public ProfesorJB(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String genero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, int idTipoContrato, String nombreTipoContrato) {
        super(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email);
        this.idTipoContrato = idTipoContrato;
        this.nombreTipoContrato = nombreTipoContrato;
    }

    public int getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public void setNombreTipoContrato(String nombreTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
    }
}
