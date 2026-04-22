package com.veterinaria.veterinaria.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

	private int idTurno;
	private LocalDate fecha;
	private LocalTime hora;
	private String motivo;
	private EstadoTurno estado;
	private int idCliente;
	private int idVeterinario;
	private int idMascota;

    public Turno() {
    }

	public Turno(int idTurno, LocalDate fecha, LocalTime hora, String motivo, EstadoTurno estado, int idCliente, int idVeterinario, int idMascota) {
		this.idTurno = idTurno;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.estado = estado;
		this.idCliente = idCliente;
		this.idVeterinario = idVeterinario;
		this.idMascota = idMascota;
	}

	public Turno(LocalDate fecha, LocalTime hora, String motivo, int idCliente, int idVeterinario, int idMascota) {
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.idCliente = idCliente;
		this.idVeterinario = idVeterinario;
		this.idMascota = idMascota;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	@Override
	public String toString() {
		return "Turno{" +
				"idTurno=" + idTurno +
				", fecha=" + fecha +
				", hora=" + hora +
				", motivo='" + motivo + '\'' +
				", estado=" + estado +
				", idCliente=" + idCliente +
				", idVeterinario=" + idVeterinario +
				", idMascota=" + idMascota +
				'}';
	}

}
