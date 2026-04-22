CREATE DATABASE veterinaria;
USE veterinaria;

CREATE TABLE cliente (
    id_cliente  INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(50)  NOT NULL,
    apellido    VARCHAR(50)  NOT NULL,
    telefono    VARCHAR(20)  NOT NULL,
    email       VARCHAR(100) NOT NULL,
    direccion   VARCHAR(150) NOT NULL,
    activo      BOOLEAN      NOT NULL
);

CREATE TABLE veterinario (
    id_veterinario INT AUTO_INCREMENT PRIMARY KEY,
    nombre         VARCHAR(50) NOT NULL,
    apellido       VARCHAR(50) NOT NULL,
    matricula      VARCHAR(50) NOT NULL,
    especialidad   VARCHAR(50),
    telefono       VARCHAR(50),
    email          VARCHAR(100)
);

CREATE TABLE mascota (
    id_mascota INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(50)    NOT NULL,
    especie    VARCHAR(30),
    raza       VARCHAR(30),
    edad       INT,
    peso       DECIMAL(5,2),
    id_cliente INT            NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

CREATE TABLE turno (
    id_turno       INT AUTO_INCREMENT PRIMARY KEY,
    fecha          DATE         NOT NULL,
    hora           TIME         NOT NULL,
    motivo         VARCHAR(255) NOT NULL,
    estado         ENUM('pendiente','confirmado','cancelado','atendido') NOT NULL DEFAULT 'pendiente',
    id_cliente     INT NOT NULL,
    FOREIGN KEY (id_cliente)     REFERENCES cliente(id_cliente)       ON DELETE CASCADE,
    id_veterinario INT NOT NULL,
    FOREIGN KEY (id_veterinario) REFERENCES veterinario(id_veterinario) ON DELETE CASCADE,
    id_mascota     INT NOT NULL,
    FOREIGN KEY (id_mascota)     REFERENCES mascota(id_mascota)       ON DELETE CASCADE
);


INSERT INTO cliente (nombre, apellido, telefono, email, direccion, activo) VALUES
('Juan',   'Pérez',  '2235556677', 'juan@mail.com',   'Av. Colón 123',  true),
('María',  'García', '2234445566', 'maria@mail.com',  'San Martín 456', true),
('Carlos', 'López',  '2236667788', 'carlos@mail.com', 'Belgrano 789',   false);

INSERT INTO veterinario (nombre, apellido, matricula, especialidad, telefono, email) VALUES
('Laura', 'Martínez',  'MP-1234', 'Clínica General', '2231112233', 'laura@vet.com'),
('Diego', 'Fernández', 'MP-5678', 'Dermatología',    '2232223344', 'diego@vet.com'),
('Sofía', 'Romero',    'MP-9012', 'Traumatología',   '2233334455', 'sofia@vet.com');

INSERT INTO mascota (nombre, especie, raza, edad, peso, id_cliente) VALUES
('Firulais', 'Perro', 'Labrador',      3, 28.50, 1),
('Michi',    'Gato',  'Siamés',        5,  4.20, 1),
('Rex',      'Perro', 'Pastor Alemán', 2, 32.00, 2),
('Pelusa',   'Gato',  'Persa',         7,  3.80, 3);

INSERT INTO turno (fecha, hora, motivo, estado, id_cliente, id_veterinario, id_mascota) VALUES
('2025-04-10', '09:00:00', 'Control anual',      'atendido',   1, 1, 1),
('2025-04-15', '10:30:00', 'Vacunación',         'atendido',   2, 2, 3),
('2025-04-22', '11:00:00', 'Revisión de piel',   'confirmado', 1, 2, 2),
('2025-04-25', '15:00:00', 'Cojea pata trasera', 'pendiente',  3, 3, 4),
('2025-05-01', '09:30:00', 'Castración',         'pendiente',  2, 1, 3);



