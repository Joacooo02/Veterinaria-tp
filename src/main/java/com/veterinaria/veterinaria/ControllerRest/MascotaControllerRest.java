package com.veterinaria.veterinaria.ControllerRest;

import com.veterinaria.veterinaria.dao.MascotaDAO;
import com.veterinaria.veterinaria.model.ConectorSQL;
import com.veterinaria.veterinaria.model.Mascota;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")

public class MascotaControllerRest {

    //Atributos
    private MascotaDAO mascotaDAO;

    //Constructor

    public MascotaControllerRest() {
        Connection con = ConectorSQL.crearConexion();
        this.mascotaDAO = new MascotaDAO(con);
    }

    @GetMapping //ESTO SE USA PARA MOSTRAR
    public List<Mascota> listar()
    {
        return mascotaDAO.mostrarMascotas();
    }

    @PostMapping
    public void insertar(@RequestBody Mascota m)
    {
        mascotaDAO.insertarMascota(m);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Mascota mascota)
    {
        mascota.setId_mascota(id);
        mascotaDAO.actualizarMascota(mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id)
    {
        mascotaDAO.eliminarMascota(id);
    }

    @GetMapping("/{id}")
    public Optional<Mascota> buscar(@PathVariable int id)
    {
        return mascotaDAO.buscarMascota(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Mascota> porCliente(@PathVariable int idCliente)
    {
        return mascotaDAO.buscarPorCliente(idCliente);
    }

}
