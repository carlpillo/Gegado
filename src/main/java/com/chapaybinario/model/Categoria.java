package com.chapaybinario.model;

public class Categoria {

	private int idC;
	private String nombreC , icono, valor;
	private int idT;
	
	private static final int TAMCADENA = 20;
	
	/*Constructor*/
	public Categoria() {
	}

	public Categoria(String nombreC, String icono, String valor, int idT) {
		setNombreC(nombreC);
		setIcono(icono);
		setValor(valor);
		this.idT = idT;
	}

	public Categoria(int idC, String nombreC,String icono, String valor, int idT) {
		this.idC = idC;
		setNombreC(nombreC);
		setIcono(icono);
		setValor(valor);
		this.idT = idT;
	}
	
	/*setter y getter*/

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC.substring(0, Math.min(TAMCADENA, nombreC.length()));
	}

	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}
	
	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono.substring(0, Math.min(TAMCADENA, icono.length()));
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor.substring(0, Math.min(TAMCADENA, valor.length()));
	}

	/* to string*/
	@Override
	public String toString() {
		return "Categoria [idC=" + idC + ", nombreC=" + nombreC + ", idT=" + idT + "]";
	}
	
	
	
	
}
