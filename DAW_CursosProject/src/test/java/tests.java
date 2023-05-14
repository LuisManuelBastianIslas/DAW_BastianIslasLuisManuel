import bastian.code.datos.Conexion;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tests {

    public static void main(String[] args) {
        System.out.println("Hola mundo");

        String insert = "insert into tipomateria(nombretipomateria) values ('Mixta');";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insert);
            ps.executeUpdate();
            System.out.println("Si funcionó, tal vez jaja");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
