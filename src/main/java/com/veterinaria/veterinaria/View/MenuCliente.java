package com.veterinaria.veterinaria.View;

import com.veterinaria.veterinaria.controller.ClienteController;
import com.veterinaria.veterinaria.model.Cliente;
import java.util.List;
import java.util.Scanner;

public class MenuCliente {
	private Scanner scanner;
	private ClienteController clienteController;

	public MenuCliente() {
		this.scanner = new Scanner(System.in);
		this.clienteController = new ClienteController();
	}

	public void mostrarMenuCliente(){
		int opcion;
		do {
			System.out.println("-----MENU CLIENTE-----");
			System.out.println("1. Agregar un cliente");
			System.out.println("2. Ver todos los clientes");
			System.out.println("3. Buscar un cliente por ID");
			System.out.println("4. Actualizar los datos de un cliente");
			System.out.println("5. Eliminar un cliente");
			System.out.println("0. Salir");
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion){
				case 1:
					System.out.println("Nombre: ");
					String nombre = scanner.nextLine();
					System.out.println("Apellido: ");
					String apellido = scanner.nextLine();
					System.out.println("Telefono: ");
					String telefono = scanner.nextLine();
					System.out.println("Email: ");
					String email = scanner.nextLine();
					System.out.println("Direccion");
					String direccion = scanner.nextLine();
					clienteController.insertarCliente(nombre,apellido,telefono,email,direccion);
					System.out.println("Cliente agregado exitosamente");
					break;
				case 2:
					List<Cliente> clientes = clienteController.listarClientes();
					if (clientes.isEmpty()) {
						System.out.println("No hay clientes registrados.");
					} else {
						clientes.forEach(c -> System.out.println(c));
					}
					break;
				case 3:
					System.out.println("Ingrese el ID del Cliente que desea buscar: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					Cliente cliente = clienteController.buscarClientePorId(id);
					System.out.println(cliente);
					break;
				case 4:
					System.out.println("Ingrese el ID del Cliente que desea modificar: ");
					id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Nombre: ");
					nombre = scanner.nextLine();
					System.out.println("Apellido: ");
					apellido = scanner.nextLine();
					System.out.println("Telefono: ");
					telefono = scanner.nextLine();
					System.out.println("Email: ");
					email = scanner.nextLine();
					System.out.println("Direccion");
					direccion = scanner.nextLine();
					System.out.println("Activo (true/false): ");
					boolean activo = scanner.nextBoolean();
					clienteController.modificarCliente(id,nombre,apellido,telefono,email,direccion,activo);
					break;
				case 5:
					System.out.println("Ingrese el ID del Cliente que desea eliminar: ");
					id = scanner.nextInt();
					scanner.nextLine();
					clienteController.eliminarCliente(id);
					break;
				case 0:
					System.out.println("Saliendo...");
					break;
			}

		}while (opcion != 0);
	}






}
