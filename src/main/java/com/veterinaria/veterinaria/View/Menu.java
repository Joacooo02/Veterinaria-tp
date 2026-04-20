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
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion){


			}

		}while (opcion != 0);

	}


}
