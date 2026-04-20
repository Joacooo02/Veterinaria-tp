package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.EstadoTurno;
import com.veterinaria.veterinaria.model.Turno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
    private Connection conexion;

    public TurnoDAO(Connection conexion) {
        this.conexion = ConectorSQL.crearConexion();
    }

    public void insertarTurno(String motivo, int id_cliente, int id_mascota){
        String sql = "INSERT INTO turnos (motivo, id_cliente, id_mascota) VALUES (?, ?, ?)";
        try{
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, motivo);
            stmt.setInt(2, id_cliente);
            stmt.setInt(3, id_mascota);

            stmt.executeUpdate();
            System.out.println("Turno ingresado exitosamente.");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Turno> obtenerTodos(){
        List<Turno> listaTurnos = new ArrayList<>();
        String sql = "SELECT * FROM turnos";

        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery(); {
                while(rs.next()) {
                    Turno turno = new Turno();

                    turno.setId_turno(rs.getInt("id_turno"));
                    turno.setFecha_hora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                    turno.setMotivo(rs.getString("motivo"));
                    turno.setEstado(EstadoTurno.valueOf(rs.getString("estado")));
                    turno.setId_cliente(rs.getInt("id_cliente"));
                    turno.setId_veterinario(rs.getInt("id_veterinario"));
                    turno.setId_mascota(rs.getInt("id_mascota"));

                    listaTurnos.add(turno);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaTurnos;
    }

    public Turno obtenerPorID(int id_turno){
        Turno turno = null;
        String sql = "SELECT * FROM turnos WHERE id_turno = ?";

        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id_turno);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    turno.setId_turno(rs.getInt("id_turno"));
                    turno.setFecha_hora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                    turno.setMotivo(rs.getString("motivo"));
                    turno.setEstado(EstadoTurno.valueOf(rs.getString("estado")));
                    turno.setId_cliente(rs.getInt("id_cliente"));
                    turno.setId_veterinario(rs.getInt("id_veterinario"));
                    turno.setId_mascota(rs.getInt("id_mascota"));
                }
            }
        }catch (SQLException e){
            System.err.println("Error al mostrar el turno por ID: " + e.getMessage());
        }
        return turno;
    }

    public void actualizarEstadoDeTurno(int id_turno, EstadoTurno estadoTurno){
        String sql = "UPDATE turnos SET estado = ? WHERE id_turno = ?";

        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, estadoTurno.toString());
            stmt.setInt(2, id_turno);

            int filasAfectadas = stmt.executeUpdate();
            if(filasAfectadas > 0){
                System.out.println("Estado del turno actualizado exitosamente.");
            } else{
                System.out.println("No se encontró el turno para actualizar.");
            }
        } catch(SQLException e){
            System.err.println("Error al actualizar el estado del turno" + e.getMessage());
        }
    }

    public void eliminarTurno(int id_turno){
        String sql = "DELETE FROM turnos WHERE id_turno = ?";

        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id_turno);

            int filasAfectadas = stmt.executeUpdate();
            if(filasAfectadas > 0){
                System.out.println("Estado del turno eliminado exitosamente.");
            } else{
                System.out.println("No se encontró el turno para eliminar.");
            }
        } catch(SQLException e){
            System.err.println("Error al eliminar el estado del turno" + e.getMessage());
        }
   }
}
