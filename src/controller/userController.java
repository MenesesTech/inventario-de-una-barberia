package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.usuario;
import model.usuarioDao;
import static model.usuarioDao.id_user;
import view.systemView;

public class userController implements ActionListener, MouseListener {

    private usuario user_employee;
    private usuarioDao user_employeeDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();

    public userController(usuario user_employee, usuarioDao user_employeeDao, systemView systemview) {
        this.user_employee = user_employee;
        this.user_employeeDao = user_employeeDao;
        this.systemview = systemview;
        //Boton Registrar
        this.systemview.btnAddUser.addActionListener(this);
        //Boton Modificar
        this.systemview.btnUpdateUser.addActionListener(this);
        //Boton Eliminar
        this.systemview.btnDeleteUser.addActionListener(this);
        //Boton Cancelar
        this.systemview.btnCancelUser.addActionListener(this);
        //Boton de actualizar contraseña
        this.systemview.btn_modify_data.addActionListener(this);
        //Tabla de usuarios
        this.systemview.tableUsers.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Método de escucha para eventos de botones en la interfaz gráfica

        if (e.getSource() == systemview.btnAddUser) {
            // Acción al hacer clic en el botón "Agregar Usuario"

            // Verificar que los campos no estén vacíos
            if (systemview.txtUsername.getText().equals("")
                    || systemview.txtPassUser.getText().equals("")
                    || systemview.txtNombreUser.getText().equals("")
                    || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Obtener datos del usuario desde la interfaz gráfica
                user_employee.setNombre(systemview.txtNombreUser.getText().trim());
                user_employee.setPassword(systemview.txtPassUser.getText().trim());
                user_employee.setRol(systemview.cmbRol.getSelectedItem().toString().trim());
                user_employee.setUsername(systemview.txtUsername.getText().trim());

                // Registrar al usuario en la base de datos
                if (user_employeeDao.registerUserQuery(user_employee)) {
                    cleanTable();
                    cleanFields();
                    ListAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el empleado");
                }
            }
        } else if (e.getSource() == systemview.btnUpdateUser) {
            // Acción al hacer clic en el botón "Actualizar Usuario"

            if (systemview.txtCodeUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                if (systemview.txtUsername.getText().equals("")
                        || systemview.txtPassUser.getText().equals("")
                        || systemview.txtNombreUser.getText().equals("")
                        || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    // Obtener datos del usuario desde la interfaz gráfica
                    user_employee.setNombre(systemview.txtNombreUser.getText().trim());
                    user_employee.setUsername(systemview.txtUsername.getText().trim());
                    user_employee.setPassword(systemview.txtPassUser.getText().trim());
                    user_employee.setRol(systemview.cmbRol.getSelectedItem().toString());
                    user_employee.setId(Integer.parseInt(systemview.txtCodeUser.getText().trim()));

                    // Actualizar los datos del usuario en la base de datos
                    if (user_employeeDao.updateUserQuery(user_employee)) {
                        cleanTable();
                        cleanFields();
                        ListAllEmployees();
                        JOptionPane.showMessageDialog(null, "Datos del empleado modificados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el empleado");
                    }
                }
            }
        } else if (e.getSource() == systemview.btnDeleteUser) {
            // Acción al hacer clic en el botón "Eliminar Usuario"

            int row = systemview.tableUsers.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para eliminar");
            } else if (systemview.tableUsers.getValueAt(row, 0).equals(id_user)) {
                JOptionPane.showMessageDialog(null, "No puedes eliminar el usuario autenticado");
            } else {
                String id = systemview.tableUsers.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿Realmente quieres eliminar a este empleado?");
                if (question == 0 && user_employeeDao.deleteUserQuery(id) != false) {
                    cleanFields();
                    cleanTable();
                    systemview.btnAddUser.setEnabled(true);
                    systemview.txtPassUser.setEnabled(true);
                    ListAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito");
                }
            }
        } else if (e.getSource() == systemview.btnCancelUser) {
            // Acción al hacer clic en el botón "Cancelar"

            cleanFields();
            systemview.btnAddUser.setEnabled(true);
            systemview.txtPassUser.setEnabled(true);
        } else if (e.getSource() == systemview.btn_modify_data) {
            // Acción al hacer clic en el botón "Modificar Contraseña"

            String password = String.valueOf(systemview.txt_password_modify.getPassword());
            String confirm_password = String.valueOf(systemview.txt_password_modify_confirm.getPassword());
            if (!password.equals("") && !confirm_password.equals("")) {
                if (password.equals(confirm_password)) {
                    // Configurar la nueva contraseña del usuario
                    user_employee.setPassword(String.valueOf(systemview.txt_password_modify.getPassword()));

                    // Actualizar la contraseña del usuario en la base de datos
                    if (user_employeeDao.updateEmployeePassword(user_employee) != false) {
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

    //Listar a los empleados
    public void ListAllEmployees() {
        List<usuario> list = user_employeeDao.listUserQuery();
        model = (DefaultTableModel) systemview.tableUsers.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNombre();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getRol();
            model.addRow(row);
        }
    }

    //Metodo para limpiar los campos de texto
    public void cleanFields() {
        systemview.txtUsername.setText("");
        systemview.txtNombreUser.setText("");
        systemview.txtPassUser.setText("");
        systemview.cmbRol.setSelectedIndex(0);
        systemview.txtCodeUser.setText("");
    }

    //Metodo para limpiar la tabla empleados
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemview.tableUsers) {
            //Capturar fila
            int row = systemview.tableUsers.rowAtPoint(e.getPoint());
            String username = systemview.tableUsers.getValueAt(row, 2).toString();
            String pass = user_employeeDao.recuperarContraseña(username);
            //Rellenar cajas de texto
            systemview.txtCodeUser.setText(systemview.tableUsers.getValueAt(row, 0).toString());
            systemview.txtNombreUser.setText(systemview.tableUsers.getValueAt(row, 1).toString());
            systemview.txtUsername.setText(systemview.tableUsers.getValueAt(row, 2).toString());
            systemview.cmbRol.setSelectedItem(systemview.tableUsers.getValueAt(row, 3).toString());
            systemview.txtPassUser.setText(pass);
            //Desabilita cajas de texto
            systemview.txtCodeUser.setEditable(false);
            systemview.btnAddUser.setEnabled(false);
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
