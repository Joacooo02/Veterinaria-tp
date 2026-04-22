package com.veterinaria.veterinaria.controllerRest;

import com.veterinaria.veterinaria.dao.ClienteDAO;
import com.veterinaria.veterinaria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControllerRest {
	private ClienteDAO clienteDAO;

	@Autowired
	public ClienteControllerRest(DataSource dataSource) throws SQLException {
		this.clienteDAO = new ClienteDAO(dataSource.getConnection());
	}

	@PostMapping
	public void insertarCliente(@RequestBody Cliente cliente) {
		clienteDAO.insertarCliente(
				cliente.getNombre(),
				cliente.getApellido(),
				cliente.getTelefono(),
				cliente.getEmail(),
				cliente.getDireccion()
		);
	}

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteDAO.listarClientes();
	}

	@GetMapping("/{id}")
	public Cliente buscarClientePorId(@PathVariable("id") int id) {
		return clienteDAO.buscarClientePorId(id);
	}

	@PutMapping("/{id}")
	public void modificarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
		clienteDAO.modificarCliente(
				id,
				cliente.getNombre(),
				cliente.getApellido(),
				cliente.getTelefono(),
				cliente.getEmail(),
				cliente.getDireccion(),
				cliente.isActivo()
		);
	}

	@DeleteMapping("/{id}")
	public void eliminarCliente(@PathVariable int id) {
		clienteDAO.eliminarCliente(id);
	}
}