package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class categoriaDao {

    //Instanciar la conexion
    conexionsql cn = new conexionsql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean registroCategoryQuery(categoria category) {
        String query = "INSERT INTO categoria (nombre_categoria) VALUES (?)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la categoria: " + e);
            return false;
        }
    }

    public List<categoria> listCategories() {
        List<categoria> categories = new ArrayList<>();
        String query = "SELECT id_categoria, nombre_categoria FROM categoria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                categoria category = new categoria();
                category.setId(rs.getString("id_categoria"));
                category.setName(rs.getString("nombre_categoria"));
                categories.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return categories;
    }

    public boolean updateCategory(categoria category) {
        String query = "UPDATE categoria SET nombre_categoria = ? WHERE id_categoria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.setString(2, category.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoría: " + e);
            return false;
        }
    }

    public boolean deleteCategory(String id) {
        String query = "DELETE FROM categoria WHERE id_categoria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar una categoría que tenga relaciones con otras tablas: " + e);
            return false;
        }
    }
}
