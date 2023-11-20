package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoryDao {

    ConexionSql cn = new ConexionSql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Registra una nueva categoría en la base de datos.
     *
     * @param category La categoría a ser registrada.
     * @return true si la operación se realiza con éxito, false en caso
     * contrario.
     */
    public boolean registerCategoryQuery(Category category) {
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

    /**
     * Obtiene la lista de todas las categorías almacenadas en la base de datos.
     *
     * @return Una lista de objetos de tipo Category.
     */
    public List<Category> listCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT id_categoria, nombre_categoria FROM categoria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("id_categoria"));
                category.setName(rs.getString("nombre_categoria"));
                categories.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return categories;
    }

    /**
     * Actualiza la información de una categoría en la base de datos.
     *
     * @param category La categoría con la información actualizada.
     * @return true si la operación se realiza con éxito, false en caso
     * contrario.
     */
    public boolean updateCategory(Category category) {
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

    /**
     * Elimina una categoría de la base de datos por su ID.
     *
     * @param id El ID de la categoría a ser eliminada.
     * @return true si la operación se realiza con éxito, false en caso
     * contrario.
     */
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

    /**
     * Obtiene la lista de nombres de categorías para ser utilizada en un
     * ComboBox.
     *
     * @return Una lista de objetos de tipo Category con el nombre de las
     * categorías.
     */
    public List<Category> listCategoriesCombobox() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT nombre_categoria FROM categoria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("nombre_categoria"));
                categories.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return categories;
    }
}
