package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.PurchaseDao;
import static model.EmployeeDao.id_user;
import view.systemView;

public class PurchaseController implements ActionListener, MouseListener, KeyListener {

    private Purchase purchase;
    private PurchaseDao purchaseDao;
    private int IdSupplier = 0;
    private int purchase_id = 0;
    private int item = 0;
    //private int purchase_id_aux = 0;
    private boolean aux = true;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel temp;

    public PurchaseController(Purchase purchase, PurchaseDao purchaseDao, systemView systemview) {
        this.purchase = purchase;
        this.purchaseDao = purchaseDao;
        this.systemview = systemview;
        purchase_id = purchaseDao.PurchaseId() + 1;
        this.systemview.txt_id_purchase.setText(String.valueOf(purchase_id));
        //Boton Agregar a la tabla
        this.systemview.btnaddBuy.addActionListener(this);
        //Boton Registrar Compras
        this.systemview.btnBuyProduct.addActionListener(this);
        //Boton Eliminar
        this.systemview.btnDeleteBuy.addActionListener(this);
        //Boton Cancelar
        this.systemview.btnCancelBuy.addActionListener(this);
        //Campo de entrada de Precio
        this.systemview.txt_price_purchase.addKeyListener(this);
        //Jcombobox de proveedor
        this.systemview.cmbSupplier.addMouseListener(this);
        // Deshabilitar el botón btnaddBuy al inicio
        this.systemview.btnaddBuy.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == systemview.btnaddBuy) {
            if (isFieldsComplete()) {
                // Obtener datos de los campos
                String product_name = systemview.txt_name_purchase.getText();
                int quantity = Integer.parseInt(systemview.txt_quantity_purchase.getText());
                double price = Double.parseDouble(systemview.txt_price_purchase.getText());
                String supplier_name = systemview.cmbSupplier.getSelectedItem().toString();
                Date fechaSeleccionada = systemview.fechaCaducidad.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaCaducidadStr = sdf.format(fechaSeleccionada);
                // Verificar si el producto ya está en la lista de compras
                if (isProductInTemp(product_name, supplier_name)) {
                    JOptionPane.showMessageDialog(null, "El producto ya está en la lista de compras");
                    return;
                } else {
                    temp = (DefaultTableModel) systemview.tablePurchase.getModel();
                    String currentSupplier = systemview.cmbSupplier.getSelectedItem().toString();

                    // Verificar si todos los productos son del mismo proveedor
                    for (int i = 0; i < systemview.tablePurchase.getRowCount(); i++) {
                        String existingSupplier = systemview.tablePurchase.getValueAt(i, 5).toString();
                        if (!existingSupplier.equals(currentSupplier)) {
                            JOptionPane.showMessageDialog(null, "Todos los productos deben ser del mismo proveedor");

                            aux = false;
                            return;
                        }
                    }
                    if (quantity > 0 && aux == true) {
                        aux = true;
                        // Crear lista con los datos del nuevo registro
                        ArrayList list = new ArrayList();
                        item = 1;
                        list.add(item);
                        list.add(purchase_id); //0
                        list.add(product_name); //1
                        list.add(quantity); //2
                        list.add(price); //3
                        list.add(quantity * price); //4
                        list.add(supplier_name); //5
                        list.add(fechaCaducidadStr);

                        // Crear un objeto para la nueva fila en la tabla
                        Object[] obj = new Object[7];
                        obj[0] = list.get(1);
                        obj[1] = list.get(2);
                        obj[2] = list.get(3);
                        obj[3] = list.get(4);
                        obj[4] = list.get(5);
                        obj[5] = list.get(6);
                        obj[6] = list.get(7);

                        // Agregar la nueva fila a la tabla
                        temp.addRow(obj);
                        systemview.tablePurchase.setModel(temp);

                        // Limpiar campos y configurar la interfaz para la siguiente entrada
                        cleanFieldsPurchases();
                        systemview.cmbSupplier.setEditable(false);
                        systemview.txt_code_product_purchase.requestFocus();
                        calculatePurchase();
                        systemview.btnaddBuy.setEnabled(false);
                    }

                }
            }
        } else if (e.getSource() == systemview.btnBuyProduct) {
            insertPurchase();
            systemview.txt_id_purchase.setText("");
            purchase_id = purchaseDao.PurchaseId() + 1;
            systemview.txt_id_purchase.setText(String.valueOf(purchase_id));
        }
    }
    
    private void insertPurchase() {
        double total = Double.parseDouble(systemview.txtTotal.getText());
        int employee_id = id_user;

        // Verificar la id del proveedor
        int supplierId = -1;
        for (int i = 0; i < systemview.tablePurchase.getRowCount(); i++) {
            String nameSupplier = systemview.tablePurchase.getValueAt(i, 5).toString();
            supplierId = purchaseDao.purchaseSupplierId(nameSupplier);
            // Puedes interrumpir el bucle si el supplierId es válido
            if (supplierId != -1) {
                break;
            }
        }
        
        if (supplierId != -1) {
            // Registrar la compra utilizando el mismo id_compra para todos los detalles
            if (purchaseDao.registerPurchase(supplierId, employee_id, total)) {
                for (int i = 0; i < systemview.tablePurchase.getRowCount(); i++) {
                    int purchase_id = Integer.parseInt(systemview.tablePurchase.getValueAt(i, 0).toString());
                    int product_code = purchaseDao.productPurchaseId(systemview.tablePurchase.getValueAt(i, 1).toString());
                    int purchase_quantity = Integer.parseInt(systemview.tablePurchase.getValueAt(i, 2).toString());
                    double purchase_price = Double.parseDouble(systemview.tablePurchase.getValueAt(i, 3).toString());
                    double purchase_subtotal = Double.parseDouble(systemview.tablePurchase.getValueAt(i, 4).toString());
                    String fechaCaducidadStr = systemview.tablePurchase.getValueAt(i, 6).toString();
                    
                    if (purchaseDao.registerPurchaseDetails(purchase_id, purchase_price, purchase_quantity, purchase_subtotal, product_code, fechaCaducidadStr)) {
                        System.out.println(purchase_id);
                    } else {
                        // Manejar errores si falla el registro del detalle
                        JOptionPane.showMessageDialog(null, "Error al registrar los detalles de la compra");
                        return;
                    }
                }
                cleanTableTemp();
                JOptionPane.showMessageDialog(null, "Compra generada con éxito");
                systemview.txt_code_product_purchase.requestFocus();
                cleanFieldsPurchases();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la compra");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor inválido");
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

    // Método para verificar si el producto ya está en la lista temporal
    private boolean isProductInTemp(String productName, String supplierName) {
        if (temp != null) {
            for (int i = 0; i < temp.getRowCount(); i++) {
                String existingProductName = temp.getValueAt(i, 1).toString();
                String existingSupplierName = temp.getValueAt(i, 5).toString(); // Modifiqué el índice

                if (existingProductName.equals(productName) && existingSupplierName.equals(supplierName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == systemview.txt_price_purchase || e.getSource() == systemview.txt_quantity_purchase) {
            try {
                double price = Double.parseDouble(systemview.txt_price_purchase.getText());
                int quantity = Integer.parseInt(systemview.txt_quantity_purchase.getText());
                double subtotal = quantity * price;
                systemview.txtSubtotal.setText(String.valueOf(subtotal));

                // Actualizar el campo de la ID de compra automáticamente
                systemview.txt_id_purchase.setText(String.valueOf(purchase_id + 1));

                // Verificar si todos los campos necesarios están completos
                if (isFieldsComplete()) {
                    // Habilitar el botón btnaddBuy
                    systemview.btnaddBuy.setEnabled(true);
                } else {
                    // Deshabilitar el botón btnaddBuy si no todos los campos están completos
                    systemview.btnaddBuy.setEnabled(false);
                }

            } catch (NumberFormatException ex) {
                systemview.txtSubtotal.setText("0.0");
                systemview.txt_id_purchase.setText("0");

                // Deshabilitar el botón btnaddBuy si ocurre una excepción al convertir los campos numéricos
                systemview.btnaddBuy.setEnabled(false);
            }
        }
    }

    // Método para limpiar los campos de entrada de datos en el proceso de compra
    public void cleanFieldsPurchases() {
        systemview.txt_name_purchase.setText("");
        systemview.txt_quantity_purchase.setText("");
        systemview.txt_price_purchase.setText("");
        systemview.txt_code_product_purchase.setText("");
        systemview.txtSubtotal.setText("");
        systemview.txtTotal.setText("");
        systemview.txt_id_purchase.setText("");
    }

    // Método para calcular el total a pagar en el proceso de compra
    public void calculatePurchase() {
        double total = 0.00;
        int numRow = systemview.tablePurchase.getRowCount();

        for (int i = 0; i < numRow; i++) {
            total = total + Double.parseDouble(String.valueOf(systemview.tablePurchase.getValueAt(i, 4)));
        }
        systemview.txtTotal.setText("" + total);
    }

    // Método para verificar si todos los campos necesarios están completos
    private boolean isFieldsComplete() {
        return !systemview.txt_name_purchase.getText().isEmpty()
                && !systemview.txt_price_purchase.getText().isEmpty()
                && !systemview.txt_quantity_purchase.getText().isEmpty()
                && !systemview.txt_code_product_purchase.getText().isEmpty()
                && !systemview.txtSubtotal.getText().isEmpty()
                && !systemview.txt_id_purchase.getText().isEmpty();
    }

    //Limpiar tabla temporal
    public void cleanTableTemp() {
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i = i - 1;
        }
    }
}
