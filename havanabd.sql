USE havanabd;
-- Tabla USUARIO
CREATE TABLE USUARIO (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NULL,
    contrasena VARCHAR(255) NULL,
    nombre VARCHAR(100) NULL,
    rol VARCHAR(100) NULL
);

-- Tabla CATEGORIA
CREATE TABLE CATEGORIA (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NULL
);

-- Tabla PRODUCTO
CREATE TABLE PRODUCTO (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    codigo_producto VARCHAR(45) NULL,
    nombre_producto VARCHAR(45) NULL,
    descripcion VARCHAR(255) NULL,
    cantidad INT NULL,
    caducidad DATE NULL,
    created VARCHAR(45) NULL,
    updated VARCHAR(45) NULL,
    id_categoria INT NULL,
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria)
);

-- Tabla PROVEEDOR
CREATE TABLE PROVEEDOR (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NULL,
    descripcion VARCHAR(255) NULL,
    direccion VARCHAR(255) NULL,
    telefono VARCHAR(20) NULL,
    correo VARCHAR(100) NULL,
    created VARCHAR(45) NULL,
    updated VARCHAR(45) NULL
);

-- Tabla COMPRA
CREATE TABLE COMPRA (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    total DOUBLE NULL,
    created VARCHAR(45) NULL,
    id_proveedor INT NULL, 
    id_usuario INT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES PROVEEDOR(id_proveedor),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario)
);

-- Tabla COMPRA_DETALLE
CREATE TABLE COMPRA_DETALLE (
    id_compra_detalle INT AUTO_INCREMENT PRIMARY KEY,
    precio_compra DOUBLE NULL,
    cantidad INT NULL,
    subtotal DOUBLE NULL,
    id_compra INT NULL,
    id_producto INT NULL,
    FOREIGN KEY (id_compra) REFERENCES COMPRA(id_compra),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);