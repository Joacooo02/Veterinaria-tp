package com.veterinaria.veterinaria.model;

public class Mascota {

    //TIP
    // CREATE TABLE mascotas (
    //    id_mascota INT AUTO_INCREMENT PRIMARY KEY,
    //    nombre VARCHAR(50) NOT NULL,
    //    especie VARCHAR(30),
    //    raza VARCHAR(30),
    //    edad int,
    //    peso int,
    //
    //    id_cliente INT NOT NULL,
    //    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
    //);

    private int id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private int peso;
    private int id_cliente;

    public Mascota(String nombre, String especie, String raza, int edad, int peso, int id_cliente) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id_cliente = id_cliente;
    }

    public int getId_mascota() {
        return id_mascota;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_cliente() {
        return id_cliente;
    }


}
