CREATE DATABASE veterinaria;
USE veterinaria;

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY, 
    nombre VARCHAR(50) NOT NULL,       
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    activo boolean NOT NULL
);


CREATE TABLE veterinarios (
    id_veterinario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    matricula VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50),     
    telefono VARCHAR(50),     
    email VARCHAR(50)   
);


CREATE TABLE mascotas (
    id_mascota INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    especie VARCHAR(30),
    raza VARCHAR(30),
    edad int,
    peso int,
    
    id_cliente INT NOT NULL,           
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE turnos (
    id_turno INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    motivo VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES mascotas(id_cliente) ON DELETE CASCADE,
    
    id_veterinario INT NOT NULL,
    FOREIGN KEY (id_veterinario) REFERENCES veterinarios(id_veterinario) ON DELETE CASCADE,
    
    id_mascota INT NOT NULL,
    FOREIGN KEY (id_mascota) REFERENCES mascotas(id_mascota) ON DELETE CASCADE
);