package com.veterinaria.veterinaria.model;

import java.time.LocalDateTime;

public class Turno {

    private int id_turno;
    private LocalDateTime fecha_hora;
    private String motivo;
    private EstadoTurno estado;
    private int id_cliente;
    private int id_veterinario;
    private int id_mascota;

    public Turno() {
    }

    public Turno(String motivo, int id_cliente, int id_mascota) {
        this.id_turno = id_turno;
        this.fecha_hora = fecha_hora;
        this.motivo = motivo;
        this.estado = EstadoTurno.Pendiente;
        this.id_cliente = id_cliente;
        this.id_veterinario = id_veterinario;
        this.id_mascota = id_mascota;
    }

    public Turno(int id_turno, LocalDateTime fecha_hora, String motivo, EstadoTurno estado, int id_cliente, int id_veterinario, int id_mascota) {
        this.id_turno = id_turno;
        this.fecha_hora = fecha_hora;
        this.motivo = motivo;
        this.estado = EstadoTurno.Pendiente;
        this.id_cliente = id_cliente;
        this.id_veterinario = id_veterinario;
        this.id_mascota = id_mascota;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id_turno=" + id_turno +
                ", fecha_hora=" + fecha_hora +
                ", motivo='" + motivo + '\'' +
                ", estado=" + estado +
                ", id_cliente=" + id_cliente +
                ", id_veterinario=" + id_veterinario +
                ", id_mascota=" + id_mascota +
                '}';
    }
}
