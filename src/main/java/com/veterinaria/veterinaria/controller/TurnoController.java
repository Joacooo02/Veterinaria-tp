package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dao.TurnoDAO;
import com.veterinaria.veterinaria.model.Turno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")

public class TurnoController {
    private TurnoDAO turnoDAO = new TurnoDAO(null);

    @GetMapping
    public List<Turno> obtenerTodosLosTurnos(){
        return turnoDAO.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Turno obtenerTurnoPorId(@PathVariable("id") int id_turno){
        return turnoDAO.obtenerPorID(id_turno);
    }

    @PostMapping
    public String crearTurno(@RequestBody Turno turno){
        turnoDAO.insertarTurno(turno.getMotivo(), turno.getId_cliente(), turno.getId_mascota());
        return "Turno creado exitosamente";
    }

    @DeleteMapping("/{id}")
    public String eliminarTurno(@PathVariable("id") int id_turno){
        turnoDAO.eliminarTurno(id_turno);
        return "Turno eliminado exitosamente";
    }



}
