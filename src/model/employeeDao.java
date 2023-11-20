package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeDao {

    ConexionSql cn = new ConexionSql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    // Variables para enviar datos entre interfaces
    public static int id_user = 0;
    public static String full_name = "";
    public static String username = "";
    public static String rol_user = "";

    /**
     * Valida las credenciales del usuario para el inicio de sesión.
     *
     * @param userName
     * @param password
     * @return Objeto Employee si el inicio de sesión es exitoso, de lo contrario, null.
     */
    public Employee loginQuery(String userName, String password) {
        String query = "SELECT * FROM usuario WHERE username = ? AND contrasena = ?";
        Employee employeeUser = new Employee();
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                employeeUser.setId(rs.getInt("id_usuario"));
                id_user = employeeUser.getId();
                employeeUser.setName(rs.getString("nombre"));
                full_name = employeeUser.getName();
                employeeUser.setUsername(rs.getString("username"));
                username = employeeUser.getUsername();
                employeeUser.setRol(rs.getString("rol"));
                rol_user = employeeUser.getRol();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al empleado " + e);
        }
        return employeeUser;
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param employeeUser
     * @return True si el registro es exitoso, de lo contrario, false.
     */
    public boolean registerUserQuery(Employee employeeUser) {
        String query = "INSERT INTO usuario (username, contrasena, nombre, rol) VALUES(?,?,?,?)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employeeUser.getUsername());
            pst.setString(2, employeeUser.getPassword());
            pst.setString(3, employeeUser.getName());
            pst.setString(4, employeeUser.getRol());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al usuario: " + e);
            return false;
        }
    }

    /**
     * Recupera una lista de todos los usuarios.
     *
     * @return Lista de objetos Employee.
     */
    public List<Employee> listUserQuery() {
        List<Employee> listEmployees = new ArrayList<>();
        String query = "SELECT id_usuario, username, contrasena, nombre, rol FROM usuario;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Employee employeeUser = new Employee();
                employeeUser.setId(rs.getInt("id_usuario"));
                employeeUser.setUsername(rs.getString("username"));
                employeeUser.setPassword(rs.getString("contrasena"));
                employeeUser.setName(rs.getString("nombre"));
                employeeUser.setRol(rs.getString("rol"));
                listEmployees.add(employeeUser);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listEmployees;
    }

    /**
     * Actualiza la información de un usuario.
     *
     * @param employeeUser
     * @return True si la actualización es exitosa, de lo contrario, false.
     */
    public boolean updateUserQuery(Employee employeeUser) {
        String query = "UPDATE usuario SET username = ?, contrasena = ?, nombre = ?, rol = ? WHERE (id_usuario = ?)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employeeUser.getUsername());
            pst.setString(2, employeeUser.getPassword());
            pst.setString(3, employeeUser.getName());
            pst.setString(4, employeeUser.getRol());
            pst.setInt(5, employeeUser.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del empleado " + e);
            return false;
        }
    }

    /**
     * Elimina un usuario.
     *
     * @param id Identificación del usuario a eliminar.
     * @return True si la eliminación es exitosa, de lo contrario, false.
     */
    public boolean deleteUserQuery(String id) {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar un empleado que tenga relación con otra tabla " + e);
            return false;
        }
    }

    /**
     * Recupera la contraseña de un usuario.
     *
     * @param username Nombre de usuario.
     * @return Contraseña del usuario o cadena vacía si no se encuentra.
     */
    public String retrievePassword(String username) {
        String query = "SELECT contrasena FROM usuario WHERE username = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                String password = rs.getString("contrasena");
                return password;
            }
            return "";
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar contraseña: " + e);
            return "";
        }
    }

    /**
     * Actualiza la contraseña de un usuario.
     *
     * @param employeeUser Usuario con la nueva contraseña.
     * @return True si la actualización es exitosa, de lo contrario, false.
     */
    public boolean updateEmployeePassword(Employee employeeUser) {
        String query = "UPDATE usuario SET contrasena = ? WHERE username = '" + username + "'";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employeeUser.getPassword());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña " + e);
            return false;
        }
    }
}
