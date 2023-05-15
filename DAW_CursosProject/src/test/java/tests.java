import bastian.code.datos.Conexion;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class tests {

    public static void main(String[] args) {
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
    }
}
