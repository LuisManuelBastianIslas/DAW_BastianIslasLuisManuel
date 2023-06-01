package bastian.code.controlador.Profesor;

import bastian.code.datos.RelacionesDAO.EstudioDAO;
import bastian.code.modelo.ProfesorJB;
import bastian.code.modelo.RelacionesJB.EstudioJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name ="EstudiosProfesorSV", urlPatterns = {"/EstudiosProfesorSV"} )
public class EstudioProfesorSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Funciona asi: Busca los estudios del profesor y los guarda en un array. Y eso es lo que envia
        // Adicionalmente se usará una variable que sera la pauta para mostrar un estudio

        //Primero, comprueba si ya esxiste, si no la genera
        if ( req.getSession().getAttribute("estudios") == null) {
            ArrayList<EstudioJB> estudios = EstudioDAO.select( ((ProfesorJB)req.getSession().getAttribute("Profesor")).getCurp() );
            req.getSession().setAttribute("estudios", estudios);
            // Me daban ganas de hacerlo todo en una sola linea
            // Pero sabia que seria muy larga la sentencia... jaja
        }

        //Lo mismo para la parte del index
        if ( req.getAttribute("indexEstudio") == null )
            req.setAttribute("indexEstudio", 1);

        req.getRequestDispatcher("VistaProfesor/Estudios.jsp").forward(req, resp);
    }
}
