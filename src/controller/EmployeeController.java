package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.EmployeeDao;
import static model.EmployeeDao.id_user;
import view.systemView;

public class EmployeeController implements ActionListener, MouseListener {

    private Employee employee;
    private EmployeeDao employeeDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public EmployeeController(Employee employee, EmployeeDao employeeDao, systemView systemview) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.systemview = systemview;
        //Boton Registrar
        this.systemview.btnAddEmployee.addActionListener(this);
        //Boton Modificar
        this.systemview.btnUpdateEmployee.addActionListener(this);
        //Boton Eliminar
        this.systemview.btnDeleteEmployee.addActionListener(this);
        //Boton Cancelar
        this.systemview.btnCancelEmployee.addActionListener(this);
        //Boton de actualizar contraseña
        this.systemview.btn_modify_data.addActionListener(this);
        //Tabla de usuarios
        this.systemview.tableEmployees.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == systemview.btnAddEmployee) {
            // Verifica si los campos obligatorios están llenos antes de registrar un empleado
            if (systemview.txtUsername.getText().equals("")
                    || systemview.txtPasswordEmployee.getText().equals("")
                    || systemview.txtNameEmployee.getText().equals("")
                    || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Asigna los valores a las propiedades del empleado
                employee.setName(systemview.txtNameEmployee.getText().trim());
                employee.setPassword(systemview.txtPasswordEmployee.getText().trim());
                employee.setRol(systemview.cmbRol.getSelectedItem().toString().trim());
                employee.setUsername(systemview.txtUsername.getText().trim());

                // Registra al empleado y actualiza la interfaz grafica
                if (employeeDao.registerUserQuery(employee)) {
                    cleanTable();
                    cleanFields();
                    ListAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el empleado");
                }
            }
        } else if (e.getSource() == systemview.btnUpdateEmployee) {
            // Verifica si se ha seleccionado una fila antes de intentar actualizar un empleado
            if (systemview.txtCodeEmployee.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                // Verifica si los campos obligatorios están llenos antes de actualizar un empleado
                if (systemview.txtUsername.getText().equals("")
                        || systemview.txtPasswordEmployee.getText().equals("")
                        || systemview.txtNameEmployee.getText().equals("")
                        || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Asigna los valores a las propiedades del empleado
                    employee.setName(systemview.txtNameEmployee.getText().trim());
                    employee.setUsername(systemview.txtUsername.getText().trim());
                    employee.setPassword(systemview.txtPasswordEmployee.getText().trim());
                    employee.setRol(systemview.cmbRol.getSelectedItem().toString());
                    employee.setId(Integer.parseInt(systemview.txtCodeEmployee.getText().trim()));

                    // Actualiza al empleado y actualiza la interfaz gráfica
                    if (employeeDao.updateUserQuery(employee)) {
                        cleanTable();
                        cleanFields();
                        ListAllEmployees();
                        JOptionPane.showMessageDialog(null, "Datos del empleado modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el empleado");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnDeleteEmployee) {
            // Obtiene la fila seleccionada en la tabla
            int row = systemview.tableEmployees.getSelectedRow();
            // Verifica si se ha seleccionado alguna fila
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para eliminar");
            } else if (systemview.tableEmployees.getValueAt(row, 0).equals(id_user)) {
                // Verifica si el usuario autenticado intenta eliminarse a sí mismo
                JOptionPane.showMessageDialog(null, "No puedes eliminar el usuario autenticado");
            } else {
                // Obtiene el ID del empleado a eliminar
                String id = systemview.tableEmployees.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar a este empleado?");
                // Solicita confirmación al usuario para eliminar al empleado
                if (question == 0 && employeeDao.deleteUserQuery(id) != false) {
                    // Limpia los campos y la tabla, habilita el botón de agregar y la contraseña
                    cleanFields();
                    cleanTable();
                    systemview.btnAddEmployee.setEnabled(true);
                    systemview.txtPasswordEmployee.setEnabled(true);
                    ListAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito");
                }
            }
        } else if (e.getSource() == systemview.btnCancelEmployee) {
            // Limpia los campos y habilita el botón de agregar y la contraseña
            cleanFields();
            systemview.btnAddEmployee.setEnabled(true);
            systemview.txtPasswordEmployee.setEnabled(true);
        } else if (e.getSource() == systemview.btn_modify_data) {
            // Obtiene la nueva contraseña y su confirmación
            String password = String.valueOf(systemview.txt_password_modify.getPassword());
            String confirm_password = String.valueOf(systemview.txt_password_modify_confirm.getPassword());
            // Verifica que ambos campos de contraseña no estén vacíos
            if (!password.equals("") && !confirm_password.equals("")) {
                // Verifica si las contraseñas coinciden
                if (password.equals(confirm_password)) {
                    // Actualiza la contraseña del empleado y actualiza
                    employee.setPassword(String.valueOf(systemview.txt_password_modify.getPassword()));
                    if (employeeDao.updateEmployeePassword(employee) != false) {
                        cleanTable();
                        ListAllEmployees();
                        JOptionPane.showMessageDialog(null, "Contraseña modificada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
        }
    }

    // Método para listar todos los empleados
    public void ListAllEmployees() {
        List<Employee> list = employeeDao.listUserQuery();
        model = (DefaultTableModel) systemview.tableEmployees.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getRol();
            model.addRow(row);
        }
    }

    // Método para limpiar los campos
    public void cleanFields() {
        systemview.txtUsername.setText("");
        systemview.txtNameEmployee.setText("");
        systemview.txtPasswordEmployee.setText("");
        systemview.cmbRol.setSelectedIndex(0);
        systemview.txtCodeEmployee.setText("");
    }
    
    // Método para limpiar la tabla
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * Controlador de eventos cuando se hace clic en la tabla empleados
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableEmployees) {
            int row = systemview.tableEmployees.rowAtPoint(e.getPoint());
            String username = systemview.tableEmployees.getValueAt(row, 2).toString();
            String pass = employeeDao.retrievePassword(username);
            systemview.txtCodeEmployee.setText(systemview.tableEmployees.getValueAt(row, 0).toString());
            systemview.txtNameEmployee.setText(systemview.tableEmployees.getValueAt(row, 1).toString());
            systemview.txtUsername.setText(systemview.tableEmployees.getValueAt(row, 2).toString());
            systemview.cmbRol.setSelectedItem(systemview.tableEmployees.getValueAt(row, 3).toString());
            systemview.txtPasswordEmployee.setText(pass);
            systemview.txtCodeEmployee.setEditable(false);
            systemview.btnAddEmployee.setEnabled(false);
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
