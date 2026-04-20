package com.veterinaria.veterinaria.View;


import java.util.Scanner;

public class Menu {
	private Scanner scanner;
	private MenuCliente menuCliente;
	private MenuMascota menuMascota;
	private MenuTurno menuTurno;
	private MenuVeterinario menuVeterinario;


	public Menu() {
		this.scanner = new Scanner(System.in);
		this.menuCliente = new MenuCliente();
		this.menuMascota = new MenuMascota();
		this.menuTurno = new MenuTurno();
		this.menuVeterinario = new MenuVeterinario();
	}

	public void menu(){
		int opcion;
		do {
			System.out.println("------------------------Bienvenido al Menu de la Veterinaria------------------------");
			System.out.println("1 Gestion Mascotas");
			System.out.println("2 Gestion Clientes");
			System.out.println("3 Gestion Turnos");
			System.out.println("4 Gestion Veterinarios");
			System.out.println("5 Salir del programa");
			System.out.println("Ingrese una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion){
				case 1:
						menuMascota.menuMascota();
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:
					break;
				default:
					System.out.println("Opcion invalida, ingrese otra: ");
					break;
			}
		}while (opcion != 5);

	}


}
