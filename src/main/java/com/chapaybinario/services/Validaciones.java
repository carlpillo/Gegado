package com.chapaybinario.services;

public interface Validaciones {

	public default String capitalizar(String texto)
	{
		String[] arrayTexto = texto.split(" ");  // Separamos las palabras de la cadena en un array
		texto = "";
		
		for (String string : arrayTexto) {
			texto += string.toUpperCase().charAt(0) + string.substring(1).toLowerCase() + " ";
		}
		
		return texto.trim();
	}
	
	public default boolean datosVacios(String datos) {
		if(!datos.isEmpty())
			return true;
		else
		return false;
	}
}
