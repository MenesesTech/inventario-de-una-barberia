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

public class SupplierDao {

    ConexionSql cn = new ConexionSql();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Registra un proveedor en la base de datos
     *
     * @param supplier El objeto Supplier a registrar
     * @return True si el registro fue exitoso, False en caso contrario
     */
    public boolean registerSupplier(Supplier supplier) {
        String query = "INSERT INTO proveedor (nombre, descripcion, direccion, telefono, correo, created, updated) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getDescription());
            pst.setString(3, supplier.getAddress());
            pst.setString(4, supplier.getTelephone());
            pst.setString(5, supplier.getEmail());
            pst.setTimestamp(6, datetime);
            pst.setTimestamp(7, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el proveedor: " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de todos los proveedores almacenados en la base de
     * datos
     *
     * @return La lista de proveedores
     */
    public List<Supplier> listSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT id_proveedor, nombre, descripcion, direccion, telefono, correo, created, updated FROM proveedor";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setId(rs.getInt("id_proveedor"));
                supplier.setName(rs.getString("nombre"));
                supplier.setDescription(rs.getString("descripcion"));
                supplier.setAddress(rs.getString("direccion"));
                supplier.setTelephone(rs.getString("telefono"));
                supplier.setEmail(rs.getString("correo"));
                supplier.setCreated(rs.getString("created"));
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar proveedores: " + e);
        }
        return suppliers;
    }

    /**
     * Actualiza la información de un proveedor en la base de datos
     *
     * @param supplier El objeto Supplier con la información actualizada
     * @return True si la actualización fue exitosa, False en caso contrario
     */
    public boolean updateSupplier(Supplier supplier) {
        String query = "UPDATE proveedor SET nombre = ?, descripcion = ?, direccion = ?, telefono = ?, correo = ?, updated = ? WHERE id_proveedor = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getDescription());
            pst.setString(3, supplier.getAddress());
            pst.setString(4, supplier.getTelephone());
            pst.setString(5, supplier.getEmail());
            pst.setTimestamp(6, datetime);
            pst.setInt(7, supplier.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor: " + e);
            return false;
        }
    }

    /**
     * Elimina un proveedor de la base de datos mediante su ID
     *
     * @param idProveedor El ID del proveedor a eliminar
     * @return True si la eliminación fue exitosa, False en caso contrario
     */
    public boolean deleteSupplier(int idProveedor) {
        String query = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, idProveedor);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de proveedores para usar en un ComboBox.
     *
     * @return La lista de proveedores.
     */
    public List<Supplier> listSupplierComboBox() {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT nombre FROM proveedor;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setName(rs.getString("nombre"));
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return suppliers;
    }

}
