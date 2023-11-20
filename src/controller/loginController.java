package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Employee;
import model.EmployeeDao;
import view.LoginView;
import view.systemView;

public class LoginController implements ActionListener {

    private Employee employee;
    private EmployeeDao employeeDao;
    private LoginView loginview;

    public LoginController(Employee employee, EmployeeDao employeeDao, LoginView loginview) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.loginview = loginview;
        //Boton de iniciar sesion
        this.loginview.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtiene el nombre de usuario y la contraseña ingresados
        String user = loginview.txtUsername.getText().trim();
        String pass = String.valueOf(loginview.txtPassword.getPassword());

        // Verifica si el evento proviene del botón de inicio de sesión
        if (e.getSource() == loginview.btnLogin) {
            // Verifica que ambos campos de entrada no estén vacíos
            if (!user.equals("") && !pass.equals("")) {
                // Realiza la operación de inicio de sesión a través del DAO de empleados
                employee = employeeDao.loginQuery(user, pass);

                // Verifica si se ha encontrado un usuario correspondiente a las credenciales ingresadas
                if (employee.getUsername() != null) {
                    // Abre la interfaz correspondiente según el rol del empleado
                    if (employee.getRol().equals("Administrador")) {
                        systemView admin = new systemView();
                        admin.setVisible(true);
                        admin.jLabel23.setVisible(true);
                        admin.opcUsers.setVisible(true);
                    } else {
                        systemView aux = new systemView();
                        aux.setVisible(true);
                        aux.jLabel23.setVisible(false);
                        aux.opcUsers.setEnabled(false);
                        aux.opcUsers.setVisible(false);
                        aux.opcUsers.setOpaque(false);
                    }

                    // Cierra la interfaz de inicio de sesión
                    this.loginview.dispose();
                } else {
                    // Muestra un mensaje de error en caso de credenciales incorrectas
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                }
            } else {
                // Muestra un mensaje si alguno de los campos está vacío
                JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            }
        }
    }
}
