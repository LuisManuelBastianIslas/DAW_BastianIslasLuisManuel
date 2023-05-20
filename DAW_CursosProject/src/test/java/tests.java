import bastian.code.datos.Conexion;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class tests {

    public static void main(String[] args) {
        /*
        System.out.println("Hola mundo");

        String insert = "insert into tipomateria(nombretipomateria) values (?);";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();

            String nombreTipoMateria;
            Scanner entrada = new Scanner(System.in);
            do {
                nombreTipoMateria = entrada.nextLine();
                if ( !nombreTipoMateria.equals("salir") ) {
                    ps = conn.prepareStatement(insert);
                    ps.setString(1, nombreTipoMateria);
                    ps.executeUpdate();
                    System.out.println("Se inserto el tipo de materia " + nombreTipoMateria + " con exito.");
                }
            } while( !nombreTipoMateria.equals("salir") );
            System.out.println("Si funcionó, tal vez jaja");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.close(ps);
        Conexion.close(conn);
         */

        tockenizacion();
    }

    public static void tockenizacion() {

        //Texto generado por chatGPT :)
        String datostxt = "Ana María-García-Hernández-Av. Las Palmas #23, Veracruz, Ver.-F\n" +
                "Juan Carlos-López-Ruiz-Calle 20 de Noviembre #45, Boca del Río, Ver.-M\n" +
                "María Fernanda-González-González-Fracc. Las Brisas #8, Veracruz, Ver.-F\n" +
                "Carlos Eduardo-Hernández-López-Col. San José #12, Boca del Río, Ver.-M\n" +
                "Sofía Guadalupe-Pérez-García-Calle Miguel Alemán #56, Veracruz, Ver.-F\n" +
                "Francisco Javier-Ramírez-Ramírez-Fracc. Costa de Oro #34, Boca del Río, Ver.-M\n"/* +
                "Andrea Isabel-Martínez-Rodríguez-Av. Díaz Mirón #123, Veracruz, Ver.-F\n" +
                "Juan Antonio-Torres-Hernández-Col. Progreso #67, Boca del Río, Ver.-M\n" +
                "Mariana Alejandra-Pérez-Ramírez-Fracc. El Dorado #9, Veracruz, Ver.-F\n" +
                "Luis Miguel-González-Pérez-Calle 16 de Septiembre #87, Boca del Río, Ver.-M\n" +
                "Daniela-Sánchez-Gómez-Av. Ruiz Cortines #54, Veracruz, Ver.-F\n" +
                "José Manuel-Rodríguez-García-Col. Ricardo Flores Magón #23, Boca del Río, Ver.-M\n" +
                "Paola Alejandra-Torres-Romero-Fracc. Costa Verde #14, Veracruz, Ver.-F\n" +
                "Roberto Carlos-Gutiérrez-Pérez-Calle Orizaba #34, Boca del Río, Ver.-M\n" +
                "Gabriela-Rodríguez-Hernández-Col. Playa Linda #56, Veracruz, Ver.-F\n" +
                "Miguel Ángel-Méndez-Flores-Fracc. Lomas de Río Medio #8, Boca del Río, Ver.-M\n" +
                "Laura Elizabeth-García-Méndez-Calle Álamo #23, Veracruz, Ver.-F\n" +
                "Juan Francisco-Hernández-Torres-Col. Mocambo #67, Boca del Río, Ver.-M\n" +
                "Diana Paola-Ramos-López-Fracc. Jardines de Virginia #9, Veracruz, Ver.-F\n" +
                "Fernando José-Torres-Martínez-Calle Reforma #87, Boca del Río, Ver.-M\n" +
                "Melissa Guadalupe-Aguilar-Rivera-Col. Reforma #54, Veracruz, Ver.-F\n" +
                "Salvador Arturo-Vargas-González-Fracc. Jardines del Virginia #23, Boca del Río, Ver.-M\n" +
                "Estefanía-Torres-García-Calle Xalapa #67, Veracruz, Ver.-F\n" +
                "Carlos Eduardo-Rodríguez-Torres-Col. Carranza #14, Boca del Río, Ver.-M\n" +
                "Natalia Alejandra-García-Sánchez-Fracc. Río Medio #8, Veracruz, Ver.-F\n" +
                "José Luis-Hernández-Gómez-Calle México #23, Boca del Río, Ver.-M\n"*/;

        SQLPersona tockenizador = new SQLPersona();
        ArrayList<String> datos = tockenizador.alumnos(datostxt);

//        for (String dato : datos)
//            System.out.println(dato);

        FillPersona.fillProfesor(datos);
    }
}

class FillPersona {

    private static String reg = "rep";
    public static void fillProfesor(ArrayList<String> datos) {
        File archivo =null;
        FileReader fr = null;
        BufferedReader br = null;

        File nvo = null;
        FileWriter fw;

        try {
            archivo = new File("C:\\Users\\Luis Manuel\\Documents\\Escuelas\\Luis Manuel\\UV\\6to semestre\\DAW\\DBproyecto\\Profesores.txt");
            fr = new FileReader(archivo);
            br= new BufferedReader(fr);

            nvo = new File("C:\\Users\\Luis Manuel\\Documents\\Escuelas\\Luis Manuel\\UV\\6to semestre\\DAW\\DBproyecto\\ProfesoresEdited.txt");
            nvo.createNewFile();
            fw = new FileWriter(nvo);

            for (int i = 0; i < 6; i++) {
                String texto = br.readLine();

                for (int j = 0; j < 5; j++) {
                    texto = texto.replaceFirst(reg, datos.get( (i*5)+j ));
                }
                System.out.println(texto);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fw.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
