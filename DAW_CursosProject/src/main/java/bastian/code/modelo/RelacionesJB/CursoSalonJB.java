package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.SalonDAO;
import bastian.code.modelo.SalonJB;

import java.io.Serializable;
import java.time.LocalTime;

public class CursoSalonJB extends curso implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idSalon;
    private LocalTime hora;
    private int intDiaSemana;

    public CursoSalonJB() {}

    public CursoSalonJB(int idPeriodo, int nrc, String idSalon, LocalTime hora, int intDiaSemana) {
        super(idPeriodo, nrc);
        this.idSalon = idSalon;
        this.hora = hora;
        this.intDiaSemana = intDiaSemana;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public SalonJB getSalon() {
        return SalonDAO.select(this.idSalon);
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalTime getHoraFin() {
        return this.hora.plusMinutes(59);
    }

    public String getHorario() { return getHora() + " - " + getHoraFin(); }

    public int getIntDiaSemana() {
        return intDiaSemana;
    }

    public void setIntDiaSemana(int intDiaSemana) {
        this.intDiaSemana = intDiaSemana;
    }

    public String getDiaSemana() {
        switch (this.intDiaSemana) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
        }
        return null;    // Me lo metio el IDE jaja
    }
}
