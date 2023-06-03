package bastian.code.controlador.Alumno;

import bastian.code.datos.MateriaDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.MateriaJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name ="CurriculaSV", urlPatterns = {"/CurriculaSV"} )
public class CurriculaSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeUser = (String) req.getSession().getAttribute("TypeUser");
        ArrayList<ArrayList<MateriaJB>> matrizMaterias = null;
        int idCarrera = -1;

        if ( req.getSession().getAttribute("Alumno") != null ) {
            req.setAttribute("Carrera", ((AlumnoJB)req.getSession().getAttribute("Alumno")).getCarrera() );
            idCarrera = ((AlumnoJB)req.getSession().getAttribute("Alumno")).getIdCarrera();
        } else if (typeUser.equals("Profesor")) {

        } else {
            idCarrera = (Integer) req.getAttribute("IdCarrera");
        }

        System.out.println(idCarrera + "\nPara eliminar esto, esta en CurriculaSV");

        matrizMaterias = MateriaDAO.getCurricula(idCarrera);                                    // Se inicializa la curricula

        req.setAttribute("matrizMaterias", matrizMaterias);                             // Se guarda como atributo

        req.getRequestDispatcher("VistaCompartida/Curricula.jsp").forward(req, resp);       // Se envia
    }
}
