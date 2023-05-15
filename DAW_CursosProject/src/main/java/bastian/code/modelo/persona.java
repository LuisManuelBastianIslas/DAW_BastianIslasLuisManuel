package bastian.code.modelo;

import java.io.Serializable;

public class persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apleiidoMaterno;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;

    public persona() {}

    public persona(String curp, String nombre, String apellidoPaterno, String apleiidoMaterno, String direccion, String telefono, String celular, String email) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apleiidoMaterno = apleiidoMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApleiidoMaterno() {
        return apleiidoMaterno;
    }

    public void setApleiidoMaterno(String apleiidoMaterno) {
        this.apleiidoMaterno = apleiidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.apellidoPaterno + " " + this.apleiidoMaterno + " " + this.nombre;
    }
}
