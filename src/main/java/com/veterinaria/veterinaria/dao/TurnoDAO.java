package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.EstadoTurno;
import com.veterinaria.veterinaria.model.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
    private Connection conexion;

    public TurnoDAO(Connection conexion) {
        this.conexion = ConectorSQL.crearConexion();
    }

	public void insertarTurno(Turno turno) {
		String sql = "INSERT INTO turno (fecha, hora, motivo, estado, id_cliente, id_veterinario, id_mascota) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(turno.getFecha()));
			stmt.setTime(2, Time.valueOf(turno.getHora()));
			stmt.setString(3, turno.getMotivo());
			stmt.setString(4, turno.getEstado().toString().toLowerCase());
			stmt.setInt(5, turno.getIdCliente());
			stmt.setInt(6, turno.getIdVeterinario());
			stmt.setInt(7, turno.getIdMascota());
			stmt.executeUpdate();
			System.out.println("Turno ingresado exitosamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Turno> obtenerTodos() {
		List<Turno> listaTurnos = new ArrayList<>();
		String sql = "SELECT * FROM turno";

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Turno turno = new Turno();
				turno.setIdTurno(rs.getInt("id_turno"));
				turno.setFecha(rs.getDate("fecha").toLocalDate());
				turno.setHora(rs.getTime("hora").toLocalTime());
				turno.setMotivo(rs.getString("motivo"));
				turno.setEstado(EstadoTurno.valueOf(rs.getString("estado").toUpperCase()));
				turno.setIdCliente(rs.getInt("id_cliente"));
				turno.setIdVeterinario(rs.getInt("id_veterinario"));
				turno.setIdMascota(rs.getInt("id_mascota"));
				listaTurnos.add(turno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTurnos;
	}

	public Turno obtenerPorID(int id_turno) {
		Turno turno = null;
		String sql = "SELECT * FROM turno WHERE id_turno = ?";

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			stmt.setInt(1, id_turno);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					turno.setIdTurno(rs.getInt("id_turno"));
					turno.setFecha(rs.getDate("fecha").toLocalDate());
					turno.setHora(rs.getTime("hora").toLocalTime());
					turno.setMotivo(rs.getString("motivo"));
					turno.setEstado(EstadoTurno.valueOf(rs.getString("estado").toUpperCase()));
					turno.setIdCliente(rs.getInt("id_cliente"));
					turno.setIdVeterinario(rs.getInt("id_veterinario"));
					turno.setIdMascota(rs.getInt("id_mascota"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al mostrar el turno por ID: " + e.getMessage());
		}
		return turno;
	}

	public void actualizarEstadoDeTurno(int id_turno, EstadoTurno estadoTurno) {
		String sql = "UPDATE turno SET estado = ? WHERE id_turno = ?";

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			stmt.setString(1, estadoTurno.toString().toLowerCase());
			stmt.setInt(2, id_turno);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Estado del turno actualizado exitosamente.");
			} else {
				System.out.println("No se encontró el turno para actualizar.");
			}
		} catch (SQLException e) {
			System.err.println("Error al actualizar el estado del turno: " + e.getMessage());
		}
	}

	public void eliminarTurno(int id_turno) {
		String sql = "DELETE FROM turno WHERE id_turno = ?";

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			stmt.setInt(1, id_turno);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Turno eliminado exitosamente.");
			} else {
				System.out.println("No se encontró el turno para eliminar.");
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar el turno: " + e.getMessage());
		}
	}
}

