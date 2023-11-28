package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.CategoryDao;
import view.systemView;

public class CategoryController implements ActionListener, MouseListener {

    private Category category;
    private CategoryDao categoryDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public CategoryController(Category category, CategoryDao categoryDao, systemView systemview) {
        this.category = category;
        this.categoryDao = categoryDao;
        this.systemview = systemview;
        //Boton Registrar
        this.systemview.btnAddCategory.addActionListener(this);
        //Boton Modificar
        this.systemview.btnUpdateCategory.addActionListener(this);
        //Boton Eliminar
        this.systemview.btnDeleteCategory.addActionListener(this);
        //Boton Cancelar
        this.systemview.btnCancelCategory.addActionListener(this);
        //Tabla de categorias
        this.systemview.tableCategory.addMouseListener(this);
        //Jcombobox de Category
        this.systemview.cmbCategory.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Método de escucha para eventos de botones en la interfaz gráfica

        if (e.getSource() == systemview.btnAddCategory) {
            // Acción al hacer clic en el botón "Agregar Category"

            // Verificar que los campos no estén vacíos
            if (systemview.txtNameCategory.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Obtener datos de la Category desde la interfaz gráfica
                category.setName(systemview.txtNameCategory.getText().trim());

                // Registrar la Category en la base de datos
                if (categoryDao.registerCategoryQuery(category)) {
                    cleanTable();
                    cleanFields();
                    ListAllCategory();
                    JcomboBoxCategory();
                    JOptionPane.showMessageDialog(null, "Categoria registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar la categoria");
                }
            }
        } else if (e.getSource() == systemview.btnUpdateCategory) {
            // Acción al hacer clic en el botón "Actualizar Usuario"

            if (systemview.txtIdcategory.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                if (systemview.txtNameCategory.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Obtener datos de la Category desde la interfaz gráfica
                    category.setName(systemview.txtNameEmployee.getText().trim());

                    // Actualizar los  datos de la Category en la base de datos
                    if (categoryDao.updateCategory(category)) {
                        cleanTable();
                        cleanFields();
                        ListAllCategory();
                        JcomboBoxCategory();
                        JOptionPane.showMessageDialog(null, "Datos de la categoria modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la categoria");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnDeleteCategory) {
            // Acción al hacer clic en el botón "Eliminar Categoria"

            int row = systemview.tableCategory.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una categoria para eliminar");
            } else {
                String id = systemview.tableCategory.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar esta categoria?");
                if (question == 0 && categoryDao.deleteCategory(id) != false) {
                    cleanFields();
                    cleanTable();
                    systemview.btnAddCategory.setEnabled(true);
                    ListAllCategory();
                    JOptionPane.showMessageDialog(null, "Categoria eliminado con éxito");
                }
            }
        } else if (e.getSource() == systemview.btnCancelCategory) {
            // Acción al hacer clic en el botón "Cancelar"

            cleanFields();
            systemview.btnAddCategory.setEnabled(true);
        }
    }

    //Listar a las categorias
    public void ListAllCategory() {
        List<Category> list = categoryDao.listCategories();
        model = (DefaultTableModel) systemview.tableCategory.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            model.addRow(row);
        }
    }

    //Metodo para limpiar los campos de texto
    public void cleanFields() {
        systemview.txtIdcategory.setText("");
        systemview.txtNameCategory.setText("");
    }

    //Metodo para limpiar la tabla empleados
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    // Rellenar JComboBox de categorías
    public void JcomboBoxCategory() {
        List<Category> lista = categoryDao.listCategoriesCombobox();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i).getName());
        }
        systemview.cmbCategory.setModel(model);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableCategory) {
            //Capturar fila
            int row = systemview.tableCategory.rowAtPoint(e.getPoint());
            //Rellenar cajas de texto
            systemview.txtIdcategory.setText(systemview.tableCategory.getValueAt(row, 0).toString());
            systemview.txtNameCategory.setText(systemview.tableCategory.getValueAt(row, 1).toString());
            //Desabilita cajas de texto
            systemview.btnAddCategory.setEnabled(false);
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
