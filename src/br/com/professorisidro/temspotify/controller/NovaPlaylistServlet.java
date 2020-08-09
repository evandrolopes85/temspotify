package br.com.professorisidro.temspotify.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.model.User;

/**
 * Servlet implementation class NovaPlaylistServlet
 */
public class NovaPlaylistServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = User.class.cast( request.getSession().getAttribute("User") );
		String paginaDestino = "/index.html";
		
		if( user != null ) {
			paginaDestino = "/novaplaylist.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward( request, response );
	}

}
