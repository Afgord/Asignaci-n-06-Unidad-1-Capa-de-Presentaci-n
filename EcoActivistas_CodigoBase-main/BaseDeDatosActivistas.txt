-- Crear la base de datos
CREATE DATABASE EcoActivistasDB;
USE EcoActivistasDB;

-- Tabla Cliente
CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(150),
    telefonos VARCHAR(50)
);

-- Tabla Problema
CREATE TABLE Problema (
    idProblema INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT,
    fch_ini DATE NOT NULL,
    fch_fin DATE,
    estado ENUM('pendiente','concluido','cancelado') NOT NULL,
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

-- Tabla Activista
CREATE TABLE Activista (
    idActivista INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(50),
    fchIngreso DATE NOT NULL
);

-- Tabla intermedia Problema_Activista (NM)
CREATE TABLE Problema_Activista (
    idProblema INT NOT NULL,
    idActivista INT NOT NULL,
    PRIMARY KEY (idProblema, idActivista),
    FOREIGN KEY (idProblema) REFERENCES Problema(idProblema),
    FOREIGN KEY (idActivista) REFERENCES Activista(idActivista)
);