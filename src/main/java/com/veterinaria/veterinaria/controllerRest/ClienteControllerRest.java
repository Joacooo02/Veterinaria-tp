package com.veterinaria.veterinaria.ControllerRest;

import com.veterinaria.veterinaria.dao.ClienteDAO;
import com.veterinaria.veterinaria.model.Cliente;
import com.veterinaria.veterinaria.model.ConectorSQL;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

public class ClienteControllerRest {
	@RestController
	@RequestMapping("/clientes")
	public class ClienteController {
		private Connection conexion;
		private ClienteDAO clienteDAO;

		public ClienteController() {
			this.conexion = ConectorSQL.crearConexion();
			this.clienteDAO = new ClienteDAO(conexion);
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
		public Cliente buscarClientePorId(@PathVariable int id) {
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
}
