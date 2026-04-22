package com.veterinaria.veterinaria.model;

public class Veterinario {
    private int id;
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;
    private String telefono;
    private String email;

    public Veterinario(int id, String nombre, String apellido, String matricula, String especialidad, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }

    public Veterinario(String nombre, String apellido, String matricula, String especialidad, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }

    public Veterinario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "Veterinario{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", matricula='" + matricula + '\'' +
				", especialidad='" + especialidad + '\'' +
				", telefono='" + telefono + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
