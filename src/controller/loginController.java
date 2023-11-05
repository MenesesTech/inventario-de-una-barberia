package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.usuario;
import model.usuarioDao;
import view.LoginView;
import view.systemView;

public class loginController implements ActionListener {

    private usuario user_employee;
    private usuarioDao user_employeeDao;
    private LoginView loginview;

    public loginController(usuario user_employee, usuarioDao user_employeeDao, LoginView loginview) {
        this.user_employee = user_employee;
        this.user_employeeDao = user_employeeDao;
        this.loginview = loginview;
        //Boton de iniciar sesion
        this.loginview.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = loginview.txtUsername.getText().trim();
        String pass = String.valueOf(loginview.txtPassword.getPassword());
        if (e.getSource() == loginview.btnLogin) {
            if (!user.equals("") && !pass.equals("")) {
                user_employee = user_employeeDao.loginQuery(user, pass);

                if (user_employee.getUsername() != null) {
                    if (user_employee.getRol().equals("Administrador")) {
                        systemView admin = new systemView();
                        admin.setVisible(true);
                    } else {
                        systemView aux = new systemView();
                        aux.setVisible(true);
                    }
                    this.loginview.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            }
        }
    }

}
