package com.veterinaria.veterinaria.model;

public class Mascota {

    private int id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private double peso;
    private int id_cliente;


    public Mascota(String nombre, String especie, String raza, int edad, double peso, int id_cliente) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id_cliente = id_cliente;
    }

    public Mascota(int id_mascota, String nombre, String especie, String raza, int edad, double peso, int id_cliente) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id_cliente = id_cliente;
    }

	public Mascota() {
	}

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id_mascota=" + id_mascota +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", id_cliente=" + id_cliente;
    }
}