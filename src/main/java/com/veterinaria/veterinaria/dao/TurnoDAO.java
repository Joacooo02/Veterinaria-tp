package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.EstadoTurno;
import com.veterinaria.veterinaria.model.Turno;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
	private final DataSource dataSource;

	public TurnoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertarTurno(Turno turno) {
		String sql = "INSERT INTO turno (fecha, hora, motivo, estado, id_cliente, id_veterinario, id_mascota) VALUES (?,?,?,?,?,?,?)";
		try(Connection conexion = dataSource.getConnection();
		    PreparedStatement stmt = conexion.prepareStatement(sql))
		{

			stmt.setDate(1, Date.valueOf(turno.getFecha()));
			stmt.setTime(2, Time.valueOf(turno.getHora()));
			stmt.setString(3, turno.getMotivo());
			stmt.setString(4, turno.getEstado().toString().toLowerCase());
			stmt.setInt(5, turno.getIdCliente());
			stmt.setInt(6, turno.getIdVeterinario());
			stmt.setInt(7, turno.getIdMascota());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Turno> listarTurnos() {
		List<Turno> listaTurnos = new ArrayList<>();
		String sql = "SELECT * FROM turno";

		try (Connection conexion = dataSource.getConnection();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery())
		{
			while (rs.next()) {
				Turno turno = new Turno();
				turno.setIdTurno(rs.getInt("id_turno"));
				turno.setFecha(rs.getDate("fecha").toLocalDate());
				turno.setHora(rs.getTime("hora").toLocalTime());
				turno.setMotivo(rs.getString("motivo"));
				turno.setEstado(EstadoTurno.valueOf(rs.getString("estado")));
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

	public Turno buscarTurnoPorId(int id_turno) {
		Turno turno = null;
		String sql = "SELECT * FROM turno WHERE id_turno = ?";

		try (Connection conexion = dataSource.getConnection();
			PreparedStatement stmt = conexion.prepareStatement(sql))
		{
			stmt.setInt(1, id_turno);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					turno = new Turno(
					rs.getInt("id_turno"),
					rs.getDate("fecha").toLocalDate(),
					rs.getTime("hora").toLocalTime(),
					rs.getString("motivo"),
					EstadoTurno.valueOf(rs.getString("estado")),
					rs.getInt("id_cliente"),
					rs.getInt("id_veterinario"),
					rs.getInt("id_mascota")
					);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turno;
	}

	public void modificarTurno(Turno turno) {
		StringBuilder sql = new StringBuilder("UPDATE turno SET ");
		List<Object> parametros = new ArrayList<>();

		if (turno.getFecha() != null) {
			sql.append("fecha=?, ");
			parametros.add(java.sql.Date.valueOf(turno.getFecha()));
		}
		if (turno.getHora() != null) {
			sql.append("hora=?, ");
			parametros.add(java.sql.Time.valueOf(turno.getHora()));
		}
		if (turno.getMotivo() != null) {
			sql.append("motivo=?, ");
			parametros.add(turno.getMotivo());
		}
		if (turno.getEstado() != null) {
			sql.append("estado=?, ");
			parametros.add(turno.getEstado().name());
		}
		if (turno.getIdCliente() > 0) {
			sql.append("id_cliente=?, ");
			parametros.add(turno.getIdCliente());
		}
		if (turno.getIdVeterinario() > 0) {
			sql.append("id_veterinario=?, ");
			parametros.add(turno.getIdVeterinario());
		}
		if (turno.getIdMascota() > 0) {
			sql.append("id_mascota=?, ");
			parametros.add(turno.getIdMascota());
		}

		sql.setLength(sql.length() - 2);
		sql.append(" WHERE id_turno=?");
		parametros.add(turno.getIdTurno());

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql.toString())) {

			for (int i = 0; i < parametros.size(); i++) {
				stmt.setObject(i + 1, parametros.get(i));
			}

			int filasAfectadas = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarTurno(int id_turno) {
		String sql = "DELETE FROM turno WHERE id_turno = ?";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setInt(1, id_turno);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

