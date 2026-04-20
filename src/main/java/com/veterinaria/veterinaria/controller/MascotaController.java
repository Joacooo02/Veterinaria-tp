package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dao.MascotaDAO;
import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MascotaController {

    Scanner scanner = new Scanner(System.in);

    //Atributos
    private Connection con;
    private MascotaDAO mascotaDAO;

    //Constructor

    public MascotaController() {
        this.con = ConectorSQL.crearConexion();
        this.mascotaDAO = new MascotaDAO(con);
    }


    public void insertarMascota()
    {
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombreMascota = scanner.nextLine();
        System.out.println("Ingrese la especie: ");
        String especieMascota = scanner.nextLine();
        System.out.println("Ingrese la raza: ");
        String raza = scanner.nextLine();
        System.out.println("Ingrese la edad: ");
        int edad = scanner.nextInt();
        System.out.println("Ingrese el peso: ");
        int peso = scanner.nextInt();
        System.out.println("Ingrese el id del cliente");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Mascota mascota = new Mascota(nombreMascota,especieMascota,raza,edad,peso,idCliente);
        mascotaDAO.insertarMascota(mascota);
        System.out.println("Se inserto la mascota correctamente");
    }

    public void listarMascotas()
    {
        List<Mascota> lista = mascotaDAO.mostrarMascotas();

        for(Mascota m : lista)
        {
            System.out.println(m.getId_mascota()+ " " +m.getNombre()+ " " +m.getEspecie()+ " " +m.getRaza()+ " " +m.getEdad()+ " " +m.getPeso()+ " " +m.getId_cliente());
        }
    }


    public void buscarMascota()
    {
        System.out.println("Ingrese el id de la mascota:");
        int idMascota = scanner.nextInt();

        Optional<Mascota> m = mascotaDAO.buscarMascota(idMascota);

        if(m.isPresent())
        {
            Mascota mascota = m.get();
            System.out.println("Mascota encontrada:");
            System.out.println("Id:" +mascota.getId_mascota());
            System.out.println("Nombre: " +mascota.getNombre());
            System.out.println("Especie: "+mascota.getEspecie());
            System.out.println("Raza:" +mascota.getRaza());
            System.out.println("Edad:"+mascota.getEdad());
            System.out.println("Peso:"+mascota.getPeso());
        }else
        {
            System.out.println("NO se encontro ninguna mascota");
        }
    }


}
