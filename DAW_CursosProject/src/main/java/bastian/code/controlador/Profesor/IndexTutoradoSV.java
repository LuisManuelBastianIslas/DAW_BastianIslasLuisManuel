package bastian.code.controlador.Profesor;


import bastian.code.datos.AlumnoDAO;
import bastian.code.modelo.AlumnoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="IndexTutoradoSV", urlPatterns = {"/IndexTutoradoSV"} )
public class IndexTutoradoSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( req.getParameter("Matricula") + "\nPara eliminar esto, esta en IndexTutoradoSV");
        AlumnoJB alumno = AlumnoDAO.select( req.getParameter("Matricula") );
        req.getSession().setAttribute("Alumno", alumno);
        req.getRequestDispatcher("VistaAlumno/IndexAlumno.jsp").forward(req, resp);
    }
}
