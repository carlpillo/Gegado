package com.chapaybinario.model;

public class Transaccion {

	private int idT;
	private String nombreT;
	private final int TAMNOMBRET = 10;
	
	/*Construcctor*/
	public Transaccion() {
	}

	public Transaccion(int idT) {
		this.idT = idT;
	}

	public Transaccion(int idT, String nombreT) {
		this.idT = idT;
		this.nombreT = nombreT;
	}

	/*setter y getter*/
	
	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}

	public String getNombreT() {
		return nombreT;
	}

	public void setNombreT(String nombreT) {
		this.nombreT = nombreT.substring(0, Math.min(TAMNOMBRET, nombreT.length()));
	}

	public int getTAMNOMBRET() {
		return TAMNOMBRET;
	}

	/*to string*/
	@Override
	public String toString() {
		return "Transaccion [idT=" + idT + ", nombreT=" + nombreT + ", TAMNOMBRET=" + TAMNOMBRET + "]";
	}
	
	
	
	
	
	
}
