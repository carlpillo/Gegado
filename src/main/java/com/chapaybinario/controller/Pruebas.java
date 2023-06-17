package com.chapaybinario.controller;

import com.chapaybinario.model.Usuario;
import com.chapaybinario.services.UsuarioDao;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario nuevo1;
		UsuarioDao<Usuario> miUsuariosDao = new UsuarioDao();
		nuevo1= new Usuario("carlos", "admin", "1234");
		miUsuariosDao.create(nuevo1);
	}

}
