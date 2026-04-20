package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.VeterinarioDAO;
import com.veterinaria.veterinaria.model.Veterinario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioControllerRest {
    private final VeterinarioDAO vetDAO;

    public VeterinarioControllerRest(VeterinarioDAO vetDAO) {
        this.vetDAO = vetDAO;
    }

    @PostMapping
    public ResponseEntity<String> ingresarVeterinario(@RequestBody Veterinario nuevoVeterinario) {
        if(nuevoVeterinario.getNombre() == null || nuevoVeterinario.getNombre().trim().isEmpty()) {
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }

        vetDAO.insertarVeterinario(nuevoVeterinario);
        return new ResponseEntity<>("Veterinario creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos() {
        List<Veterinario> lista = vetDAO.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorID(@PathVariable int id) {
        Veterinario veterinario = vetDAO.obtenerPorID(id);

        if (veterinario != null) {
            return new ResponseEntity<>(veterinario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarVeterinario(@PathVariable int id, @RequestBody Veterinario vetActualizado) {
        Veterinario vetExistente = vetDAO.obtenerPorID(id);

        if(vetExistente == null) {
            return new ResponseEntity<>("Veterinario no encontrado.", HttpStatus.NOT_FOUND);
        }
        vetActualizado.setId(id);
        vetDAO.actualizarVeterinario(vetActualizado);

        return new ResponseEntity<>("Veterinario actualizado correctamente.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVeterinario(@PathVariable int id) {
        Veterinario vetExistente = vetDAO.obtenerPorID(id);

        if(vetExistente == null) {
            return new ResponseEntity<>("Veterinario no encontrado.", HttpStatus.NOT_FOUND);
        }

        vetDAO.eliminarVeterinario(id);
        return new ResponseEntity<>("Veterinario eliminado exitosamente. ", HttpStatus.OK);
    }
}
