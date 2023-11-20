package view;

import controller.PurchaseController;
import controller.SupplierController;
import controller.CategoryController;
import controller.ProductController;
import controller.settingController;
import controller.EmployeeController;
import model.Category;
import model.CategoryDao;
import model.Purchase;
import model.PurchaseDao;
import model.Product;
import model.ProductDao;
import model.Supplier;
import model.SupplierDao;
import model.Employee;
import model.EmployeeDao;
import static model.EmployeeDao.full_name;
import static model.EmployeeDao.rol_user;
import static model.EmployeeDao.username;

public class systemView extends javax.swing.JFrame {

    Employee employee = new Employee();
    EmployeeDao employeeDao = new EmployeeDao();

    Category category = new Category();
    CategoryDao categoryDao = new CategoryDao();

    Supplier supplier = new Supplier();
    SupplierDao supplierDao = new SupplierDao();

    Product product = new Product();
    ProductDao productDao = new ProductDao();
    
    Purchase purchase = new Purchase();
    PurchaseDao purchaseDao = new PurchaseDao();

    public systemView() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("CONTROL DE INVENTARIO - HAVANA");
        titleInterface();
        //controlador de setting
        settingController control = new settingController(this);
        EmployeeController employeecontrol = new EmployeeController(employee, employeeDao, this);
        employeecontrol.ListAllEmployees();
        CategoryController categorycontrol = new CategoryController(category, categoryDao, this);
        categorycontrol.ListAllCategory();
        categorycontrol.JcomboBoxCategory();
        SupplierController suppliercontrol = new SupplierController(supplier, supplierDao, this);
        suppliercontrol.ListAllSuppliers();
        suppliercontrol.JcomboBoxSupplier();
        ProductController productControl = new ProductController(product, productDao, this);
        productControl.ListAllProduct();
        PurchaseController purchaseControl = new PurchaseController(purchase, purchaseDao, this);
    }

    public String titleInterface() {
        lblNombre.setText(full_name);
        lblUsername.setText(username);
        lblUserIcon.setText(inicialNombre(full_name));
        return rol_user.trim();
    }

    public String inicialNombre(String nombreCompleto) {
        // Dividir el nombre en partes
        String[] partesNombre = nombreCompleto.split(" ");

        // Inicializar una cadena vacía para almacenar las iniciales
        String iniciales = "";

        // Tomar las iniciales de las dos primeras palabras
        for (int i = 0; i < 2 && i < partesNombre.length; i++) {
            String parte = partesNombre[i];
            if (!parte.isEmpty()) {
                iniciales += parte.charAt(0);
            }
        }

        // retornar las iniciales
        return iniciales;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlLine = new javax.swing.JPanel();
        lblInventary = new javax.swing.JLabel();
        pnl_Home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_Producto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_Categoria = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnl_Compra = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnl_Prov = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnl_User = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pnl_Informe = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        pnlUser = new javax.swing.JPanel();
        lblUserIcon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        pnlUserSetting = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        pnlNewPass = new javax.swing.JPanel();
        lblNewPass = new javax.swing.JLabel();
        borderTransparent = new javax.swing.JPanel();
        borderTransparent3 = new javax.swing.JPanel();
        borderTransparent2 = new javax.swing.JPanel();
        borderTransparent4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDashboard = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        opDash = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnProduct = new javax.swing.JPanel();
        opProduct = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCategoria = new javax.swing.JPanel();
        opcCategoria = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCompras = new javax.swing.JPanel();
        opcShop = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnProveedor = new javax.swing.JPanel();
        opcProv = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnUsers = new javax.swing.JPanel();
        opcUsers = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnReport = new javax.swing.JPanel();
        opcInformes = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlProduct = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        txtNameProduct = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtCantProduct = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnCancelProduct = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        btnProductCart = new javax.swing.JButton();
        pnlCatgoria = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        txtNameCategory = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtIdcategory = new javax.swing.JTextField();
        btnAddCategory = new javax.swing.JButton();
        btnUpdateCategory = new javax.swing.JButton();
        btnDeleteCategory = new javax.swing.JButton();
        btnCancelCategory = new javax.swing.JButton();
        pnlCompra = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txt_name_purchase = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txt_price_purchase = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txt_quantity_purchase = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txt_code_product_purchase = new javax.swing.JTextField();
        btnaddBuy = new javax.swing.JButton();
        btnBuyProduct = new javax.swing.JButton();
        btnDeleteBuy = new javax.swing.JButton();
        btnCancelBuy = new javax.swing.JButton();
        cmbSupplier = new javax.swing.JComboBox<>();
        txtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txt_id_purchase = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablePurchase = new javax.swing.JTable();
        pnlProveedor = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtCorreoProveedor = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtDescripcionProveedor = new javax.swing.JTextArea();
        jLabel68 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnAddSupplier = new javax.swing.JButton();
        btnUpdateSupplier = new javax.swing.JButton();
        btnDeleteSupplier = new javax.swing.JButton();
        btnCancelSupplier = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        txtIdSupplier = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        pnlUsuarios = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        txtCodeEmployee = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtNameEmployee = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        btnAddEmployee = new javax.swing.JButton();
        btnUpdateEmployee = new javax.swing.JButton();
        btnDeleteEmployee = new javax.swing.JButton();
        btnCancelEmployee = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        txtPasswordEmployee = new javax.swing.JTextField();
        cmbRol = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableEmployees = new javax.swing.JTable();
        pnlInformes = new javax.swing.JPanel();
        pnlPassNew = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_password_modify = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txt_password_modify_confirm = new javax.swing.JPasswordField();
        btn_modify_data = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 63, 77));

        lblLogo.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("HAVANA");

        pnlLine.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlLineLayout = new javax.swing.GroupLayout(pnlLine);
        pnlLine.setLayout(pnlLineLayout);
        pnlLineLayout.setHorizontalGroup(
            pnlLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLineLayout.setVerticalGroup(
            pnlLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        lblInventary.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblInventary.setForeground(new java.awt.Color(255, 255, 255));
        lblInventary.setText("Mi Inventario");

        pnl_Home.setBackground(new java.awt.Color(54, 63, 77));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-panel.png"))); // NOI18N
        jLabel1.setText("    Dashboard");

        javax.swing.GroupLayout pnl_HomeLayout = new javax.swing.GroupLayout(pnl_Home);
        pnl_Home.setLayout(pnl_HomeLayout);
        pnl_HomeLayout.setHorizontalGroup(
            pnl_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_HomeLayout.setVerticalGroup(
            pnl_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_Producto.setBackground(new java.awt.Color(54, 63, 77));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dropbox-panel.png"))); // NOI18N
        jLabel2.setText("    Productos");

        javax.swing.GroupLayout pnl_ProductoLayout = new javax.swing.GroupLayout(pnl_Producto);
        pnl_Producto.setLayout(pnl_ProductoLayout);
        pnl_ProductoLayout.setHorizontalGroup(
            pnl_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ProductoLayout.setVerticalGroup(
            pnl_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_Categoria.setBackground(new java.awt.Color(54, 63, 77));

        jLabel20.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/category-panel.png"))); // NOI18N
        jLabel20.setText("    Categorias");

        javax.swing.GroupLayout pnl_CategoriaLayout = new javax.swing.GroupLayout(pnl_Categoria);
        pnl_Categoria.setLayout(pnl_CategoriaLayout);
        pnl_CategoriaLayout.setHorizontalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_CategoriaLayout.setVerticalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_Compra.setBackground(new java.awt.Color(54, 63, 77));

        jLabel21.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-panel.png"))); // NOI18N
        jLabel21.setText("    Compras");

        javax.swing.GroupLayout pnl_CompraLayout = new javax.swing.GroupLayout(pnl_Compra);
        pnl_Compra.setLayout(pnl_CompraLayout);
        pnl_CompraLayout.setHorizontalGroup(
            pnl_CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_CompraLayout.setVerticalGroup(
            pnl_CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_Prov.setBackground(new java.awt.Color(54, 63, 77));

        jLabel22.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prov-panel.png"))); // NOI18N
        jLabel22.setText("    Proveedor");

        javax.swing.GroupLayout pnl_ProvLayout = new javax.swing.GroupLayout(pnl_Prov);
        pnl_Prov.setLayout(pnl_ProvLayout);
        pnl_ProvLayout.setHorizontalGroup(
            pnl_ProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ProvLayout.setVerticalGroup(
            pnl_ProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_User.setBackground(new java.awt.Color(54, 63, 77));

        jLabel23.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user-panel.png"))); // NOI18N
        jLabel23.setText("    Usuarios");

        javax.swing.GroupLayout pnl_UserLayout = new javax.swing.GroupLayout(pnl_User);
        pnl_User.setLayout(pnl_UserLayout);
        pnl_UserLayout.setHorizontalGroup(
            pnl_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_UserLayout.setVerticalGroup(
            pnl_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnl_Informe.setBackground(new java.awt.Color(54, 63, 77));

        jLabel24.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report-panel.png"))); // NOI18N
        jLabel24.setText("    Informes");

        javax.swing.GroupLayout pnl_InformeLayout = new javax.swing.GroupLayout(pnl_Informe);
        pnl_Informe.setLayout(pnl_InformeLayout);
        pnl_InformeLayout.setHorizontalGroup(
            pnl_InformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_InformeLayout.setVerticalGroup(
            pnl_InformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInventary)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(pnl_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Compra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Informe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInventary)
                .addGap(18, 18, 18)
                .addComponent(pnl_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_Informe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(247, 247, 248));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblItem.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        lblItem.setForeground(new java.awt.Color(54, 63, 77));
        jPanel3.add(lblItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 56, 640, 50));

        pnlUser.setBackground(new java.awt.Color(247, 247, 248));
        pnlUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserIcon.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblUserIcon.setForeground(new java.awt.Color(255, 255, 255));
        lblUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlUser.add(lblUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle-fill.png"))); // NOI18N
        pnlUser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblNombre.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        pnlUser.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 20));

        lblUsername.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        pnlUser.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 70, 20));

        jPanel3.add(pnlUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 170, -1));

        pnlUserSetting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlExit.setBackground(new java.awt.Color(54, 63, 77));

        lblLogout.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 51, 51));
        lblLogout.setText("  Salir");

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlUserSetting.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        pnlNewPass.setBackground(new java.awt.Color(54, 63, 77));

        lblNewPass.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lblNewPass.setForeground(new java.awt.Color(204, 204, 204));
        lblNewPass.setText("  Restablecer contraseña");

        javax.swing.GroupLayout pnlNewPassLayout = new javax.swing.GroupLayout(pnlNewPass);
        pnlNewPass.setLayout(pnlNewPassLayout);
        pnlNewPassLayout.setHorizontalGroup(
            pnlNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        pnlNewPassLayout.setVerticalGroup(
            pnlNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlUserSetting.add(pnlNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 30));

        jPanel3.add(pnlUserSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 180, 60));

        borderTransparent.setBackground(new java.awt.Color(247, 247, 248));

        javax.swing.GroupLayout borderTransparentLayout = new javax.swing.GroupLayout(borderTransparent);
        borderTransparent.setLayout(borderTransparentLayout);
        borderTransparentLayout.setHorizontalGroup(
            borderTransparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        borderTransparentLayout.setVerticalGroup(
            borderTransparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.add(borderTransparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 910, 30));

        borderTransparent3.setBackground(new java.awt.Color(247, 247, 248));

        javax.swing.GroupLayout borderTransparent3Layout = new javax.swing.GroupLayout(borderTransparent3);
        borderTransparent3.setLayout(borderTransparent3Layout);
        borderTransparent3Layout.setHorizontalGroup(
            borderTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        borderTransparent3Layout.setVerticalGroup(
            borderTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jPanel3.add(borderTransparent3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 40, 590));

        borderTransparent2.setBackground(new java.awt.Color(247, 247, 248));

        javax.swing.GroupLayout borderTransparent2Layout = new javax.swing.GroupLayout(borderTransparent2);
        borderTransparent2.setLayout(borderTransparent2Layout);
        borderTransparent2Layout.setHorizontalGroup(
            borderTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        borderTransparent2Layout.setVerticalGroup(
            borderTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jPanel3.add(borderTransparent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(915, 140, 15, -1));

        borderTransparent4.setBackground(new java.awt.Color(247, 247, 248));

        javax.swing.GroupLayout borderTransparent4Layout = new javax.swing.GroupLayout(borderTransparent4);
        borderTransparent4.setLayout(borderTransparent4Layout);
        borderTransparent4Layout.setHorizontalGroup(
            borderTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        borderTransparent4Layout.setVerticalGroup(
            borderTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel3.add(borderTransparent4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 900, 40));

        pnlDashboard.setBackground(new java.awt.Color(247, 247, 248));
        pnlDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        btnDashboard.setBackground(new java.awt.Color(204, 204, 204));
        btnDashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        opDash.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opDash.setForeground(new java.awt.Color(0, 0, 0));
        opDash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opDash.setText("DASHBOARD");
        opDash.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-2-big.png"))); // NOI18N

        javax.swing.GroupLayout btnDashboardLayout = new javax.swing.GroupLayout(btnDashboard);
        btnDashboard.setLayout(btnDashboardLayout);
        btnDashboardLayout.setHorizontalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(opDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnDashboardLayout.setVerticalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnProduct.setBackground(new java.awt.Color(204, 204, 204));
        btnProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opProduct.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opProduct.setForeground(new java.awt.Color(0, 0, 0));
        opProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opProduct.setText("PRODUCTOS");
        opProduct.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dropbox.png"))); // NOI18N

        javax.swing.GroupLayout btnProductLayout = new javax.swing.GroupLayout(btnProduct);
        btnProduct.setLayout(btnProductLayout);
        btnProductLayout.setHorizontalGroup(
            btnProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnProductLayout.setVerticalGroup(
            btnProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCategoria.setBackground(new java.awt.Color(204, 204, 204));
        btnCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opcCategoria.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opcCategoria.setForeground(new java.awt.Color(0, 0, 0));
        opcCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opcCategoria.setText("CATEGORIAS");
        opcCategoria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/category-solid-120.png"))); // NOI18N

        javax.swing.GroupLayout btnCategoriaLayout = new javax.swing.GroupLayout(btnCategoria);
        btnCategoria.setLayout(btnCategoriaLayout);
        btnCategoriaLayout.setHorizontalGroup(
            btnCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnCategoriaLayout.setVerticalGroup(
            btnCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCompras.setBackground(new java.awt.Color(204, 204, 204));
        btnCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opcShop.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opcShop.setForeground(new java.awt.Color(0, 0, 0));
        opcShop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opcShop.setText("COMPRAS");
        opcShop.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-bag-solid-120.png"))); // NOI18N

        javax.swing.GroupLayout btnComprasLayout = new javax.swing.GroupLayout(btnCompras);
        btnCompras.setLayout(btnComprasLayout);
        btnComprasLayout.setHorizontalGroup(
            btnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(opcShop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnComprasLayout.setVerticalGroup(
            btnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(opcShop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnProveedor.setBackground(new java.awt.Color(204, 204, 204));
        btnProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opcProv.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opcProv.setForeground(new java.awt.Color(0, 0, 0));
        opcProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opcProv.setText("PROVEEDOR");
        opcProv.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user-account-solid-120.png"))); // NOI18N

        javax.swing.GroupLayout btnProveedorLayout = new javax.swing.GroupLayout(btnProveedor);
        btnProveedor.setLayout(btnProveedorLayout);
        btnProveedorLayout.setHorizontalGroup(
            btnProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnProveedorLayout.setVerticalGroup(
            btnProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnUsers.setBackground(new java.awt.Color(204, 204, 204));
        btnUsers.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opcUsers.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opcUsers.setForeground(new java.awt.Color(0, 0, 0));
        opcUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opcUsers.setText("USUARIOS");
        opcUsers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/group-solid-120.png"))); // NOI18N

        javax.swing.GroupLayout btnUsersLayout = new javax.swing.GroupLayout(btnUsers);
        btnUsers.setLayout(btnUsersLayout);
        btnUsersLayout.setHorizontalGroup(
            btnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(opcUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnUsersLayout.setVerticalGroup(
            btnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(opcUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnReport.setBackground(new java.awt.Color(204, 204, 204));
        btnReport.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        opcInformes.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        opcInformes.setForeground(new java.awt.Color(0, 0, 0));
        opcInformes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opcInformes.setText("INFORMES");
        opcInformes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report-solid-120.png"))); // NOI18N

        javax.swing.GroupLayout btnReportLayout = new javax.swing.GroupLayout(btnReport);
        btnReport.setLayout(btnReportLayout);
        btnReportLayout.setHorizontalGroup(
            btnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(opcInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnReportLayout.setVerticalGroup(
            btnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu Principal", pnlDashboard);

        pnlProduct.setBackground(new java.awt.Color(247, 247, 248));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "AÑADIR UN PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 14), new java.awt.Color(60, 63, 65))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(60, 63, 65));

        jLabel55.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(60, 63, 65));
        jLabel55.setText("Nombre del producto");

        jLabel57.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(60, 63, 65));
        jLabel57.setText("Cantidad");

        txtCantProduct.setEditable(false);

        jLabel58.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(60, 63, 65));
        jLabel58.setText("Descripción");

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        jScrollPane8.setViewportView(txaDescription);

        jLabel60.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(60, 63, 65));
        jLabel60.setText("Categoria");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - - -  SELECCIONE - - - - ", "BELLEZA" }));

        jLabel61.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(60, 63, 65));
        jLabel61.setText("Codigo de producto");

        btnAddProduct.setBackground(new java.awt.Color(46, 186, 155));
        btnAddProduct.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(238, 255, 245));
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-product.png"))); // NOI18N
        btnAddProduct.setText("Añadir");

        btnUpdateProduct.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdateProduct.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnUpdateProduct.setForeground(new java.awt.Color(238, 255, 245));
        btnUpdateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop-right-line.png"))); // NOI18N
        btnUpdateProduct.setText("Modificar");

        btnDeleteProduct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteProduct.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(238, 255, 245));
        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-bin-fill.png"))); // NOI18N
        btnDeleteProduct.setText("Eliminar");

        btnCancelProduct.setBackground(new java.awt.Color(54, 63, 77));
        btnCancelProduct.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnCancelProduct.setForeground(new java.awt.Color(238, 255, 245));
        btnCancelProduct.setText("Cancelar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCantProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtNameProduct, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodProd))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCantProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tableProduct.setBackground(new java.awt.Color(255, 255, 255));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripción", "Cantidad", "Fecha de creacion", "Fecha de modificacion", "Categoria"
            }
        ));
        jScrollPane9.setViewportView(tableProduct);

        btnProductCart.setBackground(new java.awt.Color(0, 0, 0));
        btnProductCart.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnProductCart.setForeground(new java.awt.Color(238, 255, 245));
        btnProductCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart-product.png"))); // NOI18N
        btnProductCart.setText("Comprar");

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProductCart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlProductLayout.setVerticalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductCart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", pnlProduct);

        pnlCatgoria.setBackground(new java.awt.Color(247, 247, 248));

        tableCategory.setBackground(new java.awt.Color(255, 255, 255));
        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane5.setViewportView(tableCategory);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "AÑADIR CATEGORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 14), new java.awt.Color(60, 63, 65))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(60, 63, 65));

        jLabel46.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(60, 63, 65));
        jLabel46.setText("Nombre de Categoría");

        jLabel52.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(60, 63, 65));
        jLabel52.setText("Id");

        txtIdcategory.setEnabled(false);

        btnAddCategory.setBackground(new java.awt.Color(46, 186, 155));
        btnAddCategory.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddCategory.setForeground(new java.awt.Color(238, 255, 245));
        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-product.png"))); // NOI18N
        btnAddCategory.setText("Añadir");

        btnUpdateCategory.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdateCategory.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnUpdateCategory.setForeground(new java.awt.Color(238, 255, 245));
        btnUpdateCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop-right-line.png"))); // NOI18N
        btnUpdateCategory.setText("Modificar");

        btnDeleteCategory.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteCategory.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnDeleteCategory.setForeground(new java.awt.Color(238, 255, 245));
        btnDeleteCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-bin-fill.png"))); // NOI18N
        btnDeleteCategory.setText("Eliminar");

        btnCancelCategory.setBackground(new java.awt.Color(54, 63, 77));
        btnCancelCategory.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnCancelCategory.setForeground(new java.awt.Color(238, 255, 245));
        btnCancelCategory.setText("Cancelar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel46))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(txtIdcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCatgoriaLayout = new javax.swing.GroupLayout(pnlCatgoria);
        pnlCatgoria.setLayout(pnlCatgoriaLayout);
        pnlCatgoriaLayout.setHorizontalGroup(
            pnlCatgoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCatgoriaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlCatgoriaLayout.setVerticalGroup(
            pnlCatgoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCatgoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCatgoriaLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        jTabbedPane1.addTab("Categorias", pnlCatgoria);

        pnlCompra.setBackground(new java.awt.Color(247, 247, 248));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "NUEVA COMPRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 14), new java.awt.Color(60, 63, 65))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(60, 63, 65));

        jLabel47.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(60, 63, 65));
        jLabel47.setText("Nombre del producto");

        txt_name_purchase.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(60, 63, 65));
        jLabel48.setText("Precio de Compra");

        txt_price_purchase.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(60, 63, 65));
        jLabel49.setText("Cantidad");

        txt_quantity_purchase.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(60, 63, 65));
        jLabel50.setText("Proveedor");

        jLabel51.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(60, 63, 65));
        jLabel51.setText("Subtotal");

        jLabel53.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(60, 63, 65));
        jLabel53.setText("Total a pagar");

        jLabel54.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(60, 63, 65));
        jLabel54.setText("Codigo de producto");

        txt_code_product_purchase.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txt_code_product_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_code_product_purchaseActionPerformed(evt);
            }
        });

        btnaddBuy.setBackground(new java.awt.Color(46, 186, 155));
        btnaddBuy.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnaddBuy.setForeground(new java.awt.Color(238, 255, 245));
        btnaddBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-product.png"))); // NOI18N
        btnaddBuy.setText("Añadir");

        btnBuyProduct.setBackground(new java.awt.Color(0, 0, 0));
        btnBuyProduct.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnBuyProduct.setForeground(new java.awt.Color(238, 255, 245));
        btnBuyProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart-product.png"))); // NOI18N
        btnBuyProduct.setText("Comprar");

        btnDeleteBuy.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteBuy.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnDeleteBuy.setForeground(new java.awt.Color(238, 255, 245));
        btnDeleteBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-bin-fill.png"))); // NOI18N
        btnDeleteBuy.setText("Eliminar");

        btnCancelBuy.setBackground(new java.awt.Color(54, 63, 77));
        btnCancelBuy.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnCancelBuy.setForeground(new java.awt.Color(238, 255, 245));
        btnCancelBuy.setText("Cancelar");

        cmbSupplier.setFont(new java.awt.Font("Roboto Condensed Light", 1, 14)); // NOI18N
        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtSubtotal.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        txtTotal.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(60, 63, 65));
        jLabel56.setText("Id");

        txt_id_purchase.setEditable(false);
        txt_id_purchase.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel47))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_code_product_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_name_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_price_purchase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_quantity_purchase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addGap(53, 53, 53)
                        .addComponent(txt_id_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnaddBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuyProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_quantity_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_price_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_code_product_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_id_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnaddBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablePurchase.setBackground(new java.awt.Color(255, 255, 255));
        tablePurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre del producto", "Cantidad", "Precio", "Subtotal", "Proveedor"
            }
        ));
        jScrollPane7.setViewportView(tablePurchase);

        javax.swing.GroupLayout pnlCompraLayout = new javax.swing.GroupLayout(pnlCompra);
        pnlCompra.setLayout(pnlCompraLayout);
        pnlCompraLayout.setHorizontalGroup(
            pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlCompraLayout.setVerticalGroup(
            pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Compras", pnlCompra);

        pnlProveedor.setBackground(new java.awt.Color(247, 247, 248));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "AÑADIR PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 14), new java.awt.Color(60, 63, 65))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(60, 63, 65));

        jLabel62.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(60, 63, 65));
        jLabel62.setText("Nombre");

        jLabel63.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(60, 63, 65));
        jLabel63.setText("Direccion");

        jLabel64.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(60, 63, 65));
        jLabel64.setText("Correo");

        jLabel65.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(60, 63, 65));
        jLabel65.setText("Descripción");

        txtDescripcionProveedor.setColumns(20);
        txtDescripcionProveedor.setRows(5);
        jScrollPane10.setViewportView(txtDescripcionProveedor);

        jLabel68.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(60, 63, 65));
        jLabel68.setText("Telefono");

        btnAddSupplier.setBackground(new java.awt.Color(46, 186, 155));
        btnAddSupplier.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddSupplier.setForeground(new java.awt.Color(238, 255, 245));
        btnAddSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-product.png"))); // NOI18N
        btnAddSupplier.setText("Añadir");

        btnUpdateSupplier.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdateSupplier.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnUpdateSupplier.setForeground(new java.awt.Color(238, 255, 245));
        btnUpdateSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop-right-line.png"))); // NOI18N
        btnUpdateSupplier.setText("Modificar");

        btnDeleteSupplier.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteSupplier.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnDeleteSupplier.setForeground(new java.awt.Color(238, 255, 245));
        btnDeleteSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-bin-fill.png"))); // NOI18N
        btnDeleteSupplier.setText("Eliminar");

        btnCancelSupplier.setBackground(new java.awt.Color(54, 63, 77));
        btnCancelSupplier.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnCancelSupplier.setForeground(new java.awt.Color(238, 255, 245));
        btnCancelSupplier.setText("Cancelar");

        jLabel70.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(60, 63, 65));
        jLabel70.setText("Id");

        txtIdSupplier.setEditable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tableSupplier.setBackground(new java.awt.Color(255, 255, 255));
        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Direccion", "Telefono", "Correo"
            }
        ));
        jScrollPane11.setViewportView(tableSupplier);

        javax.swing.GroupLayout pnlProveedorLayout = new javax.swing.GroupLayout(pnlProveedor);
        pnlProveedor.setLayout(pnlProveedorLayout);
        pnlProveedorLayout.setHorizontalGroup(
            pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProveedorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnlProveedorLayout.setVerticalGroup(
            pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedor", pnlProveedor);

        pnlUsuarios.setBackground(new java.awt.Color(247, 247, 248));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "AÑADIR USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 14), new java.awt.Color(60, 63, 65))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(60, 63, 65));

        jLabel66.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(60, 63, 65));
        jLabel66.setText("Codigo");

        txtCodeEmployee.setEditable(false);
        txtCodeEmployee.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(60, 63, 65));
        jLabel67.setText("Nombre");

        txtNameEmployee.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(60, 63, 65));
        jLabel69.setText("Usuario");

        txtUsername.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        jLabel71.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(60, 63, 65));
        jLabel71.setText("Rol");

        btnAddEmployee.setBackground(new java.awt.Color(46, 186, 155));
        btnAddEmployee.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddEmployee.setForeground(new java.awt.Color(238, 255, 245));
        btnAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-product.png"))); // NOI18N
        btnAddEmployee.setText("Añadir");

        btnUpdateEmployee.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdateEmployee.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnUpdateEmployee.setForeground(new java.awt.Color(238, 255, 245));
        btnUpdateEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop-right-line.png"))); // NOI18N
        btnUpdateEmployee.setText("Modificar");

        btnDeleteEmployee.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteEmployee.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnDeleteEmployee.setForeground(new java.awt.Color(238, 255, 245));
        btnDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-bin-fill.png"))); // NOI18N
        btnDeleteEmployee.setText("Eliminar");

        btnCancelEmployee.setBackground(new java.awt.Color(54, 63, 77));
        btnCancelEmployee.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnCancelEmployee.setForeground(new java.awt.Color(238, 255, 245));
        btnCancelEmployee.setText("Cancelar");

        jLabel72.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(60, 63, 65));
        jLabel72.setText("Contraseña");

        txtPasswordEmployee.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "Administrador", "Auxiliar" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtNameEmployee)
                    .addComponent(txtCodeEmployee)
                    .addComponent(cmbRol, 0, 174, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72)
                            .addComponent(txtPasswordEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tableEmployees.setBackground(new java.awt.Color(255, 255, 255));
        tableEmployees.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        tableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Usuario", "Rol"
            }
        ));
        jScrollPane13.setViewportView(tableEmployees);

        javax.swing.GroupLayout pnlUsuariosLayout = new javax.swing.GroupLayout(pnlUsuarios);
        pnlUsuarios.setLayout(pnlUsuariosLayout);
        pnlUsuariosLayout.setHorizontalGroup(
            pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuariosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane13))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlUsuariosLayout.setVerticalGroup(
            pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", pnlUsuarios);

        pnlInformes.setBackground(new java.awt.Color(247, 247, 248));

        javax.swing.GroupLayout pnlInformesLayout = new javax.swing.GroupLayout(pnlInformes);
        pnlInformes.setLayout(pnlInformesLayout);
        pnlInformesLayout.setHorizontalGroup(
            pnlInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlInformesLayout.setVerticalGroup(
            pnlInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Informes", pnlInformes);

        pnlPassNew.setBackground(new java.awt.Color(247, 247, 248));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(54, 63, 77));
        jLabel3.setText("Elige una nueva contraseña para esta cuenta usuario. Esta contraseña reemplazará a la antigua pero el resto de información");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 63, 77));
        jLabel5.setText("de la cuenta permanecerá igual.");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(54, 63, 77));
        jLabel7.setText("Escribe una nueva contraseña");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(54, 63, 77));
        jLabel8.setText("Vuelva a escribir la contraseña para confirmar");

        btn_modify_data.setBackground(new java.awt.Color(54, 63, 77));
        btn_modify_data.setForeground(new java.awt.Color(255, 255, 255));
        btn_modify_data.setText("CAMBIAR LA CONTRASEÑA");

        javax.swing.GroupLayout pnlPassNewLayout = new javax.swing.GroupLayout(pnlPassNew);
        pnlPassNew.setLayout(pnlPassNewLayout);
        pnlPassNewLayout.setHorizontalGroup(
            pnlPassNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPassNewLayout.createSequentialGroup()
                .addGroup(pnlPassNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPassNewLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlPassNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPassNewLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlPassNewLayout.setVerticalGroup(
            pnlPassNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPassNewLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("newpass", pnlPassNew);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 910, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_code_product_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_code_product_purchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_code_product_purchaseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(systemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(systemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(systemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(systemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new systemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderTransparent;
    private javax.swing.JPanel borderTransparent2;
    private javax.swing.JPanel borderTransparent3;
    private javax.swing.JPanel borderTransparent4;
    public javax.swing.JButton btnAddCategory;
    public javax.swing.JButton btnAddEmployee;
    public javax.swing.JButton btnAddProduct;
    public javax.swing.JButton btnAddSupplier;
    public javax.swing.JButton btnBuyProduct;
    public javax.swing.JButton btnCancelBuy;
    public javax.swing.JButton btnCancelCategory;
    public javax.swing.JButton btnCancelEmployee;
    public javax.swing.JButton btnCancelProduct;
    public javax.swing.JButton btnCancelSupplier;
    public javax.swing.JPanel btnCategoria;
    public javax.swing.JPanel btnCompras;
    public javax.swing.JPanel btnDashboard;
    public javax.swing.JButton btnDeleteBuy;
    public javax.swing.JButton btnDeleteCategory;
    public javax.swing.JButton btnDeleteEmployee;
    public javax.swing.JButton btnDeleteProduct;
    public javax.swing.JButton btnDeleteSupplier;
    public javax.swing.JPanel btnProduct;
    public javax.swing.JButton btnProductCart;
    public javax.swing.JPanel btnProveedor;
    public javax.swing.JPanel btnReport;
    public javax.swing.JButton btnUpdateCategory;
    public javax.swing.JButton btnUpdateEmployee;
    public javax.swing.JButton btnUpdateProduct;
    public javax.swing.JButton btnUpdateSupplier;
    public javax.swing.JPanel btnUsers;
    public javax.swing.JButton btn_modify_data;
    public javax.swing.JButton btnaddBuy;
    public javax.swing.JComboBox<String> cmbCategory;
    public javax.swing.JComboBox<String> cmbRol;
    public javax.swing.JComboBox<String> cmbSupplier;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblInventary;
    public javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblLogout;
    public javax.swing.JLabel lblNewPass;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblUserIcon;
    public javax.swing.JLabel lblUsername;
    public javax.swing.JLabel opDash;
    public javax.swing.JLabel opProduct;
    public javax.swing.JLabel opcCategoria;
    public javax.swing.JLabel opcInformes;
    public javax.swing.JLabel opcProv;
    public javax.swing.JLabel opcShop;
    public javax.swing.JLabel opcUsers;
    public javax.swing.JPanel pnlCatgoria;
    public javax.swing.JPanel pnlCompra;
    public javax.swing.JPanel pnlDashboard;
    public javax.swing.JPanel pnlExit;
    public javax.swing.JPanel pnlInformes;
    private javax.swing.JPanel pnlLine;
    public javax.swing.JPanel pnlNewPass;
    public javax.swing.JPanel pnlPassNew;
    public javax.swing.JPanel pnlProduct;
    public javax.swing.JPanel pnlProveedor;
    public javax.swing.JPanel pnlUser;
    public javax.swing.JPanel pnlUserSetting;
    public javax.swing.JPanel pnlUsuarios;
    public javax.swing.JPanel pnl_Categoria;
    public javax.swing.JPanel pnl_Compra;
    public javax.swing.JPanel pnl_Home;
    public javax.swing.JPanel pnl_Informe;
    public javax.swing.JPanel pnl_Producto;
    public javax.swing.JPanel pnl_Prov;
    public javax.swing.JPanel pnl_User;
    public javax.swing.JTable tableCategory;
    public javax.swing.JTable tableEmployees;
    public javax.swing.JTable tableProduct;
    public javax.swing.JTable tablePurchase;
    public javax.swing.JTable tableSupplier;
    public javax.swing.JTextArea txaDescription;
    public javax.swing.JTextField txtCantProduct;
    public javax.swing.JTextField txtCodProd;
    public javax.swing.JTextField txtCodeEmployee;
    public javax.swing.JTextField txtCorreoProveedor;
    public javax.swing.JTextArea txtDescripcionProveedor;
    public javax.swing.JTextField txtDireccionProveedor;
    public javax.swing.JTextField txtIdSupplier;
    public javax.swing.JTextField txtIdcategory;
    public javax.swing.JTextField txtNameCategory;
    public javax.swing.JTextField txtNameEmployee;
    public javax.swing.JTextField txtNameProduct;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JTextField txtPasswordEmployee;
    public javax.swing.JTextField txtSubtotal;
    public javax.swing.JTextField txtTelefonoProveedor;
    public javax.swing.JTextField txtTotal;
    public javax.swing.JTextField txtUsername;
    public javax.swing.JTextField txt_code_product_purchase;
    public javax.swing.JTextField txt_id_purchase;
    public javax.swing.JTextField txt_name_purchase;
    public javax.swing.JPasswordField txt_password_modify;
    public javax.swing.JPasswordField txt_password_modify_confirm;
    public javax.swing.JTextField txt_price_purchase;
    public javax.swing.JTextField txt_quantity_purchase;
    // End of variables declaration//GEN-END:variables
}
