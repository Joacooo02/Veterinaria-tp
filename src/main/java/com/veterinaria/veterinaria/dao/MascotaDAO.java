package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MascotaDAO {

    //Atributos
    private Connection con;

    //Constructor
    public MascotaDAO(Connection con) {
        this.con = ConectorSQL.crearConexion();
    }

    public void insertarMascota(Mascota mascota)
    {
        try {

            String sql = "INSERT INTO mascota (nombre,especie,raza,edad,peso,id_cliente) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement((sql));

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

	public Optional<Mascota> buscarMascota(int idMascota) {
		String sql = "SELECT * FROM mascota WHERE id_mascota = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
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

	public List<Mascota> mostrarMascotas() {
		List<Mascota> lista = new ArrayList<>();

		try {
			String sql = "SELECT * FROM mascota";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void actualizarMascota(Mascota m) {
		String sql = "UPDATE mascota SET nombre = ?, especie = ?, raza = ?, edad = ?, peso = ? WHERE id_mascota = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getEspecie());
			ps.setString(3, m.getRaza());
			ps.setInt(4, m.getEdad());
			ps.setDouble(5, m.getPeso());
			ps.setInt(6, m.getId_mascota());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void eliminarMascota(int idMascota)
    {
        String sql = "DELETE FROM mascota WHERE id_mascota = ? ";

        try (PreparedStatement ps = con.prepareStatement((sql))){

            ps.setInt(1,idMascota);
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Mascota> buscarPorCliente(int idCliente)
    {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascota WHERE id_cliente = ?";

        try (PreparedStatement ps = con.prepareStatement((sql))){

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Mascota m = new Mascota(rs.getInt("id_mascota"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getDouble("peso"),
                        rs.getInt("id_cliente")
                        );
                lista.add(m);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return lista;
    }

}
