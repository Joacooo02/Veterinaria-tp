package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.EstadoTurno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TurnoDAO {
    private Connection conexion;

    public TurnoDAO(Connection conexion) {
        this.conexion = ConectorSQL.crearConexion();
    }

    public void insertarTurno(String motivo, EstadoTurno estado){
        String sql = "INSERT INTO turnos (motivo,estado) VALUES (?, ?)";
        try{
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1,motivo);
            stmt.setString(2,estado.getClass().getName());
        }catch (SQLException e){
            e.printStackTrace();
        }



    }



}
