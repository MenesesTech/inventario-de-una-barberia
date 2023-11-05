USE havanabd;
-- Tabla USUARIO
CREATE TABLE USUARIO (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(100) NOT NULL
);

-- Tabla CATEGORIA
CREATE TABLE CATEGORIA (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL
);

-- Tabla PRODUCTO
CREATE TABLE PRODUCTO (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    codigo_producto VARCHAR(45) NOT NULL,
    nombre_producto VARCHAR(45) NOT NULL,
    descripcion TEXT,
    cantidad INT NOT NULL,
    precio_venta DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    created VARCHAR(45),
    updated VARCHAR(45),
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria)
);

-- Tabla PROVEEDOR
CREATE TABLE PROVEEDOR (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    created VARCHAR(45),
    updated VARCHAR(45)
);

-- Tabla COMPRA
CREATE TABLE COMPRA (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL,
    created VARCHAR(45),
    id_proveedor INT, 
    id_usuario INT,
    FOREIGN KEY (id_proveedor) REFERENCES PROVEEDOR(id_proveedor),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario)
);

-- Tabla COMPRA_DETALLE
CREATE TABLE COMPRA_DETALLE (
    id_compra_detalle INT AUTO_INCREMENT PRIMARY KEY,
    precio_compra DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    id_compra INT,
    id_producto INT,
    FOREIGN KEY (id_compra) REFERENCES COMPRA(id_compra),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);