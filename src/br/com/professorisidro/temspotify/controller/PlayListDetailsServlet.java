package br.com.professorisidro.temspotify.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.dao.DataSource;
import br.com.professorisidro.temspotify.dao.PlayListDAO;
import br.com.professorisidro.temspotify.model.PlayList;

/**
 * Servlet implementation class PlayListDetailsServlet
 */
//@WebServlet("/PlayListDetailsServlet")
public class PlayListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/erro.jsp";
		if(request.getSession().getAttribute("User") != null) {
			try {
				DataSource datasource = new DataSource();
				PlayListDAO pldao = new PlayListDAO(datasource);
				int id = Integer.parseInt(request.getParameter("id"));
				PlayList playlist = pldao.readPlayListDetailsById(id);
				if(playlist != null) {
					request.getSession().setAttribute("Playlist", playlist);
					paginaDestino = "/playlistdetails.jsp";
				}else {
					request.setAttribute("erroMSG", "Erro ao recuperar Playlist");
				}
				
			}catch(Exception ex) {
				request.setAttribute("erroMSG", "Erro Inesperado");
			}
		}else {
			request.setAttribute("erroMSG", "Voce não está conectado");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
}
