package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.producto;
import model.productoDao;
import view.systemView;

public class ProductController implements ActionListener, MouseListener {

    private producto product;
    private productoDao productDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public ProductController(producto product, productoDao productDao, systemView systemview) {
        this.product = product;
        this.productDao = productDao;
        this.systemview = systemview;
        //Boton Registrar
        this.systemview.btnAddProduct.addActionListener(this);
        //Boton Modificar
        this.systemview.btnUpdateProduct.addActionListener(this);
        //Boton Eliminar
        this.systemview.btnDeleteProduct.addActionListener(this);
        //Boton Cancelar
        this.systemview.btnCancelProduct.addActionListener(this);
        //Tabla de categorias
        this.systemview.tableProduct.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == systemview.btnAddProduct) {
            // Acción al hacer clic en el botón "Agregar Producto"

            // Verificar que los campos no estén vacíos
            if (systemview.txtNameProduct.getText().isEmpty()
                    || systemview.txtPrecioVenta.getText().isEmpty()
                    || systemview.txtCantProduct.getText().isEmpty()
                    || systemview.cmbCategory.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Obtener datos del producto desde la interfaz gráfica
                product.setCodigo(systemview.txtCodProd.getText().trim());
                product.setNombre(systemview.txtNameProduct.getText().trim());
                product.setDescripcion(systemview.txaDescription.getText().trim());
                product.setCantidad(Integer.parseInt(systemview.txtCantProduct.getText().trim()));
                product.setPventa(Double.parseDouble(systemview.txtPrecioVenta.getText()));
                product.setCategoria(systemview.cmbCategory.getSelectedItem().toString().trim());

                // Registrar el producto en la base de datos
                if (productDao.registroProductQuery(product)) {
                    cleanTable();
                    cleanFields();
                    ListAllProducts();
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el producto");
                }
            }
        } else if (e.getSource() == systemview.btnUpdateProduct) {
            // Acción al hacer clic en el botón "Modificar Producto"

            if (systemview.txtCodProd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para continuar");
            } else {
                if (systemview.txtNameProduct.getText().isEmpty()
                        || systemview.txtPrecioVenta.getText().isEmpty()
                        || systemview.txtCantProduct.getText().isEmpty()
                        || systemview.cmbCategory.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Obtener datos del producto desde la interfaz gráfica
                    product.setCodigo(systemview.txtCodProd.getText().trim());
                    product.setNombre(systemview.txtNameProduct.getText().trim());
                    product.setDescripcion(systemview.txaDescription.getText().trim());
                    product.setCantidad(Integer.parseInt(systemview.txtCantProduct.getText().trim()));
                    product.setPventa(Double.parseDouble(systemview.txtPrecioVenta.getText()));
                    product.setCategoria(systemview.cmbCategory.getSelectedItem().toString().trim());

                    // Actualizar los datos del producto en la base de datos
                    if (productDao.actualizarProducto(product)) {
                        cleanTable();
                        cleanFields();
                        ListAllProducts();
                        JOptionPane.showMessageDialog(null, "Datos del producto modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el producto");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnDeleteProduct) {
            // Acción al hacer clic en el botón "Eliminar Producto"

            int row = systemview.tableProduct.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un producto para eliminar");
            } else {
                String codigo = systemview.tableProduct.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar este producto?");
                if (question == 0 && productDao.eliminarProducto(codigo)) {
                    cleanFields();
                    cleanTable();
                    systemview.btnAddProduct.setEnabled(true);
                    ListAllProducts();
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                }
            }
        } else if (e.getSource() == systemview.btnCancelProduct) {
            // Acción al hacer clic en el botón "Cancelar"
            cleanFields();
            systemview.btnAddProduct.setEnabled(true);
        }
    }

    // Método para listar todos los productos
    public void ListAllProducts() {
        List<producto> list = productDao.listarProductos();
        model = (DefaultTableModel) systemview.tableProduct.getModel();
        Object[] row = new Object[7]; // Ajusta el número de columnas según tus necesidades
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCodigo();
            row[1] = list.get(i).getNombre();
            row[2] = list.get(i).getDescripcion();
            row[3] = list.get(i).getCantidad();
            row[4] = list.get(i).getPventa();
            row[5] = list.get(i).getCreated();
            row[6] = list.get(i).getUpdated();
            model.addRow(row);
        }
    }
    // Método para limpiar los campos de texto

    public void cleanFields() {
        systemview.txtCodProd.setText("");
        systemview.txtNameProduct.setText("");
        systemview.txaDescription.setText("");
        systemview.txtCantProduct.setText("");
        systemview.txtPrecioVenta.setText("");
        systemview.cmbCategory.setSelectedIndex(0); // Ajusta según tu JComboBox
    }

// Método para limpiar la tabla de productos
    public void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) systemview.tableProduct.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableProduct) {
            int row = systemview.tableProduct.rowAtPoint(e.getPoint());

            if (row >= 0) {
                // Rellenar cajas de texto y área de texto
                systemview.txtCodProd.setText(systemview.tableProduct.getValueAt(row, 0).toString());
                systemview.txtNameProduct.setText(systemview.tableProduct.getValueAt(row, 1).toString());
                systemview.txaDescription.setText(systemview.tableProduct.getValueAt(row, 2).toString());
                systemview.txtCantProduct.setText(systemview.tableProduct.getValueAt(row, 3).toString());
                systemview.txtPrecioVenta.setText(systemview.tableProduct.getValueAt(row, 4).toString());
                String selectedCategory = systemview.tableProduct.getValueAt(row, 5).toString();
                systemview.cmbCategory.setSelectedItem(selectedCategory);
            }
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
