package com.veterinaria.veterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDetalladoDTO {
	private int idTurno;
	private LocalDate fecha;
	private LocalTime hora;
	private String motivo;
	private EstadoTurno estado;

	private String nombreCliente;
	private String apellidoCliente;

	private String nombreMascota;

	private String nombreVeterinario;
	private String apellidoVeterinario;

	public TurnoDetalladoDTO() {}

	public TurnoDetalladoDTO(int idTurno, LocalDate fecha, LocalTime hora, String motivo, EstadoTurno estado, String nombreCliente, String apellidoCliente, String nombreMascota, String nombreVeterinario, String apellidoVeterinario) {
		this.idTurno = idTurno;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.estado = estado;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.nombreMascota = nombreMascota;
		this.nombreVeterinario = nombreVeterinario;
		this.apellidoVeterinario = apellidoVeterinario;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getNombreVeterinario() {
		return nombreVeterinario;
	}

	public void setNombreVeterinario(String nombreVeterinario) {
		this.nombreVeterinario = nombreVeterinario;
	}

	public String getApellidoVeterinario() {
		return apellidoVeterinario;
	}

	public void setApellidoVeterinario(String apellidoVeterinario) {
		this.apellidoVeterinario = apellidoVeterinario;
	}

	@Override
	public String toString() {
		return "TurnoDetalladoDTO{" +
				"idTurno=" + idTurno +
				", fecha=" + fecha +
				", hora=" + hora +
				", motivo='" + motivo + '\'' +
				", estado=" + estado +
				", nombreCliente='" + nombreCliente + '\'' +
				", apellidoCliente='" + apellidoCliente + '\'' +
				", nombreMascota='" + nombreMascota + '\'' +
				", nombreVeterinario='" + nombreVeterinario + '\'' +
				", apellidoVeterinario='" + apellidoVeterinario + '\'' +
				'}';
	}
}
