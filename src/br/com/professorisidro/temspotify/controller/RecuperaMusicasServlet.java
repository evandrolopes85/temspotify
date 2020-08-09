package br.com.professorisidro.temspotify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.dao.DataSource;
import br.com.professorisidro.temspotify.dao.MusicaDAO;
import br.com.professorisidro.temspotify.model.User;

/**
 * Servlet implementation class RecuperaMusicasServlet
 */
//@WebServlet("/recuperamusicas")
public class RecuperaMusicasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaMusicasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/error.jsp";
		try {
			User usuario = ( User ) request.getSession().getAttribute( "User" );
			
			if( usuario == null ) {
				request.setAttribute( "erroSTR", "Usuario não conectado!" );
			}else {
				DataSource datasource = new DataSource();
				MusicaDAO mdao = new MusicaDAO( datasource );
				List<Object> lista = mdao.read( null );
				if( lista == null ) {
					request.setAttribute( "erroSTR", "Erro ao recuperar musicas do banco de dados!");
				}else {
					request.setAttribute( "ListaMusicas", lista );
					paginaDestino = "/minhasmusicas.jsp";
				}
				datasource.getConnection().close();
			}
		}catch( Exception ex ) {
			System.out.println("Erro ao montar pagina de musicas " +  ex.getMessage() );
			request.setAttribute( "erroST", "Erro ao montar a pagina de musicas" );
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward( request, response );
	}
}
