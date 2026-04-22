package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.Mascota;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MascotaDAO {

    //Atributos
    private final DataSource dataSource;

	//Constructor
	public MascotaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public void insertarMascota(Mascota mascota)
    {
	    String sql = "INSERT INTO mascota (nombre,especie,raza,edad,peso,id_cliente) VALUES (?,?,?,?,?,?)";
        try(Connection conexion = dataSource.getConnection();
	    PreparedStatement ps = conexion.prepareStatement(sql))
	    {
            ps.setString(1,mascota.getNombre());
            ps.setString(2,mascota.getEspecie());
            ps.setString(3,mascota.getRaza());
            ps.setInt(4,mascota.getEdad());
            ps.setDouble(5,mascota.getPeso());
            ps.setInt(6,mascota.getId_cliente());

            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

	public Optional<Mascota> buscarMascotaporId(int idMascota) {
		String sql = "SELECT * FROM mascota WHERE id_mascota = ?";

		try (Connection conexion = dataSource.getConnection();
			PreparedStatement ps = conexion.prepareStatement(sql))
		{
			ps.setInt(1, idMascota);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Mascota m = new Mascota(
						rs.getInt("id_mascota"),
						rs.getString("nombre"),
						rs.getString("especie"),
						rs.getString("raza"),
						rs.getInt("edad"),
						rs.getDouble("peso"),
						rs.getInt("id_cliente")
				);
				return Optional.of(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public List<Mascota> listarMascotas() {
		List<Mascota> lista = new ArrayList<>();
		String sql = "SELECT * FROM mascota";

		try(Connection conexion = dataSource.getConnection();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery())
		{
			while (rs.next()) {
				Mascota m = new Mascota(
						rs.getInt("id_mascota"),
						rs.getString("nombre"),
						rs.getString("especie"),
						rs.getString("raza"),
						rs.getInt("edad"),
						rs.getDouble("peso"),
						rs.getInt("id_cliente")
				);
				lista.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void modificarMascota(Mascota m) {
		StringBuilder sql = new StringBuilder("UPDATE mascota SET ");
		List<Object> parametros = new ArrayList<>();

		if (m.getNombre() != null) {
			sql.append("nombre=?, ");
			parametros.add(m.getNombre());
		}
		if (m.getEspecie() != null) {
			sql.append("especie=?, ");
			parametros.add(m.getEspecie());
		}
		if (m.getRaza() != null) {
			sql.append("raza=?, ");
			parametros.add(m.getRaza());
		}

		if (m.getEdad() > 0) {
			sql.append("edad=?, ");
			parametros.add(m.getEdad());
		}
		if (m.getPeso() > 0) {
			sql.append("peso=?, ");
			parametros.add(m.getPeso());
		}

		if (m.getId_cliente() > 0) {
			sql.append("id_cliente=?, ");
			parametros.add(m.getId_cliente());
		}

		sql.setLength(sql.length() - 2);

		sql.append(" WHERE id_mascota=?");
		parametros.add(m.getId_mascota());

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

    public void eliminarMascota(int idMascota)
    {
        String sql = "DELETE FROM mascota WHERE id_mascota = ? ";

        try (Connection conexion = dataSource.getConnection()){
	    PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,idMascota);
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

	public List<Mascota> buscarMascotaPorCliente(int idCliente) {
		List<Mascota> lista = new ArrayList<>();
		String sql = "SELECT * FROM mascota WHERE id_cliente = ?";

		try (Connection conexion = dataSource.getConnection();
		     PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setInt(1, idCliente);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Mascota m = new Mascota(
							rs.getInt("id_mascota"),
							rs.getString("nombre"),
							rs.getString("especie"),
							rs.getString("raza"),
							rs.getInt("edad"),
							rs.getDouble("peso"),
							rs.getInt("id_cliente")
					);
					lista.add(m);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
