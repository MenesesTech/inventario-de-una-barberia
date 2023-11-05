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
import view.systemView;

public class userController implements ActionListener, MouseListener {

    private usuario user_employee;
    private usuarioDao user_employeeDao;
    private systemView systemview;
    DefaultTableModel model = new DefaultTableModel();
    String iconUsername = "";

    public userController(usuario user_employee, usuarioDao user_employeeDao, systemView systemview) {
        this.user_employee = user_employee;
        this.user_employeeDao = user_employeeDao;
        this.systemview = systemview;
        //Boton Registrar
        this.systemview.btnAddUser.addActionListener(this);
        //Boton Modificar
        this.systemview.btnUpdateUser.addActionListener(this);
        //Tabla de usuarios
        this.systemview.tableUsers.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Registrar usuario
        if (e.getSource() == systemview.btnAddUser) {
            //Verificar que los campos no esten vacios
            if (systemview.txtUsername.getText().equals("")
                    || systemview.txtPassUser.getText().equals("")
                    || systemview.txtNombreUser.getText().equals("")
                    || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                user_employee.setNombre(systemview.txtNombreUser.getText().trim());
                user_employee.setPassword(systemview.txtPassUser.getText().trim());
                user_employee.setRol(systemview.cmbRol.getSelectedItem().toString().trim());
                user_employee.setUsername(systemview.txtUsername.getText().trim());

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
            if (systemview.txtCodeUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                if (systemview.txtUsername.getText().equals("")
                        || systemview.txtPassUser.getText().equals("")
                        || systemview.txtNombreUser.getText().equals("")
                        || systemview.cmbRol.getSelectedItem().toString().equals("--- SELECCIONE ---")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    user_employee.setNombre(systemview.txtNombreUser.getText().trim());
                    user_employee.setPassword(systemview.txtPassUser.getText().trim());
                    user_employee.setRol(systemview.cmbRol.getSelectedItem().toString().trim());
                    user_employee.setUsername(systemview.txtUsername.getText().trim());
                    user_employee.setId(Integer.parseInt(systemview.txtCodeUser.getText().trim()));
                    if (user_employeeDao.updateUserQuery(user_employee)) {
                        cleanTable();
                        cleanFields();
                        ListAllEmployees();
                        JOptionPane.showMessageDialog(null, "Datos del empleado modificados con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el empleado");
                    }
                }
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
            //Rellenar cajas de texto
            systemview.txtCodeUser.setText(systemview.tableUsers.getValueAt(row, 0).toString());
            systemview.txtNombreUser.setText(systemview.tableUsers.getValueAt(row, 1).toString());
            systemview.txtUsername.setText(systemview.tableUsers.getValueAt(row, 2).toString());
            systemview.cmbRol.setSelectedItem(systemview.tableUsers.getValueAt(row, 3).toString());
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
