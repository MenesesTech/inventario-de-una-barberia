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

public class productoDao {

    //Instanciar la conexion
    conexionsql cn = new conexionsql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    // Método para registrar un producto
    public boolean registroProductQuery(producto product) {
        String query = "INSERT INTO producto (codigo_producto, nombre_producto, descripcion, cantidad, precio_venta, created, updated, id_categoria)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getCodigo());
            pst.setString(2, product.getNombre());
            pst.setString(3, product.getDescripcion());
            pst.setInt(4, product.getCantidad());
            pst.setDouble(5, product.getPventa());
            pst.setTimestamp(6, datetime);
            pst.setTimestamp(7, datetime);
            pst.setString(8, product.getCategoria());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el producto: " + e);
            return false;
        }
    }

    // Método para listar todos los productos
    public List<producto> listarProductos() {
        List<producto> productos = new ArrayList<>();
        String query = "SELECT codigo_producto, nombre_producto, descripcion, cantidad, precio_venta, id_categoria, created, updated FROM producto";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                producto product = new producto();
                product.setCodigo(rs.getString("codigo_producto"));
                product.setNombre(rs.getString("nombre_producto"));
                product.setDescripcion(rs.getString("descripcion"));
                product.setCantidad(rs.getInt("cantidad"));
                product.setPventa(rs.getDouble("precio_venta"));
                product.setCategoria(rs.getString("id_categoria"));
                product.setCreated(rs.getString("created"));
                product.setUpdated(rs.getString("updated"));
                productos.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar productos: " + e);
        }
        return productos;
    }

    // Método para actualizar un producto
    public boolean actualizarProducto(producto product) {
        String query = "UPDATE producto SET nombre_producto = ?, descripcion = ?, cantidad = ?, precio_venta = ?, id_categoria = ?, updated = ? WHERE codigo_producto = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, product.getNombre());
            pst.setString(2, product.getDescripcion());
            pst.setInt(3, product.getCantidad());
            pst.setDouble(4, product.getPventa());
            pst.setString(5, product.getCategoria());
            pst.setTimestamp(6, datetime);
            pst.setString(7, product.getCodigo());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e);
            return false;
        }
    }

    // Método para eliminar un producto por código
    public boolean eliminarProducto(String codigo) {
        String query = "DELETE FROM producto WHERE codigo_producto = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, codigo);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e);
            return false;
        }
    }

    // Método para buscar la id de la categoría
    public int categoryProducto(String category) {
        String query = "SELECT id_categoria FROM nombre_categoria WHERE nombre_categoria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_categoria");
            } else {
                JOptionPane.showMessageDialog(null, "La categoría no se encontró en la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede obtener la id de la categoría: " + e);
        }
        return -1; // Valor predeterminado para indicar un error o no encontrado
    }

}
