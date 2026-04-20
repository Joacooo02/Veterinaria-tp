package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                Mascota m = new Mascota(rs.getInt("id_mascota"), rs.getString("nombre"), rs.getString("especie"), rs.getString("raza"), rs.getInt("edad"), rs.getInt("peso"));
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

    public List<Mascota> mostrarMascotas()
    {
        List<Mascota> lista = new ArrayList<>();
        Mascota m = null;
        try {
            String sql = "SELECT * FROM mascotas";
            PreparedStatement ps = con.prepareStatement((sql));

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                 m = new Mascota(rs.getInt("id_mascota"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getInt("peso"));
                 lista.add(m);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizarMascota(Mascota m)
    {
        String sql = "UPDATE mascotas SET nombre = ?, especie = ?, raza = ?, edad = ?, peso = ? WHERE id_mascota = ?";

        try (PreparedStatement ps = con.prepareStatement((sql))){

            ps.setString(1,m.getNombre());
            ps.setString(2,m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4,m.getEdad());
            ps.setInt(5,m.getPeso());
            ps.setInt(6,m.getId_mascota());
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void eliminarMascota(int idMascota)
    {
        String sql = "DELETE FROM mascotas WHERE id_mascota = ? ";

        try (PreparedStatement ps = con.prepareStatement((sql))){

            ps.setInt(1,idMascota);
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
