package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.MascotaDAO;
import com.veterinaria.veterinaria.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaControllerRest {
	private final MascotaDAO mascotaDAO;

	@Autowired
	public MascotaControllerRest(DataSource dataSource) {
		this.mascotaDAO = new MascotaDAO(dataSource);
	}

	@PostMapping
	public ResponseEntity<String> insertarMascota(@RequestBody Mascota mascota) {
		try {
			mascotaDAO.insertarMascota(mascota);
			return ResponseEntity.status(HttpStatus.CREATED).body("Mascota registrada exitosamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al registrar mascota: " + e.getMessage());
		}
	}

	@GetMapping
	public List<Mascota> listarMascotas() {
		return mascotaDAO.listarMascotas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mascota> buscarMascotaPorId(@PathVariable("id") int id) {
		return mascotaDAO.buscarMascotaporId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/cliente/{idCliente}")
	public List<Mascota> buscarMascotasPorCliente(@PathVariable("idCliente") int idCliente) {
		return mascotaDAO.buscarMascotaPorCliente(idCliente);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> modificarMascota(@PathVariable("id") int id, @RequestBody Mascota mascota) {
		try {
			mascota.setId_mascota(id);
			mascotaDAO.modificarMascota(mascota);
			return ResponseEntity.ok("Mascota " + id + " actualizada correctamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al actualizar: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarMascota(@PathVariable("id") int id) {
		try {
			mascotaDAO.eliminarMascota(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			// Si hay error (ej: tiene turnos), devuelve 500
			return ResponseEntity.internalServerError().build();
		}
	}
}
