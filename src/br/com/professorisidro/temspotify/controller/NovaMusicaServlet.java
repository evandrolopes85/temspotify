package br.com.professorisidro.temspotify.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaMusicaServlet
 */
public class NovaMusicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/error.jsp";
		
		if( request.getSession().getAttribute( "User" ) !=  null ) {
			paginaDestino = "/novamusica.jsp";
		}else {
			request.setAttribute( "erroSTR", "ERRO: Usuario não conectado!" );
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward( request, response );
	}

}
