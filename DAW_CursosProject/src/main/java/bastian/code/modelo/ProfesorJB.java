package bastian.code.modelo;

import bastian.code.modelo.CatalogosJB.TipoJB;

import java.io.Serializable;
import java.time.LocalDate;

public class ProfesorJB extends persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idProfesor;
    private TipoJB tipoContrato;

    public ProfesorJB() {}

    public ProfesorJB(String idProfesor, TipoJB tipoContrato) {
        this.idProfesor = idProfesor;
        this.tipoContrato = tipoContrato;
    }

    public ProfesorJB(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String genero, LocalDate fechaNacimiento, String direccion, String telefono, String celular, String email, String idProfesor, TipoJB tipoContrato) {
        super(curp, nombre, apellidoPaterno, apleiidoMaterno, genero, fechaNacimiento, direccion, telefono, celular, email);
        this.idProfesor = idProfesor;
        this.tipoContrato = tipoContrato;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public TipoJB getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoJB tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getIdTipoContrato() {
        return this.tipoContrato.getId();
    }
}
