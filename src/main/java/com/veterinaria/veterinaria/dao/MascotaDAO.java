package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            ps.setString(1,);
            ps.setString(2,);
            ps.setString(3,);
            ps.setInt(4,);
            ps.setInt(5,);

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

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
