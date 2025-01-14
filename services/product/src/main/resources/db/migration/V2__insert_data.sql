-- Insertar categorías en español
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Teclados para computadora', 'Teclados');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Monitores de computadora', 'Monitores');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Pantallas de visualización', 'Pantallas');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Ratones de computadora', 'Ratones');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Accesorios para computadora', 'Accesorios');

-- Insertar productos para la categoría 'Teclados'
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 10, 'Teclado mecánico con retroiluminación RGB', 'Teclado Mecánico 1', 99.99, (SELECT id FROM category WHERE name = 'Teclados')),
    (nextval('product_seq'), 15, 'Teclado inalámbrico compacto', 'Teclado Compacto Inalámbrico 1', 79.99, (SELECT id FROM category WHERE name = 'Teclados')),
    (nextval('product_seq'), 20, 'Teclado gamer retroiluminado con teclas personalizables', 'Teclado Gamer 1', 129.99, (SELECT id FROM category WHERE name = 'Teclados')),
    (nextval('product_seq'), 25, 'Teclado mecánico con reposamuñecas', 'Teclado Ergonómico 1', 109.99, (SELECT id FROM category WHERE name = 'Teclados')),
    (nextval('product_seq'), 18, 'Combo de teclado y ratón inalámbrico', 'Combo Inalámbrico 1', 69.99, (SELECT id FROM category WHERE name = 'Teclados'));

-- Insertar productos para la categoría 'Monitores'
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 30, 'Monitor IPS de 27 pulgadas con resolución 4K', 'Monitor 4K 1', 399.99, (SELECT id FROM category WHERE name = 'Monitores')),
    (nextval('product_seq'), 25, 'Monitor gamer ultra ancho con soporte HDR', 'Monitor Gamer Ultra Ancho 1', 499.99, (SELECT id FROM category WHERE name = 'Monitores')),
    (nextval('product_seq'), 22, 'Monitor LED de 24 pulgadas para oficina', 'Monitor de Oficina 1', 179.99, (SELECT id FROM category WHERE name = 'Monitores')),
    (nextval('product_seq'), 28, 'Monitor curvo de 32 pulgadas con AMD FreeSync', 'Monitor Curvo 1', 329.99, (SELECT id FROM category WHERE name = 'Monitores')),
    (nextval('product_seq'), 35, 'Monitor portátil USB-C para laptops', 'Monitor Portátil 1', 249.99, (SELECT id FROM category WHERE name = 'Monitores'));

-- Insertar productos para la categoría 'Pantallas'
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 15, 'Pantalla OLED curva para gaming con 240Hz', 'Pantalla OLED Curva 1', 799.99, (SELECT id FROM category WHERE name = 'Pantallas')),
    (nextval('product_seq'), 18, 'Monitor QLED plano con resolución 1440p', 'Monitor QLED 1', 599.99, (SELECT id FROM category WHERE name = 'Pantallas')),
    (nextval('product_seq'), 22, 'Pantalla táctil de 27 pulgadas para diseño', 'Pantalla Táctil 1', 699.99, (SELECT id FROM category WHERE name = 'Pantallas')),
    (nextval('product_seq'), 20, 'Pantalla ultra delgada 4K HDR para multimedia', 'Pantalla 4K HDR 1', 449.99, (SELECT id FROM category WHERE name = 'Pantallas')),
    (nextval('product_seq'), 25, 'Proyector gamer con baja latencia', 'Proyector Gamer 1', 899.99, (SELECT id FROM category WHERE name = 'Pantallas'));

-- Insertar productos para la categoría 'Ratones'
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 30, 'Ratón gamer inalámbrico con iluminación RGB', 'Ratón Gamer RGB 1', 59.99, (SELECT id FROM category WHERE name = 'Ratones')),
    (nextval('product_seq'), 28, 'Ratón ergonómico con cable para productividad', 'Ratón Ergonómico 1', 29.99, (SELECT id FROM category WHERE name = 'Ratones')),
    (nextval('product_seq'), 32, 'Ratón gamer ambidiestro con alta DPI', 'Ratón Ambidiestro 1', 69.99, (SELECT id FROM category WHERE name = 'Ratones')),
    (nextval('product_seq'), 26, 'Ratón compacto para portátiles', 'Ratón de Viaje 1', 19.99, (SELECT id FROM category WHERE name = 'Ratones')),
    (nextval('product_seq'), 35, 'Ratón vertical ergonómico para menor esfuerzo', 'Ratón Vertical 1', 39.99, (SELECT id FROM category WHERE name = 'Ratones'));

-- Insertar productos para la categoría 'Accesorios'
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 25, 'Soporte ajustable para laptop con ventilador', 'Soporte para Laptop 1', 34.99, (SELECT id FROM category WHERE name = 'Accesorios')),
    (nextval('product_seq'), 20, 'Base de carga inalámbrica para smartphones', 'Base de Carga 1', 24.99, (SELECT id FROM category WHERE name = 'Accesorios')),
    (nextval('product_seq'), 28, 'Soporte para audífonos con iluminación RGB', 'Soporte RGB 1', 49.99, (SELECT id FROM category WHERE name = 'Accesorios')),
    (nextval('product_seq'), 22, 'Teclado mecánico Bluetooth para tabletas', 'Teclado Bluetooth 1', 39.99, (SELECT id FROM category WHERE name = 'Accesorios')),
    (nextval('product_seq'), 30, 'Caja para disco duro externo con USB-C', 'Caja HDD USB-C 1', 29.99, (SELECT id FROM category WHERE name = 'Accesorios'));
