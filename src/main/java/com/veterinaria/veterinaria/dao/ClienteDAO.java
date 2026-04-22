package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.Cliente;
import com.veterinaria.veterinaria.model.ConectorSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = ConectorSQL.crearConexion();
    }

    public void insertarCliente(String nombre,String apellido,String telefono,String email,String direccion){
	    String sql = "INSERT INTO cliente (nombre,apellido,telefono,email,direccion,activo) VALUES (?, ?, ?, ?, ?, true)";
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

	public List<Cliente> listarClientes() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";

		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("telefono"),
						rs.getString("email"),
						rs.getString("direccion"),
						rs.getBoolean("activo")
				);
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public Cliente buscarClientePorId(int idCliente) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				cliente = new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("telefono"),
						rs.getString("email"),
						rs.getString("direccion"),
						rs.getBoolean("activo")
				);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public void modificarCliente(int idCliente, String nombre, String apellido, String telefono, String email, String direccion, boolean activo) {
		String sql = "UPDATE cliente SET nombre=?, apellido=?, telefono=?, email=?, direccion=?, activo=? WHERE id_cliente=?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setString(3, telefono);
			stmt.setString(4, email);
			stmt.setString(5, direccion);
			stmt.setBoolean(6, activo);
			stmt.setInt(7, idCliente);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarCliente(int idCliente) {
		String sql = "DELETE FROM cliente WHERE id_cliente=?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
