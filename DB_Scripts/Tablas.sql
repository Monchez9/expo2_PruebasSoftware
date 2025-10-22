CREATE TABLE proveedor (
   id_proveedor INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(128) NOT NULL,
   nombre_comercial VARCHAR(128) NOT NULL,
   correo VARCHAR(128) NOT NULL,
   numero_telefono VARCHAR(20) NOT NULL,
   iban VARCHAR(34) NOT NULL,
   cedula_identidad VARCHAR(20) NULL,
   cedula_juridica VARCHAR(20) NULL,
   CONSTRAINT tipo_cedula CHECK (
	(cedula_identidad IS NOT NULL AND cedula_juridica IS NULL) OR
	(cedula_juridica IS NOT NULL AND cedula_identidad IS NULL)
   )
);

INSERT INTO proveedor 
(nombre, nombre_comercial, correo, numero_telefono, iban, cedula_identidad, cedula_juridica)
VALUES
-- Personas físicas
('Carlos Méndez Rojas', 'CMR Servicios', 'carlos.mendez@gmail.com', '+506 8888-1234', 'CR23015108456712345678', '115460982', NULL),
('Laura Jiménez Vargas', 'Consultora LJ', 'laura.jv@outlook.com', '+506 8812-4321', 'CR10015202345878965432', '208765432', NULL),
('José Morales Araya', 'JM Soluciones', 'jose.morales@empresa.co', '+506 6001-9821', 'CR54015302347856321987', '304569821', NULL),
('María Fernanda Soto', 'MFS Marketing', 'mfsoto@gmail.com', '+506 7102-4578', 'CR19015406547898213245', '407854123', NULL),
('Ricardo Quesada Solís', 'RQS Logística', 'ricardo.qs@correo.com', '+506 7012-3344', 'CR08015303249865412589', '506987456', NULL),

-- Personas jurídicas
('Distribuidora El Roble S.A.', 'El Roble', 'contacto@elroble.co.cr', '+506 2223-4455', 'CR42015408756423159874', NULL, '3102456789'),
('Tecnologías Verdes S.R.L.', 'TecVerde', 'info@tecverde.cr', '+506 2525-9090', 'CR31015501236547896521', NULL, '3105567890'),
('Construcciones del Valle Ltda.', 'CVD Ltda.', 'ventas@cvdltda.cr', '+506 2256-8741', 'CR91015101235487965432', NULL, '3106678901'),
('AgroExportaciones del Norte S.A.', 'AgroNorte', 'export@agronorte.cr', '+506 2471-9832', 'CR27015406547832156984', NULL, '3107789012'),
('Servicios Médicos del Este S.A.', 'SME', 'contacto@sme.cr', '+506 2289-5647', 'CR37015305478965412345', NULL, '3108890123');

