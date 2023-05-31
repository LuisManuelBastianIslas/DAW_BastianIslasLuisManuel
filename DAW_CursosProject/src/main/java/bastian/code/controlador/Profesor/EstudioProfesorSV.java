package bastian.code.controlador.Profesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="EstudiosProfesorSV", urlPatterns = {"/EstudiosProfesorSV"} )
public class EstudioProfesorSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Funciona asi: Busca los estudios del profesor y los guarda en un array. Y eso es lo que envia
    }
}
