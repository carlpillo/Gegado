package com.chapaybinario.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MetodosDao<T> {

	public void create(T item);
	
	public T read(int item);
	
	public List<T> read(String item1, String item2);
	
	public void update(T item);
	
	public void delete(int item);
	
	public void escribir(T item1, Connection item2, String item3, String item4) throws SQLException;
	
	public List<T> readAll();
	
	
}
