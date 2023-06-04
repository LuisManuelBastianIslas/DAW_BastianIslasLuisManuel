package bastian.code.controlador.Alumno;

import bastian.code.datos.RelacionesDAO.EstudioDAO;
import bastian.code.modelo.AlumnoJB;
import bastian.code.modelo.RelacionesJB.EstudioJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name ="EstudioAlumnoSV", urlPatterns = {"/EstudioAlumnoSV"} )
public class EstudioAlumnoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Funciona asi: Busca los estudios del alumno y los guarda en un array. Y eso es lo que envia
        // Adicionalmente se usará una variable que sera la pauta para mostrar un estudio

        //Primero, comprueba si ya esxiste, si no la genera
        if ( req.getSession().getAttribute("estudios") == null) {
            ArrayList<EstudioJB> estudios = EstudioDAO.select( ((AlumnoJB)req.getSession().getAttribute("Alumno")).getMatriculaAlumno() );
            req.getSession().setAttribute("estudios", estudios);
            // Me daban ganas de hacerlo todo en una sola linea
            // Pero sabia que seria muy larga la sentencia... jaja
        }

        //Lo mismo para la parte del index
        if ( req.getParameter("indexEstudio") == null )
            req.setAttribute("indexEstudio", 1);
        else {
            int index = Integer.parseInt(req.getParameter("indexEstudio"));
            req.setAttribute("indexEstudio", index);
        }

        req.getRequestDispatcher("VistaAlumno/Estudios.jsp").forward(req, resp);
    }
}
