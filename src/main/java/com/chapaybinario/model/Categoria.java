package com.chapaybinario.model;

public class Categoria
{
	private int idC;
	private String nombreC, icono;
	private int idT;

	private static final int TAMCADENA = 20;

	public Categoria()
	{
	}

	public Categoria(String nombreC, String icono, int idT)
	{
		setNombreC(nombreC);
		setIcono(icono);
		this.idT = idT;
	}

	public Categoria(int idC, String nombreC, String icono, int idT)
	{
		this.idC = idC;
		setNombreC(nombreC);
		setIcono(icono);
		this.idT = idT;
	}

	public int getIdC()
	{
		return idC;
	}

	public void setIdC(int idC)
	{
		this.idC = idC;
	}

	public String getNombreC()
	{
		return nombreC;
	}

	public void setNombreC(String nombreC)
	{
		this.nombreC = nombreC.substring(0, Math.min(TAMCADENA, nombreC.length()));
	}

	public String getIcono()
	{
		return icono;
	}

	public void setIcono(String icono)
	{
		this.icono = icono.substring(0, Math.min(TAMCADENA, icono.length()));
	}

	public int getIdT()
	{
		return idT;
	}

	public void setIdT(int idT)
	{
		this.idT = idT;
	}

	@Override
	public String toString()
	{
		return "Categoria [idC=" + idC + ", nombreC=" + nombreC + ", icono=" + icono + ", idT="
				+ idT + "]\n";
	}
}
