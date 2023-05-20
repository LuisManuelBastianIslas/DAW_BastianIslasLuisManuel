import java.util.ArrayList;
import java.util.StringTokenizer;

public class SQLPersona {

    public ArrayList<String> alumnos(String content) {
        ArrayList<String> alumnos = new ArrayList<>();
        ArrayList<String> registros = tkRegistros(content);

        ArrayList<String> datosPersonas = new ArrayList<>();
        for (String registro : registros) {
            ArrayList<String> datosPersona = tkDatosPersona(registro);
            for (String dato : datosPersona)
                datosPersonas.add(dato);
        }

        return datosPersonas;
    }

    private ArrayList<String> tkRegistros (String content) {
        ArrayList<String> registros = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(content, "\n");

        while (st.hasMoreTokens())
            registros.add( st.nextToken() );

        return registros;
    }

    private ArrayList<String> tkDatosPersona (String registros) {
        ArrayList<String> datosPersona = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(registros, "-");

        while (st.hasMoreTokens()) {
            String dato = st.nextToken();

            //Quita los espacio iniciales
            if (dato.startsWith(" "))
                dato = dato.substring(1);

            datosPersona.add(dato);
        }

        return datosPersona;
    }
}
