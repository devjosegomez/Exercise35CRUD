package com.exercise35crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 
 * @author /devJoseGomez
 *
 * @since 1.0
 * 
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

	/**
	 * Método doPost 
	 * @param request Me sirve para recibir los datos del cliente
	 * @param response Me sirve para enviar los datos al cliente
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json charset='uft-8'");
		response.setContentType("text/html charset='uft-8'");
		PrintWriter output = response.getWriter();
		
		String nombreProduct = request.getParameter("txtNameProduct");
		double priceProduct  = Double.parseDouble(request.getParameter("txtPriceProduct"));
		
		String urlServidor = "mysql:jdbc//localhost:3306/tiendita?useSSL=false&serverTimezone=UTC";
		String nombreUsuario = "root";
		String password = "root";
		int rowsAffected = 0;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getClass().getConstructor().newInstance();
			Connection conn = DriverManager.getConnection(urlServidor, nombreUsuario, password);
			Statement stmnt = conn.createStatement();
			
			
			rowsAffected = stmnt.executeUpdate("INSERT INTO productos("
					+ " Nombre_Producto, Precio_Producto) VALUES (" + nombreProduct 
					+ ", " + priceProduct + ");");
			
			if(rowsAffected !=0) {
				output.append("Añadido con exito!");
			}else {
				output.append("Registro NO fue añadido! :(");
			}
			
			//cerramos conexion
			stmnt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		output.close();
	}

}
