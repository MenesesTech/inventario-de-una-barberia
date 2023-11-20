package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConexionSql {

    private String database_name = "havanabd";
    private String user = "root";
    private String password = "Curbicode1000";
    private String url = "jdbc:mysql://localhost:3306/" + database_name;

    Connection conn = null;

    public Connection getConnection() {
        try {
            //Cargar y registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error SQLException" + e.getMessage());
        }
        return conn;

    }
}
