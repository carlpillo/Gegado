package com.chapaybinario.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

	private int id , idUsuario;
	private double importe;
	private LocalDateTime fecha;
	private String detalles;
	
	private static final int TAMdetallesI = 50;

	/*Constructor*/
	public Movimiento() {
	}

	public Movimiento(int id, double importe, LocalDateTime fecha, String detalles) {
		this.id = id;
		this.importe = importe;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.fecha = fecha;
		setDetalles(detalles);
	}

	/*setter y getter*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles.substring(0, Math.min(TAMdetallesI, detalles.length()));
	}

	/*to string*/
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", idUsuario=" + idUsuario + ", importe=" + importe + ", fecha=" + fecha
				+ ", detalles=" + detalles + "]";
	}
	
	
	
	
}
