package br.com.professorisidro.temspotify.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirNaPlaylistServlet
 */
@WebServlet("/incluirnaplaylist")
public class IncluirNaPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirNaPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaResultado = "/result.jsp";
		try {
			int idPlaylist = Integer.parseInt(request.getParameter("idplaylist"));
			int idMusica = Integer.parseInt(request.getParameter("idmusica"));
		}catch(Exception ex) {
			request.setAttribute("strRESULT", "Musica duplicada na Playlist");
		}catch(SQLException ex) {
			System.out.println("Erro ao inserir " + ex.getMessage());
			request.setAttribute("strRESULT", "Erro ao inserir musica na Playlist");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaResultado);
		dispatcher.forward(request, response);
	}

}
