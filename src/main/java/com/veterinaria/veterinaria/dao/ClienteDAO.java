package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class ClienteDAO {
	private final DataSource dataSource;

	public ClienteDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertarCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (nombre, apellido, telefono, email, direccion, activo) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setString(3, cliente.getTelefono());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getDireccion());
			stmt.setBoolean(6, true);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listarClientes() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery()) {

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public Cliente buscarClientePorId(int idCliente) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setInt(1, idCliente);
			try (ResultSet rs = stmt.executeQuery()) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public void modificarCliente(Cliente cliente) {
		StringBuilder sql = new StringBuilder("UPDATE cliente SET ");
		List<Object> parametros = new ArrayList<>();

		if (cliente.getNombre() != null) {
			sql.append("nombre=?, ");
			parametros.add(cliente.getNombre());
		}
		if (cliente.getApellido() != null) {
			sql.append("apellido=?, ");
			parametros.add(cliente.getApellido());
		}
		if (cliente.getTelefono() != null) {
			sql.append("telefono=?, ");
			parametros.add(cliente.getTelefono());
		}
		if (cliente.getEmail() != null) {
			sql.append("email=?, ");
			parametros.add(cliente.getEmail());
		}
		if (cliente.getDireccion() != null) {
			sql.append("direccion=?, ");
			parametros.add(cliente.getDireccion());
		}
		if (cliente.getActivo() != null) {
			sql.append("activo=?, ");
			parametros.add(cliente.getActivo());
		}

		sql.setLength(sql.length() - 2);
		sql.append(" WHERE id_cliente=?");
		parametros.add(cliente.getId());

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql.toString())) {

			for (int i = 0; i < parametros.size(); i++) {
				stmt.setObject(i + 1, parametros.get(i));
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarCliente(int idCliente) {
		String sql = "DELETE FROM cliente WHERE id_cliente=?";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setInt(1, idCliente);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

