package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {
    private Connection connection;

    public VeterinarioDAO() {
        this.connection = ConectorSQL.crearConexion();
    }

    public void insertarVeterinario(Veterinario veterinario) {
        String sql = "INSERT INTO veterinarios" +
                "(nombre, apellido, matricula, especialidad, telefono, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, veterinario.getNombre());
            pstm.setString(2, veterinario.getApellido());
            pstm.setString(3, veterinario.getMatricula());
            pstm.setString(4, veterinario.getEspecialidad());
            pstm.setString(5, veterinario.getTelefono());
            pstm.setString(6, veterinario.getEmail());

            pstm.executeUpdate();
            System.out.println("Veterinario ingresado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veterinario> obtenerTodos() {
        List<Veterinario> listaVeterinarios = new ArrayList<>();
        String sql = "SELECT * FROM veterinarios";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery(); {
                while (rs.next()) {
                    Veterinario veterinario = new Veterinario();

                    veterinario.setId(rs.getInt("id_veterinario"));
                    veterinario.setNombre(rs.getString("nombre"));
                    veterinario.setApellido(rs.getString("apellido"));
                    veterinario.setMatricula(rs.getString("matricula"));
                    veterinario.setEspecialidad(rs.getString("especialidad"));
                    veterinario.setTelefono(rs.getString("telefono"));
                    veterinario.setEmail(rs.getString("email"));

                    listaVeterinarios.add(veterinario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVeterinarios;
    }

    
}
