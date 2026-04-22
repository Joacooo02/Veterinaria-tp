package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.Veterinario;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class VeterinarioDAO {
	private final DataSource dataSource;

	public VeterinarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public void insertarVeterinario(Veterinario veterinario) {
        String sql = "INSERT INTO veterinario" +
                "(nombre, apellido, matricula, especialidad, telefono, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
				PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, veterinario.getNombre());
            pstm.setString(2, veterinario.getApellido());
            pstm.setString(3, veterinario.getMatricula());
            pstm.setString(4, veterinario.getEspecialidad());
            pstm.setString(5, veterinario.getTelefono());
            pstm.setString(6, veterinario.getEmail());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veterinario> listarVeterinarios() {
        List<Veterinario> listaVeterinarios = new ArrayList<>();
        String sql = "SELECT * FROM veterinario";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery())
        {
            {
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

    public Veterinario buscarVeterinarioPorId(int id) {
        Veterinario veterinario = null;
        String sql = "SELECT * FROM veterinario WHERE id_veterinario = ?";

        try(Connection connection = dataSource.getConnection();
				PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()) {
                    veterinario.setId(rs.getInt("id_veterinario"));
                    veterinario.setNombre(rs.getString("nombre"));
                    veterinario.setApellido(rs.getString("apellido"));
                    veterinario.setMatricula(rs.getString("matricula"));
                    veterinario.setEspecialidad(rs.getString("especialidad"));
                    veterinario.setTelefono(rs.getString("telefono"));
                    veterinario.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
        }
        return veterinario;
    }

	public void modificarVeterinario(Veterinario v) {
		StringBuilder sql = new StringBuilder("UPDATE veterinario SET ");
		List<Object> parametros = new ArrayList<>();

		if (v.getNombre() != null) {
			sql.append("nombre=?, ");
			parametros.add(v.getNombre());
		}
		if (v.getApellido() != null) {
			sql.append("apellido=?, ");
			parametros.add(v.getApellido());
		}
		if (v.getMatricula() != null) {
			sql.append("matricula=?, ");
			parametros.add(v.getMatricula());
		}
		if (v.getEspecialidad() != null) {
			sql.append("especialidad=?, ");
			parametros.add(v.getEspecialidad());
		}
		if (v.getTelefono() != null) {
			sql.append("telefono=?, ");
			parametros.add(v.getTelefono());
		}
		if (v.getEmail() != null) {
			sql.append("email=?, ");
			parametros.add(v.getEmail());
		}

		sql.setLength(sql.length() - 2);
		sql.append(" WHERE id=?");
		parametros.add(v.getId());

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

    public void eliminarVeterinario(int id) {
        String sql = "DELETE FROM veterinario WHERE id_veterinario = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
			pstm.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
        }
    }

}
