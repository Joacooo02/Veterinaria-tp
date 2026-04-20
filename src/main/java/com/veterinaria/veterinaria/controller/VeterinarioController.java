package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dao.VeterinarioDAO;
import com.veterinaria.veterinaria.model.Veterinario;

import java.util.List;

public class VeterinarioController {
    private VeterinarioDAO veterinarioDAO;

    public VeterinarioController() {
        this.veterinarioDAO = new VeterinarioDAO();
    }

    public void insertarVeterinario(String nombre, String apellido, String matricula, String especialidad, String telefono, String email) {
        Veterinario veterinario = new Veterinario(nombre, apellido, matricula, especialidad, telefono, email);
        veterinarioDAO.insertarVeterinario(veterinario);
    }

    public List<Veterinario> obtenerTodos() {
        return veterinarioDAO.obtenerTodos();
    }

    public Veterinario buscarPorID(int id) {
        if(id <= 0) {
            System.err.println("Error. El ID debe ser un numero mayor a 0. ");
            return null;
        }
        return veterinarioDAO.obtenerPorID(id);
    }

    public boolean modificarVeterinario(String nombre, String apellido, String matricula, String especialidad, String telefono, String email, int id) {
        Veterinario vetExistente = veterinarioDAO.obtenerPorID(id);
        if(vetExistente == null) {
            System.err.println("Error. El veterinario no existe. ");
            return false;
        }
        vetExistente.setNombre(nombre);
        vetExistente.setApellido(apellido);
        vetExistente.setMatricula(matricula);
        vetExistente.setEspecialidad(especialidad);
        vetExistente.setTelefono(telefono);
        vetExistente.setEmail(email);
        vetExistente.setId(id);

        veterinarioDAO.actualizarVeterinario(vetExistente);
        return true;
    }

    public boolean eliminarVeterinario(int id) {
        if(id <= 0) {
            System.err.println("Error. El ID debe ser un numero mayor a 0. ");
            return false;
        }

        if(buscarPorID(id) == null) {
            System.err.println("Error. El veterinario no existe. ");
            return false;
        }

        veterinarioDAO.eliminarVeterinario(id);
        return true;
    }
}
