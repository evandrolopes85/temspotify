package br.com.professorisidro.temspotify.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class EfetivaPlaylistServlet
 */

public class EfetivaPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetivaPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/index.html";
		try {
			User user = User.class.cast( request.getSession().getAttribute( "User" ) );
			
			
			if( user != null ) {
				String titulo = request.getParameter( "txtNomePlaylist" );
				PlayList p = new PlayList();
				p.setTitle( titulo );
				p.setUser( user );
				
				DataSource datasource = new DataSource();
				PlayListDAO plDAO = new PlayListDAO( datasource );
				plDAO.create( p );
				
				datasource.getConnection().close();
				
				if( user.getPlaylists() == null ) {
					user.setPlaylists( new ArrayList< PlayList >() );
				}
				
				user.getPlaylists().add( p );
				request.getSession().setAttribute( "User", user );
				paginaDestino = "/myplaylists.jsp";
			}
		}catch( Exception ex) {
			System.out.println( "Erro ao cadastrar Playlist" + ex.getMessage() );
			request.setAttribute( "erroSTR", "Erro grave ao criar Playlist" );
			paginaDestino = "/error.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward( request, response );
		
	}

}
