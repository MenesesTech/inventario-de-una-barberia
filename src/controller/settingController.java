package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.systemView;

public class settingController implements MouseListener {

    private systemView system;

    public settingController(systemView system) {
        this.system = system;
        this.system.jLabel1.addMouseListener(this);
        this.system.jLabel2.addMouseListener(this);
        this.system.jLabel20.addMouseListener(this);
        this.system.jLabel21.addMouseListener(this);
        this.system.jLabel22.addMouseListener(this);
        this.system.jLabel23.addMouseListener(this);
        this.system.jLabel24.addMouseListener(this);
        this.system.pnlUser.addMouseListener(this);
        this.system.lblLogout.addMouseListener(this);
        this.system.lblNewPass.addMouseListener(this);
        this.system.jTabbedPane1.addMouseListener(this);
        //Botones de Dashboard
        this.system.opDash.addMouseListener(this);
        this.system.opProduct.addMouseListener(this);
        this.system.opcCategoria.addMouseListener(this);
        this.system.opcShop.addMouseListener(this);
        this.system.opcProv.addMouseListener(this);
        this.system.opcUsers.addMouseListener(this);
        this.system.opcInformes.addMouseListener(this);
        //Panel de usuario
        system.pnlUserSetting.setVisible(false);
        // Titulo Principal
        system.lblItem.setText("MENÚ PRINCIPAL");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == system.jLabel1 || e.getSource() == system.opDash) {
            system.jTabbedPane1.setSelectedIndex(0);
            system.lblItem.setText("MENÚ PRINCIPAL");
        } else if (e.getSource() == system.jLabel2 || e.getSource() == system.opProduct) {
            system.jTabbedPane1.setSelectedIndex(1);
            system.lblItem.setText("PRODUCTOS");
        } else if (e.getSource() == system.jLabel20 || e.getSource() == system.opcCategoria) {
            system.jTabbedPane1.setSelectedIndex(2);
            system.lblItem.setText("CATEGORIAS");
        } else if (e.getSource() == system.jLabel21 || e.getSource() == system.opcShop) {
            system.jTabbedPane1.setSelectedIndex(3);
            system.lblItem.setText("COMPRAS");
        } else if (e.getSource() == system.jLabel22 || e.getSource() == system.opcProv) {
            system.jTabbedPane1.setSelectedIndex(4);
            system.lblItem.setText("PROVEEDORES");
        } else if (e.getSource() == system.jLabel23 || e.getSource() == system.opcUsers) {
            system.jTabbedPane1.setSelectedIndex(5);
            system.lblItem.setText("USUARIOS");
        } else if (e.getSource() == system.jLabel24 || e.getSource() == system.opcInformes) {
            system.jTabbedPane1.setSelectedIndex(6);
            system.lblItem.setText("INFORMES");
        }else if (e.getSource() == system.lblNewPass) {
            system.jTabbedPane1.setSelectedIndex(7);
            system.lblItem.setText("CAMBIAR CONTRASEÑA");
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
        if (e.getSource() == system.jLabel1) {
            system.pnl_Home.setBackground(new Color(69, 78, 95));
            system.pnl_Home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel2) {
            system.pnl_Producto.setBackground(new Color(69, 78, 95));
            system.pnl_Producto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel20) {
            system.pnl_Categoria.setBackground(new Color(69, 78, 95));
            system.pnl_Categoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel21) {
            system.pnl_Compra.setBackground(new Color(69, 78, 95));
            system.pnl_Compra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel22) {
            system.pnl_Prov.setBackground(new Color(69, 78, 95));
            system.pnl_Prov.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel23) {
            system.pnl_User.setBackground(new Color(69, 78, 95));
            system.pnl_User.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.jLabel24) {
            system.pnl_Informe.setBackground(new Color(69, 78, 95));
            system.pnl_Informe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.pnlUser) {
            system.pnlUserSetting.setVisible(true);
        } else if (e.getSource() == system.lblLogout) {
            system.pnlUserSetting.setVisible(true);
            system.pnlExit.setBackground(new Color(69, 78, 95));
            system.pnlExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.lblNewPass) {
            system.pnlUserSetting.setVisible(true);
            system.pnlNewPass.setBackground(new Color(69, 78, 95));
            system.pnlNewPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //Botones de Dashboard
        } else if (e.getSource() == system.opDash) {
            system.btnDashboard.setBackground(new Color(153, 153, 153));
            system.btnDashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opProduct) {
            system.btnProduct.setBackground(new Color(153, 153, 153));
            system.btnProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opcCategoria) {
            system.btnCategoria.setBackground(new Color(153, 153, 153));
            system.btnCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opcShop) {
            system.btnCompras.setBackground(new Color(153, 153, 153));
            system.btnCompras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opcProv) {
            system.btnProveedor.setBackground(new Color(153, 153, 153));
            system.btnProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opcUsers) {
            system.btnUsers.setBackground(new Color(153, 153, 153));
            system.btnUsers.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == system.opcInformes) {
            system.btnReport.setBackground(new Color(153, 153, 153));
            system.btnReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == system.jLabel1) {
            system.pnl_Home.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel2) {
            system.pnl_Producto.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel20) {
            system.pnl_Categoria.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel21) {
            system.pnl_Compra.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel22) {
            system.pnl_Prov.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel23) {
            system.pnl_User.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.jLabel24) {
            system.pnl_Informe.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.pnlUser) {
            system.pnlUserSetting.setVisible(false);
        } else if (e.getSource() == system.lblLogout) {
            system.pnlUserSetting.setVisible(false);
            system.pnlExit.setBackground(new Color(54, 63, 77));
        } else if (e.getSource() == system.lblNewPass) {
            system.pnlUserSetting.setVisible(false);
            system.pnlNewPass.setBackground(new Color(54, 63, 77));
            //Botones de Dashboard
        } else if (e.getSource() == system.opDash) {
            system.btnDashboard.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opProduct) {
            system.btnProduct.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opcCategoria) {
            system.btnCategoria.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opcShop) {
            system.btnCompras.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opcProv) {
            system.btnProveedor.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opcUsers) {
            system.btnUsers.setBackground(new Color(187,187,187));
        } else if (e.getSource() == system.opcInformes) {
            system.btnReport.setBackground(new Color(187,187,187));
        }
    }

}
