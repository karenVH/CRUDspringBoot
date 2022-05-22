-- --------------------------------------
-- Eliminar base de datos
-- --------------------------------------
DROP DATABASE IF EXISTS contactdb;
-- --------------------------------------
-- Creacion de base de datos
-- --------------------------------------
CREATE DATABASE contactdb;
-- --------------------------------------
-- Usando base de datos
-- --------------------------------------
USE contactdb;

-- ---------------------------------------------------------------------
-- Crear tabla de contactos
-- id, nombre, apellido, numero de telefono, correo. fecha de nacimiento
-- -------------------------------------- ------------------------------
CREATE TABLE contacts(
    idContact INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NULL,
    lastName VARCHAR(50) NULL,
    cellPhone VARCHAR(20) NULL,
    email VARCHAR(256) NULL,
    dateBirth DATE NULL,
    PRIMARY KEY (idContact)
)
ENGINE = InnoDB;

-- ---------------------------------------------
-- Una consulta para ver los datos
-- ---------------------------------------------
SELECT * FROM contacts

-- ---------------------------------------------
-- Una consulta para insertar datos
-- ---------------------------------------------
INSERT INTO contacts(name,lastName,cellPhone,email,dateBirth)
 VALUES  ('Jackie','Chandler',7863346396,'Jackie.Chandler@gmail.com','1988-12-16');