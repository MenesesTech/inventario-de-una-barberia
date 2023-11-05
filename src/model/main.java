package model;

import view.LoginView;
import view.systemView;

public class main {

    public static void main(String[] args) {
//        conexionsql conect = new conexionsql();
//        conect.getConnection();
        LoginView login = new LoginView();
        systemView system = new systemView();
        login.setVisible(true);
    }
}
