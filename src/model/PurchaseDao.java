package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PurchaseDao {

    ConexionSql cn = new ConexionSql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Registra una compra en la base de datos
     *
     * @param supplierId
     * @param userId ID del usuario que realiza la compra
     * @param total Costo total de la compra
     * @return True si la compra se registra con éxito, false en caso contrario
     */
    public boolean registerPurchase(int supplierId, int userId, double total) {
        String query = "INSERT INTO compra (total, created, id_proveedor, id_usuario) VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setDouble(1, total);
            pst.setTimestamp(2, datetime);
            pst.setInt(3, supplierId);
            pst.setInt(4, userId);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la compra " + e);
            return false;
        }
    }

    /**
     * Registra detalles de una compra en la base de datos
     *
     * @param purchaseId ID de la compra
     * @param purchasePrice Precio de la compra
     * @param purchaseQuantity Cantidad de la compra
     * @param purchaseSubtotal Subtotal de la compra
     * @param productCode Código del producto comprado
     * @param fechaCaducidad Fecha de caducidad del producto
     * @return True si los detalles se registran con éxito, false en caso
     * contrario
     */
    public boolean registerPurchaseDetails(int purchaseId, double purchasePrice, int purchaseQuantity, double purchaseSubtotal, int productCode, String fechaCaducidad) {
        String insertQuery = "INSERT INTO compra_detalle (precio_compra, cantidad, subtotal, id_compra, id_producto) VALUES (?,?,?,?,?)";
        String updateQuery = "UPDATE producto SET caducidad = ?, cantidad = IFNULL(cantidad, 0) + ? WHERE id_producto = ?";

        try {
            conn = cn.getConnection();
            // Insertar los detalles de la compra
            pst = conn.prepareStatement(insertQuery);
            pst.setDouble(1, purchasePrice);
            pst.setInt(2, purchaseQuantity);
            pst.setDouble(3, purchaseSubtotal);
            pst.setInt(4, purchaseId);
            pst.setInt(5, productCode);
            pst.execute();

            // Actualizar la cantidad del producto y la fecha de caducidad
            pst = conn.prepareStatement(updateQuery);
            pst.setString(1, fechaCaducidad); // Establecer la fecha de caducidad como una cadena directamente
            pst.setInt(2, purchaseQuantity);
            pst.setInt(3, productCode);
            pst.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los detalles de la compra " + e);
            System.out.println(e);
            return false;
        }
    }

    public int PurchaseId() {
        int id = 0;
        String query = "SELECT MAX(id_compra) AS id FROM compra";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la ID del producto" + e);
        }
        return id;
    }

    /**
     * Obtiene el ID de un producto basado en su nombre
     *
     * @param name_product Nombre del producto
     * @return El ID del producto, o -1 si no se encuentra
     */
    public int productPurchaseId(String name_product) {
        String query = "SELECT id_producto FROM producto WHERE nombre_producto = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, name_product);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_producto");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la ID del producto" + e);
        }
        return -1;
    }

    /**
     * Obtiene el ID de un proveedor basado en su nombre
     *
     * @param nameSupplier Nombre del proveedor
     * @return El ID del proveedor, o -1 si no se encuentra
     */
    public int purchaseSupplierId(String nameSupplier) {
        String query = "SELECT id_proveedor FROM proveedor WHERE nombre = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, nameSupplier);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_proveedor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la ID del proveedor" + e);
        }
        return -1;
    }

    /**
     * Obtiene una lista de todas las compras con detalles desde la base de
     * datos
     *
     * @return Una lista de objetos Purchase que representan las compras
     */
    public List<Purchase> listPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String query = "SELECT c.id_compra, p.nombre_producto, cd.precio_compra, cd.subtotal, pv.nombre, c.created, u.nombre FROM compra c "
                + "INNER JOIN proveedor pv ON c.id_proveedor = pv.id_proveedor "
                + "INNER JOIN usuario u ON c.id_usuario = u.id_usuario "
                + "INNER JOIN compra_detalle cd ON cd.id_compra = c.id_compra "
                + "INNER JOIN producto p ON cd.id_producto = p.id_producto";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(rs.getInt("id_compra"));
                purchase.setProductName(rs.getString("nombre_producto"));
                purchase.setPrice(rs.getDouble("precio_compra"));
                purchase.setSubtotal(rs.getDouble("subtotal"));
                purchase.setSupplierName(rs.getString("nombre"));
                purchase.setCreated(rs.getString("created"));
                purchase.setUserName(rs.getString("nombre"));
                purchases.add(purchase);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al enlistar todos las compras " + e);
        }
        return purchases;
    }

    /**
     * Elimina los detalles de una compra de la base de datos.
     *
     * @param purchaseId El ID de la compra.
     * @return True si los detalles se eliminan con éxito, false en caso
     * contrario.
     */
    public boolean deletePurchaseDetails(int purchaseId) {
        String query = "DELETE FROM compra_detalle WHERE id_compra = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, purchaseId);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar los detalles de la compra: " + e);
            return false;
        }
    }

    /**
     * Elimina una compra de la base de datos
     *
     * @param purchaseId ID de la compra
     * @return True si la compra se elimina con éxito, false en caso contrario
     */
    public boolean deletePurchase(int purchaseId) {
        String query = "DELETE FROM compra WHERE id_compra = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, purchaseId);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la compra: " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de nombres de proveedores desde la base de datos para
     * usar en un combo box
     *
     * @return Una lista de objetos Purchase que representan a los proveedores
     */
    public List<Purchase> listPurchasesCombobox() {
        List<Purchase> purchases = new ArrayList<>();
        String query = "SELECT nombre FROM proveedor;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Purchase purchase = new Purchase();
                purchase.setSupplierName(rs.getString("nombre"));
                purchases.add(purchase);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return purchases;
    }

}
