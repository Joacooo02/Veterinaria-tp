package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.ClienteDAO;
import com.veterinaria.veterinaria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControllerRest {
	private final ClienteDAO clienteDAO;

	@Autowired
	public ClienteControllerRest(DataSource dataSource) {
		this.clienteDAO = new ClienteDAO(dataSource);
	}

	@PostMapping
	public ResponseEntity<String> insertarCliente(@RequestBody Cliente cliente) {
		try {
			clienteDAO.insertarCliente(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al crear cliente: " + e.getMessage());
		}
	}

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteDAO.listarClientes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") int id) {
		Cliente cliente = clienteDAO.buscarClientePorId(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> modificarCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
		try {
			cliente.setId(id);
			clienteDAO.modificarCliente(cliente);
			return ResponseEntity.ok("Cliente " + id + " actualizado correctamente");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error al actualizar: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCliente(@PathVariable("id") int id) {
		try {
			clienteDAO.eliminarCliente(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}