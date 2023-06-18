package com.chapaybinario.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chapaybinario.model.Categoria;
import com.chapaybinario.model.Usuario;
import com.chapaybinario.services.CategoriasDAO;
import com.chapaybinario.services.UsuarioDao;
import com.chapaybinario.services.Validaciones;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet implements Validaciones {
	private static final long serialVersionUID = 1L;
       
	String msgExito , msgError, opcion = "";
	UsuarioDao<Usuario> miUsuarioDao = new UsuarioDao<>();
	Usuario a = new Usuario();
	List<Usuario>listaUsuario = new ArrayList<>();
	int id = 0 ;
	String nombreUsuario = "";
	int idUsuario = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		opcion = request.getParameter("opcion");
		
		System.out.println(opcion);
		switch (opcion) {
		case "modificacion":
			case "eliminar":{
				id = Integer.parseInt(request.getParameter("id"));
				if (opcion.equals("modificacion")) {
//					System.out.println("voy bien");
					modificacion(request, response);
				}else {
					eliminar(request, response);
				}
				break;
			}
			case "nuevaTransaccion":{
				System.out.println("voy bien");
				nuevaTransacion(request, response);
				break;
			}
			case "agregarM":{
				System.out.println("vamos terminando..jejej");
				System.out.println(idUsuario);
				int idC = Integer.parseInt(request.getParameter("eleccionC"));
				String detalles = request.getParameter("detalles");
				String categoria = request.getParameter("categoria");
				int importe = Integer.parseInt(request.getParameter("importe"));
				int cat;
				if(categoria.equals("Ingresos"))
					cat = 0;
				else
					cat = 1;
				System.out.println("idC :" + idC);
				System.out.println("Detalles :" + detalles);
				System.out.println("Categoria :" + cat);
				System.out.println("importe :" + importe);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		opcion = request.getParameter("opcion");
		System.out.println(opcion);
		if(!opcion.isEmpty()) {
			try {
				switch (opcion) {
					case "alta":{
						alta(request, response);
						break;
					}
					case "buscar":{
						buscar(request, response);
						break;
					}
					case "modificar":{
						modificar(request, response);
						break;
						}	
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	protected void alta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* definiciones de variables 
		 * recogo los datos enviados de alta.jsp*/
		
		String userN = request.getParameter("nombreU");
		String nombre = request.getParameter("nombre");
		String passU = request.getParameter("passU");
		boolean acierto = false;
		
		try {
			 acierto =(datosVacios(userN) && datosVacios(nombre) && datosVacios(passU));
			if(acierto) {
				System.out.println(userN);
				listaUsuario = miUsuarioDao.read("userN", userN);
				if(listaUsuario.size()== 0) {
					
						a = new Usuario(nombre, userN, passU);
						miUsuarioDao.create(a);
						listaUsuario = miUsuarioDao.read("userN", userN);
						idUsuario = listaUsuario.get(0).getIdU();
						nombreUsuario = userN;
						System.out.println("id usuario :" + idUsuario + "username :" + nombreUsuario);
						
						msgExito = "Alumno creado correctamente";
			            request.setAttribute("msgExito", msgExito);
			            
			            request.setAttribute("idU", idUsuario);
			            request.setAttribute("nombreU", nombreUsuario);
			            request.getRequestDispatcher("tabla.jsp").forward(request, response);
			   //         response.sendRedirect("tabla.jsp");
					
				}else {
					msgError = "Error El Usuario Ya Existe.";
		            request.setAttribute("msgError", msgError);
		            System.out.println(msgError);
		            request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else {
				msgError = "Error Hay Campos Vacios";
	            request.setAttribute("msgError", msgError);
	            System.out.println(msgError);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userN = request.getParameter("nombreU");
		String passU = request.getParameter("passU");
		boolean acierto = (datosVacios(userN) && datosVacios(passU));
		if(acierto) {
			listaUsuario = miUsuarioDao.read("userN", userN);
			if(listaUsuario.size()> 0) {
				System.out.println(listaUsuario.toString());
				if (listaUsuario.get(0).getPassU().equals(passU)) {
					idUsuario = listaUsuario.get(0).getIdU();
					nombreUsuario = userN;
					
					request.setAttribute("idU", idUsuario);
					request.setAttribute("nombreU", nombreUsuario);
					request.getRequestDispatcher("tabla.jsp").forward(request, response);
//					response.sendRedirect("tabla.jsp");
				}else {
					msgError = "Error Contraseña Incorrecta";
		            request.setAttribute("msgError", msgError);
		            System.out.println(msgError);
		            request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else {
				msgError = "Error No Existe El Usuario";
	            request.setAttribute("msgError", msgError);
	            System.out.println(msgError);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else {
			msgError = "Error Hay Campos Vacios";
            request.setAttribute("msgError", msgError);
            System.out.println(msgError);
            request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void modificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		a = miUsuarioDao.read(id);
		System.out.println(a.toString());
		request.setAttribute("idU", a.getIdU());
		request.setAttribute("nombre", a.getNombre());
		request.setAttribute("nombreU", a.getUserN());
		request.setAttribute("passU", a.getPassU());
		
		request.getRequestDispatcher("ModificarU.jsp").forward(request, response);
	}
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String userN = request.getParameter("nombreU");
		String passU = request.getParameter("passU");
		String passU2 = request.getParameter("passU2");
		try {
			if(datosVacios(nombre) && datosVacios(userN) && datosVacios(passU) && datosVacios(passU2)) {
				passU = passU2;
				a = new Usuario(id, nombre, userN, passU);
				miUsuarioDao.update(a);
				
				msgExito = "Usuario Modificado Correctamente";
				request.setAttribute("msgExito", nombre);
				request.setAttribute("idU", a.getIdU());
				request.setAttribute("userN", a.getUserN());
				request.getRequestDispatcher("tabla.jsp").forward(request, response);
			}else {
				msgError = "Error Hay Campos Vacios";
				System.out.println(msgError);
	            request.setAttribute("msgError", msgError);
	            request.getRequestDispatcher("tabla.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			miUsuarioDao.delete(id);
			msgExito = "Usuario Eliminado.";
			request.setAttribute("msgExito", msgExito);
			
			request.getRequestDispatcher("tabla.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			msgError = "Error.. Eliminando";
			request.setAttribute("msgExito", msgExito);
		}
	}

	protected void nuevaTransacion(HttpServletRequest request, HttpServletResponse response) {
		
		CategoriasDAO miCategoriasDAO = new CategoriasDAO();
//		Categoria a = new Categoria();
		List<Categoria> listaCategorias = new ArrayList<>();
		try {
			listaCategorias = miCategoriasDAO.readAll(); 
			request.setAttribute("listaC", listaCategorias);
			request.getRequestDispatcher("transaccion.jsp").forward(request, response);
//			response.sendRedirect("transaccion.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
