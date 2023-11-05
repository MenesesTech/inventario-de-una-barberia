package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class usuarioDao {

    //Instanciar la conexion
    conexionsql cn = new conexionsql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    // Variables para enviar datos entre interfaces
    public static int id_user = 0;
    public static String full_name = "";
    public static String username = "";
    public static String rol_user = "";

    // Metodo de Login
    public usuario loginQuery(String user_name, String password) {
        String query = "SELECT * FROM usuario WHERE username = ? AND contrasena = ?";
        usuario empleado = new usuario();
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, user_name);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                empleado.setId(rs.getInt("id_usuario"));
                id_user = empleado.getId();
                empleado.setNombre(rs.getString("nombre"));
                full_name = empleado.getNombre();
                empleado.setUsername(rs.getString("username"));
                username = empleado.getUsername();
                empleado.setRol(rs.getString("rol"));
                rol_user = empleado.getRol();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al empleado " + e);
        }
        return empleado;
    }

    // Metodo para registrar el usuario
    public boolean registerUserQuery(usuario user_obj) {
        String query = "INSERT INTO usuario (username, contrasena, nombre, rol) VALUES(?,?,?,?)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, user_obj.getUsername());
            pst.setString(2, user_obj.getPassword());
            pst.setString(3, user_obj.getNombre());
            pst.setString(4, user_obj.getRol());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al usuario: " + e);
            return false;
        }
    }

    // Metodo para listar usuarios
    public List listUserQuery() {
        List<usuario> list_users = new ArrayList();
        String query = "SELECT id_usuario, username, contrasena, nombre, rol FROM usuario;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("contrasena"));
                user.setNombre(rs.getString("nombre"));
                user.setRol(rs.getString("rol"));
                list_users.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_users;
    }

    // Actualizar datos del usuario
    public boolean updateUserQuery(usuario user_obj) {
        String query = "UPDATE usuario SET username = ?, contrasena = ?, nombre = ?, rol =? WHERE id_usuario = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, user_obj.getUsername());
            pst.setString(2, user_obj.getPassword());
            pst.setString(3, user_obj.getNombre());
            pst.setString(4, user_obj.getRol());
            pst.setInt(5, user_obj.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del empleado " + e);
            return false;
        }
    }
    
    // Metodo para eliminar un empleado
    public boolean deleteUserQuery(String id) {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar un empleado que tenga relacion con otra tabla " + e);
            return false;
        }
    }
    // Metodo para recuperar contraseña
    public String recuperarContraseña(String username) {
        String query = "SELECT contrasena FROM usuario WHERE username = '" + username + "'";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                String password = rs.getString("contrasena");
                return password;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con ese nombre de usuario.");
                return "No se encontró ningún empleado con ese nombre de usuario";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar contraseña: "+e);
            return "Ha ocurrido un error al recuperar la contraseña ";
        }
    }

}
