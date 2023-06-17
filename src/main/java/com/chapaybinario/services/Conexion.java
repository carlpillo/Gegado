package com.chapaybinario.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection con;
	private String url , user, pass;
	
	public Connection conectar() {
		url = "jdbc:mysql://localhost:3306/gegado?useUnicode=true&characterEncoding=utf-8";
		user = "root";
		pass = "";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión realizada con éxito");
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	public Connection getCon() {
		return con;
	}
	
	
}
