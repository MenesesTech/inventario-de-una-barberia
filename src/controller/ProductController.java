package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Product;
import model.ProductDao;
import view.systemView;

public class ProductController implements ActionListener, MouseListener {

    private Product product;
    private ProductDao productDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public ProductController(Product product, ProductDao productDao, systemView systemview) {
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
        //Boton de enviar a la seccion de compras
        this.systemview.btnProductCart.addMouseListener(this);
        //Tabla de Productos
        this.systemview.tableProduct.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == systemview.btnAddProduct) {
            // Verificar que los campos no estén vacíos
            if (systemview.txtNameProduct.getText().equals("")
                    || systemview.txtCodProd.getText().equals("")
                    || systemview.txaDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Obtener datos del Product desde la interfaz gráfica
                int id_category = productDao.obtainCategoryId(String.valueOf(systemview.cmbCategory.getSelectedItem()));
                product.setName(systemview.txtNameProduct.getText().trim());
                product.setCode(systemview.txtCodProd.getText().trim());
                product.setDescription(systemview.txaDescription.getText().trim());
                product.setCategory_name(String.valueOf(systemview.cmbCategory.getSelectedItem()));
                product.setCategory_id(id_category);
                // Registrar la categoria en la base de datos
                if (productDao.registerProduct(product)) {
                    cleanTable();
                    cleanFields();
                    ListAllProduct();
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el producto");
                }
            }
        } else if (e.getSource() == systemview.btnUpdateProduct) {
            if (systemview.txtCodProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                if (systemview.txtNameProduct.getText().equals("")
                        || systemview.txtCodProd.getText().equals("")
                        || systemview.txaDescription.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Obtener datos del Product desde la interfaz gráfica
                    int id_category = productDao.obtainCategoryId(String.valueOf(systemview.cmbCategory.getSelectedItem()));
                    product.setName(systemview.txtNameProduct.getText().trim());
                    product.setCode(systemview.txtCodProd.getText().trim());
                    product.setDescription(systemview.txaDescription.getText().trim());
                    product.setCategory_name(String.valueOf(systemview.cmbCategory.getSelectedItem()));
                    product.setCategory_id(id_category);
                    // Actualizar los  datos de la categoria en la base de datos
                    if (productDao.updateProduct(product)) {
                        cleanTable();
                        cleanFields();
                        ListAllProduct();
                        JOptionPane.showMessageDialog(null, "Datos del producto modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el producto");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnDeleteProduct) {
            int row = systemview.tableProduct.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una categoria para eliminar");
            } else {
                String codigoProduct = systemview.tableProduct.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar este producto?");
                if (question == 0 && productDao.deleteProduct(codigoProduct) != false) {
                    cleanFields();
                    cleanTable();
                    systemview.btnAddCategory.setEnabled(true);
                    systemview.txtCodProd.setEditable(true);
                    ListAllProduct();
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                }
            }
        } else if (e.getSource() == systemview.btnCancelProduct) {
            cleanFields();
            systemview.btnAddProduct.setEnabled(true);
            systemview.txtCodProd.setEditable(true);
        }
    }

    public void ListAllProduct() {
        List<Product> list = productDao.listProducts();
        model = (DefaultTableModel) systemview.tableProduct.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCode();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getDescription();
            row[3] = list.get(i).getQuantity();
            row[4] = list.get(i).getCreated();
            row[5] = list.get(i).getUpdated();
            row[6] = list.get(i).getCategory_name();
            model.addRow(row);
        }
    }

    //Metodo para limpiar los campos de texto
    public void cleanFields() {
        systemview.txtCodProd.setText("");
        systemview.txtNameProduct.setText("");
        systemview.txaDescription.setText("");
        systemview.txtCantProduct.setText("");
        systemview.cmbCategory.setSelectedIndex(0);
    }

    //Metodo para limpiar la tabla productos
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableProduct) {
            // Capturar fila
            int row = systemview.tableProduct.rowAtPoint(e.getPoint());
            // Rellenar cajas de texto
            systemview.txtCodProd.setText(systemview.tableProduct.getValueAt(row, 0).toString());
            systemview.txtNameProduct.setText(systemview.tableProduct.getValueAt(row, 1).toString());
            systemview.txaDescription.setText(systemview.tableProduct.getValueAt(row, 2).toString());
            systemview.txtCantProduct.setText(systemview.tableProduct.getValueAt(row, 3).toString());
            systemview.cmbCategory.setSelectedItem(systemview.tableProduct.getValueAt(row, 6).toString());
            // Deshabilitar cajas de texto
            systemview.btnAddProduct.setEnabled(false);
            systemview.txtCodProd.setEditable(false);
        } else if (e.getSource() == systemview.btnProductCart) {
            systemview.jTabbedPane1.setSelectedIndex(3);
            int row = systemview.tableProduct.getSelectedRow(); // Puedes obtener la fila seleccionada directamente
            systemview.txt_code_product_purchase.setText(systemview.tableProduct.getValueAt(row, 0).toString());
            systemview.txt_name_purchase.setText(systemview.tableProduct.getValueAt(row, 1).toString());
            cleanTable();
            cleanFields();
            ListAllProduct();
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
