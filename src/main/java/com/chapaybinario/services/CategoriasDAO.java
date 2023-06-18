package com.chapaybinario.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chapaybinario.model.Categoria;

public class CategoriasDAO extends Conexion implements MetodosDao<Categoria>
{
	String sql;
	
	@Override
	public void create(Categoria categoria)
	{
        Connection con = conectar();
        sql = "INSERT INTO categorias (nombrec, idT, icono) VALUES (?,?,?);";
        
        try
        {
           escribir(categoria, con, sql, "");
           con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

	@Override
	public Categoria read(int idC)
	{
	        Categoria categoria = null;
	        sql = "SELECT * FROM categorias WHERE idC=?;";

	        try
	        {
	            Connection con = conectar();
	            PreparedStatement pt = con.prepareStatement(sql);
	            pt.setInt(1, idC);
	            ResultSet rs = pt.executeQuery();
	            if (rs.next())
	            {
	                String nombreC = rs.getString("nombreC");
	                int idT = rs.getInt("idT");
	                String icono = rs.getString("icono");
	                categoria = new Categoria(idC, nombreC, icono, idT);
	                con.close();
	            }
	        } catch (SQLException e)
	        {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return categoria;
	}

	@Override
	public List<Categoria> read(String campo, String dato)
	{
		List<Categoria> listaCategorias = new ArrayList<>();
		
		try
        {
            Connection con = conectar();
            PreparedStatement pt = null;
            
			switch (campo)
			{
				case "idC" :
				{
					sql = "SELECT * FROM categorias WHERE idC=?;";
					int idC = Integer.parseInt(dato);
					pt = con.prepareStatement(sql);
	            	pt.setInt(1, idC);
				}
				case "nombreC" :
				{
					sql = "SELECT * FROM categorias WHERE nombreC LIKE ?;";
					pt = con.prepareStatement(sql);
					pt.setString(1, "%" + dato + "%");
				}
			}
			ResultSet rs = pt.executeQuery();
            while (rs.next())
            {
            	int idC = rs.getInt("idC");
                String nombreC = rs.getString("nombreC");
                int idT = rs.getInt("idT");
                String icono = rs.getString("icono");
                Categoria categoria = new Categoria(idC, nombreC, icono, idT);
                listaCategorias.add(categoria);
            }
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCategorias;
	}

	@Override
	public void update(Categoria categoria)
	{
		if (categoria != null)
        {
            sql = "UPDATE categorias set nombreC=?,idT=?,icono=? WHERE idC=?;";
            try
            {
                Connection con = conectar();
                escribir(categoria, con, sql, "update");
                con.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}

	@Override
	public void delete(int idC)
	{
		sql = "DELETE FROM categorias WHERE idC=?;";
        try
        {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, idC);
            pt.executeUpdate();
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
		
	}

	@Override
	public void escribir(Categoria categoria, Connection con, String sql, String opcion) throws SQLException
	{
		PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, categoria.getNombreC());
        pt.setInt(2, categoria.getIdT());
        pt.setString(3, categoria.getIcono());

        if (opcion.equals("update"))
            pt.setInt(4, categoria.getIdC());

        pt.executeUpdate();
	}

	@Override
	public List<Categoria> readAll()
	{
		List<Categoria> listaCategorias = new ArrayList<>();
        
        sql ="SELECT * FROM categorias;";
        
        try
        {
            Connection con = conectar();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(sql);

            while (rs.next())
            {
            	int idC = rs.getInt("idC");
                String nombreC = rs.getString("nombreC");
                int idT = rs.getInt("idT");
                String icono = rs.getString("icono");
                Categoria categoria = new Categoria(idC, nombreC, icono, idT);
                listaCategorias.add(categoria);
            }
            con.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCategorias;
    }
}
