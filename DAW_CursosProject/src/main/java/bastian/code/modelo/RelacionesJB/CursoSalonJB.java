package bastian.code.modelo.RelacionesJB;

import bastian.code.datos.AsignaturaDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.SalonDAO;
import bastian.code.modelo.AsignaturaJB;
import bastian.code.modelo.CatalogosJB.PeriodoJB;
import bastian.code.modelo.SalonJB;

import java.io.Serializable;
import java.time.LocalTime;

public class CursoSalonJB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idPeriodo;    //Creo que este no necesito hacerlo objeto
    private int NRC;    //Creo que este no necesito hacerlo objeto
    private String idSalon;
    private LocalTime hora;
    private int intDiaSemana;

    public CursoSalonJB() {}

    public CursoSalonJB(int idPeriodo, int NRC, String idSalon, LocalTime hora, int intDiaSemana) {
        this.idPeriodo = idPeriodo;
        this.NRC = NRC;
        this.idSalon = idSalon;
        this.hora = hora;
        this.intDiaSemana = intDiaSemana;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int periodo) {
        this.idPeriodo = periodo;
    }

    public PeriodoJB getPeriodo() {
        return PeriodoDAO.select(this.idPeriodo);
    }

    public int getNRC() {
        return NRC;
    }

    public void setNRC(int NRC) {
        this.NRC = NRC;
    }

    public AsignaturaJB getAsignatura() {
        return AsignaturaDAO.select(this.NRC);
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
            case 6:
                return "Sabado";
        }
        return null;    // Me lo metio el IDE jaja
    }
}
