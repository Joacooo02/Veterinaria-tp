package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.VeterinarioDAO;
import com.veterinaria.veterinaria.model.Turno;
import com.veterinaria.veterinaria.model.Veterinario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioControllerRest {
    private final VeterinarioDAO vetDAO;

    public VeterinarioControllerRest(DataSource dataSource) {
        this.vetDAO = new VeterinarioDAO(dataSource);
    }

	@GetMapping
	public List<Veterinario> listarVeterinarios(){
		return vetDAO.listarVeterinarios();
	}

	@PostMapping
	public ResponseEntity<String> insertarVeterinario(@RequestBody Veterinario vet) {
		try {
			vetDAO.insertarVeterinario(vet);
			return ResponseEntity.status(HttpStatus.CREATED).body("Veterinario creado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al crear veterinario: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veterinario> buscarVeterinarioPorId(@PathVariable("id") int id) {
		Veterinario vet = vetDAO.buscarVeterinarioPorId(id);
		return vet != null ? ResponseEntity.ok(vet) : ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> modificarVeterinario(@PathVariable("id") int id, @RequestBody Veterinario vet) {
		try {
			vet.setId(id);
			vetDAO.modificarVeterinario(vet);
			return ResponseEntity.ok("Veterinario " + id + " actualizado correctamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al actualizar: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarVeterinario(@PathVariable("id") int id) {
		try {
			vetDAO.eliminarVeterinario(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
