package com.veterinaria.veterinaria.View;

import com.veterinaria.veterinaria.controller.VeterinarioController;
import com.veterinaria.veterinaria.model.Veterinario;

import java.util.List;
import java.util.Scanner;

public class MenuVeterinario {
    private VeterinarioController controller;
    private Scanner scanner;

    public MenuVeterinario() {
        this.controller = new VeterinarioController();
        this.scanner = new Scanner(System.in);
    }

    public void menuUI() {
        int i = 1;
        while (i != 0) {
            System.out.println( "Ingrese 1 para cargar un veterinario \n" +
                                "Ingrese 2 para listar los veterinarios \n" +
                                "Ingrese 3 para buscar un  veterinario por ID \n" +
                                "Ingrese 4 para actualizar la informacion de un veterinario \n" +
                                "Ingrese 5 para dar de baja un veterinario \n");

            i = scanner.nextInt();
            scanner.nextLine();

            switch (i) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }

    public void insertarVeterinario() {
        System.out.println("Ingrese el nombre: ");
        String nombreAux = scanner.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellidoAux = scanner.nextLine();

        System.out.println("Ingrese la matricula: ");
        String matriculaAux = scanner.nextLine();

        System.out.println("Ingrese la especialidad: ");
        String especialidadAux = scanner.nextLine();

        System.out.println("Ingrese el telefono: ");
        String telefonoAux = scanner.nextLine();

        System.out.println("Ingrese el email: ");
        String emailAux = scanner.nextLine();

        controller.insertarVeterinario(nombreAux, apellidoAux, matriculaAux, especialidadAux, telefonoAux, emailAux);
    }

    public void obtenerTodos() {
        System.out.println(controller.obtenerTodos());
    }

    public void buscarPorID() {
        System.out.println("Ingrese el ID: ");
        int idAux = scanner.nextInt();
        scanner.nextLine();

        controller.buscarPorID(idAux);
    }

    public void modificarVeterinario() {
        System.out.println("Ingrese el nuevo nombre: ");
        String nombreAux = scanner.nextLine();

        System.out.println("Ingrese el nuevo apellido: ");
        String apellidoAux = scanner.nextLine();

        System.out.println("Ingrese la nueva matricula: ");
        String matriculaAux = scanner.nextLine();

        System.out.println("Ingrese la nueva especialidad: ");
        String especialidadAux = scanner.nextLine();

        System.out.println("Ingrese el nuevo telefono: ");
        String telefonoAux = scanner.nextLine();

        System.out.println("Ingrese el nuevo email: ");
        String emailAux = scanner.nextLine();

        int auxID;
        do {
            System.out.println("Ingrese el ID: ");
            auxID = scanner.nextInt();
            scanner.nextLine();
        } while (auxID > 0);

        controller.modificarVeterinario(nombreAux, apellidoAux, matriculaAux, especialidadAux, telefonoAux, emailAux, auxID);
    }

    public void eliminarVeterinario() {
        int auxID;
        do {
            System.out.println("Ingrese el ID del vet a dar de baja: ");
            auxID = scanner.nextInt();
            scanner.nextLine();
        } while (auxID > 0);

        controller.eliminarVeterinario(auxID);
    }
}
