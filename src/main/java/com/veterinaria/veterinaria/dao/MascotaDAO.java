package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            String sql = "INSERT INTO mascotas (nombre,especie,raza,edad,peso) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement((sql));

            ps.setString(1,mascota.getNombre());
            ps.setString(2,mascota.getEspecie());
            ps.setString(3,mascota.getRaza());
            ps.setInt(4,mascota.getEdad());
            ps.setInt(5,mascota.getPeso());

            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Optional<Mascota> buscarMascota(int idMascota)
    {
        String sql = "SELECT * FROM mascotas WHERE id_mascota = ?";

        try(PreparedStatement ps = con.prepareStatement((sql)))
        {
            ps.setInt(1,idMascota);
            ResultSet rs =ps.executeQuery();

            if(rs.next())
            {
                Mascota m = new Mascota();
                m.setId_mascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setEdad(rs.getInt("edad"));
                m.setPeso(rs.getInt("peso"));

                return Optional.of(m);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void mostrarMascotas()
    {

        //comentario de prueba el commit
    }
}
