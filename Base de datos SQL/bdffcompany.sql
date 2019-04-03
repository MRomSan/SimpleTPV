

CREATE DATABASE IF NOT EXISTS `bdffcompany` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdffcompany`;

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `imagen` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `categoria` (`id`, `nombre`, `descripcion`, `imagen`) VALUES
(6, 'BOCADILLOS', 'BOCADILLOS', 'BOCADILLOS.png'),
(7, 'HELADOS', 'HELADOS', 'HELADOS.png'),
(8, 'POSTRES', 'POSTRES', 'POSTRES.png'),
(9, 'REFRESCOS', 'REFRESCOS', 'REFRESCOS.png'),
(10, 'CERVEZAS', 'CERVEZAS', 'CERVEZAS.png'),
(11, 'MONTADITOS', 'MONTADITOS', 'MONTADITOS.png'),
(12, 'ZUMOS', 'ZUMOS', 'ZUMOS.png');

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `telefono1` varchar(9) NOT NULL,
  `telefono2` varchar(9) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) NOT NULL,
  `poblacion` varchar(100) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `codigo_postal` varchar(5) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `clientes` (`id`, `nombre`, `apellido1`, `apellido2`, `dni`, `telefono1`, `telefono2`, `email`, `direccion`, `poblacion`, `provincia`, `codigo_postal`, `fecha_nacimiento`, `sexo`) VALUES
(1, 'Manuel', 'Romero', 'Sánchez', '00000002W', '600302703', '', 'auelrs@hotmail.com', 'Mi Casa', 'Mairena del Aljarafe', 'Sevilla', '41927', '1987-07-06', 'H'),
(2, 'Enrique', 'García', 'Pérez', '00000000T', '955555555', '621111122', 'enrgarper@gmail.com', 'C/Barcelona Bloque 15, 2º B', 'San Juan de Aznalfarache', 'Sevilla', '41920', '1977-09-25', 'H'),
(3, 'María', 'Rubio', 'Jimeno', '00000001R', '955454545', '654158875', 'marrubio@hotmail.com', 'Urb. Las brisas nº 21', 'Mairena del Aljarafe', 'Sevilla', '41927', '1982-11-21', 'M');

CREATE TABLE `detalles_venta` (
  `id` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `precio_linea` float NOT NULL,
  `descuento_linea` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `detalles_venta` (`id`, `id_venta`, `id_producto`, `cantidad`, `precio_linea`, `descuento_linea`) VALUES
(66, 3, 2, 2, 2.8, 15),
(82, 3, 1, 2, 2.04, 15),
(83, 3, 4, 10, 8, 50),
(86, 5, 4, 5, 8, 0),
(87, 6, 2, 5, 7.43, 10),
(88, 6, 1, 2, 2.04, 15),
(89, 5, 10, 5, 4, 0),
(90, 5, 11, 3, 2.4, 0),
(91, 8, 13, 2, 2, 0),
(92, 8, 22, 2, 2, 0),
(93, 8, 17, 5, 5, 0),
(94, 8, 27, 3, 2.25, 0),
(95, 4, 27, 3, 2.25, 0),
(96, 4, 18, 3, 3, 0),
(97, 7, 7, 2, 2.4, 0),
(98, 8, 27, -2, -1.5, 0),
(100, 8, 22, -2, -2, 0),
(126, 21, 13, 2, 1.8, 10),
(127, 21, 14, 2, 1.8, 10),
(128, 21, 16, 2, 1.8, 10),
(129, 21, 25, 2, 1.17, 10),
(130, 21, 27, 2, 1.35, 10),
(131, 21, 4, 10, 12.8, 20),
(132, 22, 13, 3, 2.7, 10),
(133, 22, 14, 1, 0.9, 10),
(134, 22, 16, 3, 2.7, 10),
(135, 22, 25, 1, 0.58, 10),
(136, 22, 4, 6, 4.8, 50);

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `telefono1` varchar(9) NOT NULL,
  `telefono2` varchar(9) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) NOT NULL,
  `poblacion` varchar(100) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `codigo_postal` varchar(5) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `administrador` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `empleados` (`id`, `nombre`, `apellido1`, `apellido2`, `dni`, `telefono1`, `telefono2`, `email`, `direccion`, `poblacion`, `provincia`, `codigo_postal`, `fecha_nacimiento`, `sexo`, `cargo`, `username`, `password`, `administrador`) VALUES
(1, 'Manuel Antonio', 'Romero', 'Sánchez', '00000002W', '600302703', '', 'auelrs@hotmail.com', 'Mi Casa', 'Mairena del Aljarafe', 'Sevilla', '41927', '1987-07-06', 'H', 'Administrador Principal', 'auelrs', '00000002', b'0'),
(2, 'Lidia', 'Vega', 'Castro', '00000003A', '955688748', '712545545', 'lidcastro@gmail.es', 'C/Ciaurriz 126', 'Mairena del Aljarafe', 'Sevilla', '41927', '1990-03-02', 'M', 'Cajero', 'lidvega', '00000003', b'0'),
(3, 'Juan', 'Romero', 'Hernández', '00000004G', '954877784', '621112554', 'jromero@hotmail.com', 'C/Océano Índico 21', 'Mairena del Aljarafe', 'Sevilla', '41927', '1960-07-31', 'H', 'Encargado', 'jromero', '00000004', b'0');

CREATE TABLE `iva` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `iva` (`id`, `nombre`, `cantidad`) VALUES
(4, 'NORMAL', 21),
(5, 'REDUCIDO', 8.5),
(7, 'OTRO', 6);

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `precio` float NOT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_iva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `precio`, `imagen`, `id_categoria`, `id_iva`) VALUES
(1, 'BOCADILLO DE ATÚN', 'BOCADILLO DE ATÚN', 1.2, 'ATUN.png', 6, 4),
(2, 'BOCADILLO JAM. YORK', 'BOCADILLO JAMÓN YORK', 1.65, 'JAMON YORK.png', 6, 5),
(4, 'RED BULL 0.5l', 'LATA RED BULL 0.5l', 1.6, 'RED BULL.png', 9, 4),
(5, 'BOCADILLO JAM. IBÉR.', 'BOCADILLO JAMÓN IBÉRICO', 1.5, 'JAMON IBERICO.png', 6, 4),
(6, 'BOCADILLO JAM. SER.', 'BOCADILLO JAMÓN SERRANO', 1.3, 'JAMON SERRANO.png', 6, 4),
(7, 'BOCADILLO QUESO', 'BOCADILLO QUESO', 1.2, 'QUESO.png', 6, 4),
(8, 'BOCADILLO TORTILLA', 'BOCADILLO TORTILLA ESPAÑOLA', 1.4, 'TORTILLA ESPAÑOLA.png', 6, 4),
(9, 'ZUMO DE MELOCOTÓN', 'ZUMO DE MELOCOTÓN', 0.8, 'MELOCOTON.png', 12, 5),
(10, 'ZUMO DE MELÓN', 'ZUMO DE MELÓN', 0.8, 'MELON.png', 12, 5),
(11, 'ZUMO DE NARANJA', 'ZUMO DE NARANJA', 0.8, 'NARANJA.png', 12, 5),
(12, 'ZUMO DE PIÑA', 'ZUMO DE PIÑA', 0.8, 'PIÑA.png', 12, 5),
(13, 'MONT. CHORIZO', 'MONTADITO DE CHORIZO', 1, 'CHORIZO.png', 11, 4),
(14, 'MONT. JAM. QUESO', 'MONTADITO DE JAMÓN SERRANO Y QUESO', 1, 'JAMON SERRANO Y QUESO.png', 11, 4),
(15, 'MONT. QUESO TOMATE', 'MONTADITO DE QUESO CON TOMATE', 1, 'QUESO CON TOMATE.png', 11, 4),
(16, 'MONT. JAM. TOMATE', 'MONTADITO DE JAMÓN CON TOMATE', 1, 'JAMON SERRANO Y TOMATE.png', 11, 4),
(17, 'MONT. JAM. QU. TOM.', 'MONTADITO DE JAMÓN, QUESO Y TOMATE', 1, 'JAMON SERRANO, TOMATE Y QUESO.png', 11, 4),
(18, 'MONT. JAMÓN', 'MONTADITO DE JAMÓN SERRANO', 1, 'JAMON SERRANO.png', 11, 4),
(19, 'MONT. LOMO TOMATE', 'MONTADITO DE LOMO CON TOMATE', 1, 'LOMO CON TOMATE.png', 11, 4),
(20, 'MONT. LOMO FRESCO', 'MONTADITO DE LOMO FRESCO', 1, 'LOMO FRESCO.png', 11, 4),
(21, 'MONT. LOMO TOM. Q.', 'MONTADITO DE LOMO, TOMATE Y QUESO', 1, 'LOMO, TOMATE Y QUESO.png', 11, 4),
(22, 'MONT. SALCHICHAS', 'MONTADITO DE SALCHICHAS', 1, 'SALCHICHAS.png', 11, 4),
(23, 'BOT. AGUA GR.', 'BOTELLA DE AGUA GRANDE', 1, 'AGUA GRANDE.png', 9, 4),
(24, 'BOT. AGUA PQ.', 'BOTELLA DE AGUA PEQUEÑA', 0.65, 'AGUA.png', 9, 4),
(25, 'AQUARIUS', 'AQUARIUS LATA', 0.65, 'AQUARIUS.png', 9, 4),
(26, 'COCA COLA LIGHT', 'COCA COLA LIGHT LATA', 0.75, 'COCA COLA LIGHT.png', 9, 4),
(27, 'COCA COLA', 'COCA COLA LATA', 0.75, 'COCA COLA.png', 9, 4),
(28, 'FANTA LIMÓN', 'FANTA LIMÓN LATA', 0.6, 'FANTA LIMON.png', 9, 4),
(29, 'FANTA NARANJA', 'FANTA NARANJA LATA', 0.6, 'FANTA NARANJA.png', 9, 4),
(30, 'NESTEA LIMÓN', 'NESTEA LIMÓN LATA', 0.6, 'TE LIMON.png', 9, 4),
(31, 'SPRITE', 'SPRITE LATA', 0.6, 'SPRITE.png', 9, 4),
(32, 'NESTEA MELOC.', 'NESTEA MELOCOTÓN', 0.6, 'TE MELOCOTON.png', 9, 4),
(33, 'TÓNICA', 'TÓNICA LATA', 0.7, 'TONICA.png', 9, 4),
(34, 'HEINEK. LATA', 'HEINEKEN LATA', 1, 'CLARA.png', 10, 4),
(35, 'CORONITA', 'CORONITA BOTELLÍN', 1.5, 'CORONITA.png', 10, 4),
(36, 'SHANDY CRUZCAMPO', 'SHANDY CRUZCAMPO BOTELLÍN', 1.5, 'SANDY.png', 10, 4),
(37, 'BUCKLER S/A', 'BUCKLER SIN ALCOHOL BOTELLÍN', 1.5, 'SIN ALCOHOL.png', 10, 4),
(38, 'BOCADILLO LOMO PL.', 'BOCADILLO LOMO PLANCHA', 1.3, 'LOMO PLANCHA.png', 6, 4),
(39, 'BOCA. QU. MANCHEGO', 'BOCADILLO DE QUESO MANCHEGO', 1.2, 'QUESO MANCHEGO.png', 6, 4);

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(8) NOT NULL,
  `forma_pago` varchar(50) NOT NULL,
  `total` float NOT NULL,
  `entregado` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `ventas` (`id`, `id_empleado`, `id_cliente`, `fecha`, `hora`, `forma_pago`, `total`, `entregado`) VALUES
(3, 2, 2, '2018-04-24', '21:12:15', 'Efectivo', 12.84, 20),
(4, 2, 3, '2018-04-24', '21:15:00', 'Efectivo', 5.25, 10),
(5, 3, 2, '2018-04-24', '21:35:51', 'Tarjeta', 14.4, 14.4),
(6, 1, 2, '2018-05-03', '15:00:00', 'Efectivo', 9.47, 10),
(7, 2, NULL, '2018-05-03', '15:39:15', 'Tarjeta', 2.4, 2.4),
(8, 1, NULL, '2018-05-03', '15:41:09', 'Efectivo', 7.75, 10),
(21, 2, 1, '2018-05-17', '02:49:16', 'Efectivo', 20.72, 25),
(22, 2, 1, '2018-05-17', '02:56:06', 'Tarjeta', 11.68, 11.68);


ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `detalles_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_producto` (`id_producto`);

ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `iva`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_iva` (`id_iva`);

ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_cliente` (`id_cliente`);


ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
ALTER TABLE `detalles_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
ALTER TABLE `iva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

ALTER TABLE `detalles_venta`
  ADD CONSTRAINT `detalles_venta_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  ADD CONSTRAINT `detalles_venta_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id`);

ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_iva`) REFERENCES `iva` (`id`);

ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `ventas_ibfk_4` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id`);
COMMIT;

