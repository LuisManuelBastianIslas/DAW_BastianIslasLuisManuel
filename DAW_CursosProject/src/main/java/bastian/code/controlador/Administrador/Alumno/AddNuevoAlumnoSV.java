package bastian.code.controlador.Administrador.Alumno;

import bastian.code.datos.AlumnoDAO;
import bastian.code.datos.CatalogosDAO.PeriodoDAO;
import bastian.code.datos.ProfesorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@WebServlet (name = "AddNuevoAlumnoSV", urlPatterns = {"/AddNuevoAlumnoSV"})
public class AddNuevoAlumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recibo los datos que se pasaron de la vista anterior
        String curp = req.getParameter("CURP");
        String nombre = req.getParameter("Nombre");
        String apellidoPaterno = req.getParameter("ApellidoPaterno");
        String apellidoMaterno = req.getParameter("ApellidoMaterno");
        String idGenero = req.getParameter("IdGenero");
        LocalDate fechaNacimiento = LocalDate.parse( req.getParameter("FechaNacimiento") );
        String direccion = req.getParameter("Direccion");
        String telefono = req.getParameter("Telefono");
        String celular = req.getParameter("Celular");
        int idCarrera = Integer.parseInt(req.getParameter("IdCarrera"));

        // Genero los datos que faltan
        AlumnoDAO daoA = new AlumnoDAO();
        Random r = new Random(Instant.now().getEpochSecond());
        ProfesorDAO daoP = new ProfesorDAO();

        String matricula = daoA.getNextMatricula();
        String email = "e" + matricula + "@bastianuniversities.mx";
        int anoInscripción = PeriodoDAO.getPeriodoActual().getAno();
        int idEstatusAlumno = 1;    // Activo
        int idRandom = (r.nextInt() % daoP.getCantProfesores()) + 1;
        String randomIdProfesor = "P" + String.format("%03d", idRandom);

        AlumnoDAO.insert(curp, nombre, apellidoPaterno, apellidoMaterno, idGenero, fechaNacimiento, direccion, telefono, celular, email, matricula, idCarrera, anoInscripción, idEstatusAlumno, randomIdProfesor);

        // Al final regresa por si acaso se necesita ingresar mas alumnos
        req.getRequestDispatcher("VistaAdministrador/Alumno/NuevoAlumno.jsp").forward(req, resp);
    }
}
