package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Supplier;
import model.SupplierDao;
import view.systemView;

public class SupplierController implements ActionListener, MouseListener {

    private Supplier supplier;
    private SupplierDao supplierDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public SupplierController(Supplier supplier, SupplierDao supplierDao, systemView systemview) {
        this.supplier = supplier;
        this.supplierDao = supplierDao;
        this.systemview = systemview;
        // Boton Registrar
        this.systemview.btnAddSupplier.addActionListener(this);
        // Boton Modificar
        this.systemview.btnUpdateSupplier.addActionListener(this);
        // Boton Eliminar
        this.systemview.btnDeleteSupplier.addActionListener(this);
        // Boton Cancelar
        this.systemview.btnCancelSupplier.addActionListener(this);
        // Tabla de proveedores
        this.systemview.tableSupplier.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Registro de un nuevo proveedor
        if (e.getSource() == systemview.btnAddSupplier) {
            // Verifica si todos los campos obligatorios están llenos antes de registrar el proveedor
            if (systemview.txtNombreProveedor.getText().equals("")
                    || systemview.txtDireccionProveedor.getText().equals("")
                    || systemview.txtCorreoProveedor.getText().equals("")
                    || systemview.txtTelefonoProveedor.getText().equals("")
                    || systemview.txtDescripcionProveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Asigna los valores a las propiedades del proveedor
                supplier.setName(systemview.txtNombreProveedor.getText().trim());
                supplier.setAddress(systemview.txtDireccionProveedor.getText().trim());
                supplier.setEmail(systemview.txtCorreoProveedor.getText().trim());
                supplier.setTelephone(systemview.txtTelefonoProveedor.getText().trim());
                supplier.setDescription(systemview.txtDescripcionProveedor.getText().trim());

                // Registra al proveedor y actualiza la interfaz gráfica
                if (supplierDao.registerSupplier(supplier)) {
                    cleanTable();
                    cleanFields();
                    ListAllSuppliers();
                    JcomboBoxSupplier();
                    JOptionPane.showMessageDialog(null, "Proveedor registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el proveedor");
                }
            }
        } // Actualización de un proveedor existente
        else if (e.getSource() == systemview.btnUpdateSupplier) {
            // Verifica si se ha seleccionado una fila para actualizar
            if (systemview.txtIdSupplier.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                // Verifica si todos los campos obligatorios están llenos antes de actualizar el proveedor
                if (systemview.txtNombreProveedor.getText().equals("")
                        || systemview.txtDireccionProveedor.getText().equals("")
                        || systemview.txtCorreoProveedor.getText().equals("")
                        || systemview.txtTelefonoProveedor.getText().equals("")
                        || systemview.txtDescripcionProveedor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Asigna los valores a las propiedades del proveedor
                    supplier.setName(systemview.txtNombreProveedor.getText().trim());
                    supplier.setAddress(systemview.txtDireccionProveedor.getText().trim());
                    supplier.setEmail(systemview.txtCorreoProveedor.getText().trim());
                    supplier.setTelephone(systemview.txtTelefonoProveedor.getText().trim());
                    supplier.setDescription(systemview.txtDescripcionProveedor.getText().trim());

                    // Actualiza los datos del proveedor y actualiza la interfaz gráfica
                    if (supplierDao.updateSupplier(supplier)) {
                        cleanTable();
                        cleanFields();
                        ListAllSuppliers();
                        JOptionPane.showMessageDialog(null, "Datos del proveedor modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el proveedor");
                    }
                }
            }
        } // Eliminación de un proveedor existente
        else if (e.getSource() == systemview.btnDeleteSupplier) {
            // Obtiene la fila seleccionada
            int row = systemview.tableSupplier.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un proveedor para eliminar");
            } else {
                // Obtiene el ID del proveedor a eliminar
                int id = Integer.parseInt(systemview.tableSupplier.getValueAt(row, 0).toString());

                // Pregunta al usuario antes de eliminar y procede si la respuesta es afirmativa
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar este proveedor?");
                if (question == 0 && supplierDao.deleteSupplier(id)) {
                    cleanFields();
                    cleanTable();
                    systemview.btnAddSupplier.setEnabled(true);
                    ListAllSuppliers();
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito");
                }
            }
        } // Cancelación de la operación
        else if (e.getSource() == systemview.btnCancelSupplier) {
            cleanFields();
            systemview.btnAddSupplier.setEnabled(true);
        }
    }

    // Método para listar todos los proveedores
    public void ListAllSuppliers() {
        List<Supplier> list = supplierDao.listSuppliers();
        model = (DefaultTableModel) systemview.tableSupplier.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getDescription();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getTelephone();
            row[5] = list.get(i).getEmail();
            model.addRow(row);
        }
    }

    // Método para limpiar los campos
    public void cleanFields() {
        systemview.txtIdSupplier.setText("");
        systemview.txtNombreProveedor.setText("");
        systemview.txtDescripcionProveedor.setText("");
        systemview.txtDireccionProveedor.setText("");
        systemview.txtTelefonoProveedor.setText("");
        systemview.txtCorreoProveedor.setText("");
    }

    // Método para limpiar la tabla
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    // Rellenar JComboBox de proveedores
    public void JcomboBoxSupplier() {
        List<Supplier> lista = supplierDao.listSupplierComboBox();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i).getName());
        }
        systemview.cmbSupplier.setModel(model);
    }

    /**
     * Controlador de eventos cuando se hace clic en la tabla Proveedores
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableSupplier) {
            int row = systemview.tableSupplier.rowAtPoint(e.getPoint());
            systemview.txtIdSupplier.setText(systemview.tableSupplier.getValueAt(row, 0).toString());
            systemview.txtNombreProveedor.setText(systemview.tableSupplier.getValueAt(row, 1).toString());
            systemview.txtDescripcionProveedor.setText(systemview.tableSupplier.getValueAt(row, 2).toString());
            systemview.txtDireccionProveedor.setText(systemview.tableSupplier.getValueAt(row, 3).toString());
            systemview.txtTelefonoProveedor.setText(systemview.tableSupplier.getValueAt(row, 4).toString());
            systemview.txtCorreoProveedor.setText(systemview.tableSupplier.getValueAt(row, 5).toString());
            systemview.btnAddSupplier.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
