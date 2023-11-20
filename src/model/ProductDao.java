package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductDao {

    ConexionSql cn = new ConexionSql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param product El producto a registrar.
     * @return true si el registro es exitoso, false si ocurre algún error.
     */
    public boolean registerProduct(Product product) {
        String query = "INSERT INTO producto (codigo_producto, nombre_producto, descripcion, created, updated, id_categoria) VALUES (?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getCode());
            pst.setString(2, product.getName());
            pst.setString(3, product.getDescription());
            pst.setTimestamp(4, datetime);
            pst.setTimestamp(5, datetime);
            pst.setInt(6, product.getCategory_id());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al regitrar el producto " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de todos los productos con información detallada.
     *
     * @return Una lista de productos con detalles.
     */
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT p.codigo_producto, p.nombre_producto, p.descripcion, p.cantidad, p.created, p.updated, c.nombre_categoria "
                + "FROM producto p INNER JOIN categoria c ON p.id_categoria = c.id_categoria";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setCode(rs.getString("codigo_producto"));
                product.setName(rs.getString("nombre_producto"));
                product.setDescription(rs.getString("descripcion"));
                product.setQuantity(rs.getInt("cantidad"));
                product.setCreated(rs.getString("created"));
                product.setUpdated(rs.getString("updated"));
                product.setCategory_name(rs.getString("nombre_categoria"));
                products.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al enlistar todos los productos " + e);
        }
        return products;
    }

    /**
     * Modifica la información de un producto existente en la base de datos.
     *
     * @param product El producto con la nueva información.
     * @return true si la modificación es exitosa, false si ocurre algún error.
     */
    public boolean updateProduct(Product product) {
        String query = "UPDATE producto SET nombre_producto = ?, descripcion = ?, updated = ?, id_categoria = ? WHERE codigo_producto = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setString(2, product.getDescription());
            pst.setTimestamp(3, datetime);
            pst.setInt(4, product.getCategory_id());
            pst.setString(5, product.getCode());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto: " + e);
            return false;
        }
    }

    /**
     * Elimina un producto de la base de datos mediante su código.
     *
     * @param productCode El código del producto a eliminar.
     * @return true si la eliminación es exitosa, false si ocurre algún error.
     */
    public boolean deleteProduct(String productCode) {
        String query = "DELETE FROM producto WHERE codigo_producto = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, productCode);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e);
            return false;
        }
    }

    /**
     * Obtiene el ID de una categoría a partir de su nombre.
     *
     * @param categoryName El nombre de la categoría.
     * @return El ID de la categoría si existe, de lo contrario, retorna -1.
     */
    public int obtainCategoryId(String categoryName) {
        String query = "SELECT id_categoria FROM categoria WHERE nombre_categoria = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, categoryName);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_categoria");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la ID de la categoría " + e);
        }

        return -1;
    }
}
