package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeterinarioDAO {
    private Connection connection;

    public VeterinarioDAO() {
        this.connection = ConectorSQL.crearConexion();
    }

    public void insertarVeterinario(Veterinario veterinario) {
        String sql = "INSER INTO veterinarios" +
                "(id_veterinario, nombre, apellido, matricula, especialidad, telefono, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, veterinario.getId());
            pstm.setString(2, veterinario.getNombre());
            pstm.setString(3, veterinario.getApellido());
            pstm.setString(4, veterinario.getMatricula());
            pstm.setString(5, veterinario.getEspecialidad());
            pstm.setString(6, veterinario.getTelefono());
            pstm.setString(7, veterinario.getEmail());

            pstm.executeUpdate();
            System.out.println("Veterinario ingresado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
