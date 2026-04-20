package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = ConectorSQL.crearConexion();
    }

    public void insertarCliente(String nombre,String apellido,String telefono,String email,String direccion){
        String sql = "INSERT INTO clientes (nombre,apellido,telefono,email,direccion) VALUES (?, ?, ?, ?, ?, true)";
        try{
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1,nombre);
            stmt.setString(2,apellido);
            stmt.setString(3,telefono);
            stmt.setString(4,email);
            stmt.setString(5,direccion);
            stmt.executeUpdate();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
