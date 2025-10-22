CREATE TABLE Proveedor (
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
