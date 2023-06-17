package com.chapaybinario.model;

import com.chapaybinario.services.Validaciones;

public class Usuario implements Validaciones {

	private int idU;
	private String userN , passU, nombre;
	
	private static final int TAMUSERN = 10;
	private static final int TAMPASSU = 12;
	private static final int TAMNOMBRE = 50;
	
	/*Constructores*/
	public Usuario() {
	}

	public Usuario(String nombre, String userN, String passU) {
		this.nombre = nombre;
		this.userN = userN;
		this.passU = passU;
	}

	public Usuario(int idU, String nombre, String userN, String passU) {
		this.idU = idU;
		this.nombre = nombre;
		this.userN = userN;
		this.passU = passU;
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN.substring(0, Math.min(TAMUSERN, userN.length()));
	}

	public String getPassU() {
		return passU;
	}

	public void setPassU(String passU) {
		this.passU = passU.substring(0, Math.min(TAMPASSU, passU.length()));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = capitalizar(nombre.substring(0, Math.min(TAMNOMBRE, nombre.length())));
	}

	/*to string*/
	@Override
	public String toString() {
		return "Usuario [idU=" + idU + ", userN=" + userN + ", passU=" + passU + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
