CREATE TABLE proveedores( id INTEGER  AUTO_INCREMENT,
                        nif VARCHAR(12) NOT NULL,
                        razon_social VARCHAR(50),
                        nombre VARCHAR(15),
                        apellido1 VARCHAR (15),
                        apellido2 VARCHAR (15),
                        telefono VARCHAR (12),
                        email VARCHAR (75),
                        created_at DATETIME NOT NULL,
                        modified_at DATETIME NOT NULL,
                        PRIMARY KEY (id),
                        CONSTRAINT UQ_nif UNIQUE (nif));

CREATE TABLE articulos( id INTEGER  AUTO_INCREMENT,
                       ref VARCHAR(10) NOT NULL,
                       descripcion VARCHAR(100) NOT NULL,
                       precio VARCHAR (15) NOT NULL,
                       proveedor_id INTEGER NOT NULL,
                       telefono VARCHAR (15),
                       created_at DATETIME NOT NULL,
                       modified_at DATETIME NOT NULL,
                       PRIMARY KEY (id),
                       CONSTRAINT UQ_ref UNIQUE (ref));

ALTER TABLE articulos ADD CONSTRAINT FK_proveedor_id FOREIGN KEY (proveedor_id) REFERENCES proveedores(id);

INSERT INTO proveedores (nif, razon_social, nombre, apellido1, apellido2, telefono, email, created_at, modified_at)
       VALUES("123456789A", "SOFTBA", "Pepito", "Pérez", "López", "121212121", "softba@gmail.com", now(), now());

INSERT INTO proveedores (nif, razon_social, nombre, apellido1, apellido2, telefono, email, created_at, modified_at)
VALUES("111111111B", "Consumibles Castelar", "Martita", "Díaz", "López", "222222222", "consumibles@gmail.com", now(), now());
