package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.TurnoDAO;
import com.veterinaria.veterinaria.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/turnos")

public class TurnoControllerRest {
    private final TurnoDAO turnoDAO;

	public TurnoControllerRest(DataSource dataSource) {
		this.turnoDAO = new TurnoDAO(dataSource);
	}

	@GetMapping
    public List<Turno> listarTurnos(){
        return turnoDAO.listarTurnos();
    }

	@PostMapping
	public ResponseEntity<String> insertarTurno(@RequestBody Turno turno) {
		try {
			turnoDAO.insertarTurno(turno);
			return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al crear turno: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turno> buscarTurnoPorId(@PathVariable("id") int id) {
		Turno turno = turnoDAO.buscarTurnoPorId(id);
		return turno != null ? ResponseEntity.ok(turno) : ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> modificarTurno(@PathVariable("id") int id, @RequestBody Turno turno) {
		try {
			turno.setIdTurno(id);
			turnoDAO.modificarTurno(turno);
			return ResponseEntity.ok("Turno " + id + " actualizado correctamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al actualizar: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTurno(@PathVariable("id") int id) {
		try {
			turnoDAO.eliminarTurno(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/veterinario/{id}")
	public ResponseEntity<List<Turno>> buscarTurnosPorVeterinario(@PathVariable("id") int idVet) {
		List<Turno> turnos = turnoDAO.buscarTurnosPorVeterinario(idVet);

		if (turnos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(turnos);
	}

	@GetMapping("/detallado")
	public ResponseEntity<List<TurnoDetalladoDTO>> listarTurnosDetallados() {
		List<TurnoDetalladoDTO> detallados = turnoDAO.listarTurnosDetallados();

		if (detallados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(detallados);
	}

}