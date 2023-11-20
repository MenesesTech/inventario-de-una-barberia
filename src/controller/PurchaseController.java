package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.PurchaseDao;
import static model.EmployeeDao.id_user;
import view.systemView;

public class PurchaseController implements ActionListener, MouseListener, KeyListener {

    private Purchase purchase;
    private PurchaseDao purchaseDao;
    private int getIdSupplier = 0;
    private int item = 0;
    private int purchase_id = 0;
    private int purchase_id_aux = 0;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel temp;

    public PurchaseController(Purchase purchase, PurchaseDao purchaseDao, systemView systemview) {
        this.purchase = purchase;
        this.purchaseDao = purchaseDao;
        this.systemview = systemview;
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
            int supplierId = purchaseDao.purchaseSupplierId(String.valueOf(systemview.cmbSupplier.getSelectedItem().toString()));
            if (getIdSupplier == 0) {
                getIdSupplier = supplierId;
            } else {
                if (getIdSupplier != supplierId) {
                    JOptionPane.showMessageDialog(null, "No se puede realizar una misma compra a varios proveedores");
                } else {
                    String product_name = systemview.txt_name_purchase.getText();
                    double price = Double.parseDouble(systemview.txt_price_purchase.getText());

                    // Verificar si todos los campos necesarios están completos
                    if (isFieldsComplete()) {
                        int quantity = Integer.parseInt(systemview.txt_quantity_purchase.getText());
                        purchase_id_aux = Integer.parseInt(systemview.txt_id_purchase.getText());
                        String supplier_name = systemview.cmbSupplier.getSelectedItem().toString();

                        if (quantity > 0) {
                            temp = (DefaultTableModel) systemview.tablePurchase.getModel();

                            // Verificar si el producto ya está registrado en la tabla de compras para el mismo proveedor
                            for (int i = 0; i < systemview.tablePurchase.getRowCount(); i++) {
                                String existingProductName = systemview.tablePurchase.getValueAt(i, 1).toString();

                                if (existingProductName.equals(product_name)) {
                                    JOptionPane.showMessageDialog(null, "El producto ya está registrado en la tabla de compras");
                                    return;
                                }
                            }
                            // Crear lista con los datos del nuevo registro
                            ArrayList list = new ArrayList();
                            item = 1;
                            list.add(item);
                            list.add(purchase_id_aux);
                            list.add(product_name);
                            list.add(quantity);
                            list.add(price);
                            list.add(quantity * price);
                            list.add(supplier_name);

                            // Crear un objeto para la nueva fila en la tabla
                            Object[] obj = new Object[6];
                            obj[0] = list.get(1);
                            obj[1] = list.get(2);
                            obj[2] = list.get(3);
                            obj[3] = list.get(4);
                            obj[4] = list.get(5);
                            obj[5] = list.get(6);

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
                    } else {
                        JOptionPane.showMessageDialog(null, "Completa todos los campos antes de agregar a la tabla");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnBuyProduct) {
            purchase_id_aux = 0;
            insertPurchase();
        }

    }
    private void insertPurchase(){
        double total = Double.parseDouble(systemview.txtTotal.getText());
        int employee_id = id_user;
        purchase_id = purchaseDao.PurchaseId()+1;
        if (purchaseDao.registerPurchase(getIdSupplier, employee_id, total)) {
            for (int i = 0; i < systemview.tablePurchase.getRowCount(); i++) {
                int product_code = purchaseDao.productPurchaseId(systemview.tablePurchase.getValueAt(i, 1).toString());
                int purchase_quantity = Integer.parseInt(systemview.tablePurchase.getValueAt(i, 2).toString());
                double purchase_price = Double.parseDouble(systemview.tablePurchase.getValueAt(i, 3).toString());
                double purchase_subtotal = Double.parseDouble(systemview.tablePurchase.getValueAt(i, 4).toString());
                
                //Registrar detalles de la compra
                purchaseDao.registerPurchaseDetails(purchase_id, purchase_price, purchase_quantity, purchase_subtotal, product_code);
            }
            cleanTableTemp();
            JOptionPane.showMessageDialog(null, "Compra generada con exito");
            cleanFieldsPurchases();
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
                systemview.txt_id_purchase.setText(String.valueOf(purchase_id_aux + 1));

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
    public void cleanTableTemp(){
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i = i - 1;
        }
    }
}
