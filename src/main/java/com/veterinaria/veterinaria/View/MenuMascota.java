package com.veterinaria.veterinaria.View;

import com.veterinaria.veterinaria.controller.MascotaController;

import java.util.Scanner;

public class MenuMascota {

    Scanner scanner = new Scanner(System.in);
    MascotaController mascotaController = new MascotaController();

    public void menuMascota()
    {
        int opc = 0;
        do {
            System.out.println("-------------------------Bienvenido al menu de Mascota-------------------------");
            System.out.println("1 Agregar una mascota nueva");
            System.out.println("2 Ver todas las mascotas");
            System.out.println("3 Buscar una mascota por id");
            System.out.println("4 Actualizar una mascota por id");
            System.out.println("5 Eliminar una mascota");
            System.out.println("6 Salir del menu");
            System.out.println("Ingrese una opcion: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc)
            {
                case 1:
                    mascotaController.insertarMascota();
                    break;
                case 2:
                    mascotaController.listarMascotas();
                    break;
                case 3:
                    mascotaController.buscarMascota();
                    break;
                case 4:
                    mascotaController.actualizarMascota();
                    break;
                case 5:
                    mascotaController.eliminarMascota();
                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion invalida, ingrese nuevamente:");
                    break;
            }
        }while (opc != 6);
    }


}
