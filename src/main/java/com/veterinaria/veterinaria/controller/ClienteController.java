package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dao.ClienteDAO;
import com.veterinaria.veterinaria.model.Cliente;
import com.veterinaria.veterinaria.model.ConectorSQL;

import java.sql.Connection;
import java.util.List;

public class ClienteController {
	private Connection conexion;
	private ClienteDAO clienteDAO;

	public ClienteController() {
		this.conexion = ConectorSQL.crearConexion();
		this.clienteDAO = new ClienteDAO(conexion);
	}

	public void insertarCliente(String nombre, String apellido, String telefono, String email, String direccion) {
		clienteDAO.insertarCliente(nombre, apellido, telefono, email, direccion);

	}

	public List<Cliente> listarClientes() {
		return clienteDAO.listarClientes();
	}

	public Cliente buscarClientePorId(int idCliente) {
		Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
		return cliente;
	}

	public void modificarCliente(int idCliente, String nombre, String apellido, String telefono, String email, String direccion, boolean activo) {
		Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
		clienteDAO.modificarCliente(idCliente, nombre, apellido, telefono, email, direccion, activo);
	}

	public void eliminarCliente(int idCliente) {
		Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
		clienteDAO.eliminarCliente(idCliente);
	}





}
