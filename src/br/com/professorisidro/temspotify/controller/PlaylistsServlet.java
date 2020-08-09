package br.com.professorisidro.temspotify.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.dao.DataSource;
import br.com.professorisidro.temspotify.dao.PlayListDAO;
import br.com.professorisidro.temspotify.model.PlayList;
import br.com.professorisidro.temspotify.model.User;

/**
 * Servlet implementation class PlaylistsServlet
 */
public class PlaylistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/index.html";
		try {
			User user = ( User ) request.getSession().getAttribute( "User" );
			if( user != null) {
				if( user.getPlaylists() == null ) {
					DataSource datasource = new DataSource();
					PlayListDAO plDAO = new PlayListDAO( datasource );
					List< Object > lista = plDAO.read( user.getId() );
					datasource.getConnection().close();
					
					System.out.println("Recuperei valores...");
					
					if( lista != null ) {
						ArrayList< PlayList > myPlaylists = new ArrayList<>();
						for( Object o : lista ) {
							PlayList novaPL = ( PlayList )o;
							novaPL.setUser( user );
							myPlaylists.add( novaPL );
						}
						user.setPlaylists( myPlaylists );
					}
				}
				request.getSession().setAttribute( "User", user );
				paginaDestino = "/myplaylists.jsp";
			}
		}catch( Exception ex ) {
			System.out.println( "Erro ao recuperar Playlist" + ex.getMessage() );
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward( request, response );
	}

}
