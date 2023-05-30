package bastian.code.controlador.Sesion;

import bastian.code.datos.AlumnoDAO;
import bastian.code.datos.ProfesorDAO;
import bastian.code.datos.RelacionesDAO.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="LogInSV", urlPatterns = {"/LogInSV"} )
public class LogInSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtengo los datos del login
        String usuario = (String) req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        System.out.println("\n"+ usuario + " " + contrasena + "\nPara eliminar este mensaje, esta en LogInSV");

        //Identifico que tipo de usuatio es y redirecciono
        if ( usuario.toUpperCase().startsWith("B") && Character.isDigit( usuario.charAt(1) ) ) {
            usuario = usuario.toUpperCase();    //Lo pongo a mayucuslas por si lo escriben en minuscula

            // Primero busca en loginAlumno
            if ( LoginDAO.existAlumno(usuario, contrasena) ) {
                req.getSession().removeAttribute("Alumno");                             //Si es que habia una sesion anterior, la elimina
                req.getSession().setAttribute("Alumno", AlumnoDAO.select(usuario));     //Paso como atributo el objeto Alumno
                req.getSession().setAttribute("TypeUser", "Alumno");              //Esto lo usaré como variable para ciertas redirecciones

                //Remuevo los atributos que vienen del form anterior
                req.removeAttribute("usuario");
                req.removeAttribute("contrasena");

                req.getRequestDispatcher("VistaAlumno/IndexAlumno.jsp").forward(req, resp);
            } else
                resp.sendRedirect("index.jsp");
        } else if ( usuario.toUpperCase().startsWith("P") && Character.isDigit( usuario.charAt(1) ) ) {
            usuario = usuario.toUpperCase();            //Lo pongo a mayucuslas por si lo escriben en minuscula

            // Despues busca en loginProfesor
            if ( LoginDAO.existProfesor(usuario, contrasena) ) {
                req.getSession().removeAttribute("Profesor");
                req.getSession().setAttribute("Profesor", ProfesorDAO.select(usuario));
                req.getSession().setAttribute("TypeUser", "Profesor");

                req.getRequestDispatcher("VistaProfesor/IndexProfesor.jsp").forward(req, resp);
            } else
                resp.sendRedirect("index.jsp");
        } else {
            // Al final busca en loginAdministrador
            if ( LoginDAO.existAdministrador(usuario, contrasena) ) {
                req.getSession().setAttribute("TypeUser", "Administrador");              //Esto lo usaré como variable para ciertas redirecciones

                //Remuevo los atributos que vienen del form anterior
                req.removeAttribute("usuario");
                req.removeAttribute("contrasena");

                req.getRequestDispatcher("VistaAdministrador/IndexAdministrador.jsp").forward(req, resp);
            }
            else
                resp.sendRedirect("index.jsp");
        }
    }
}
