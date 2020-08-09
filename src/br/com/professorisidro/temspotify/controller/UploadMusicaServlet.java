package br.com.professorisidro.temspotify.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.dao.DataSource;
import br.com.professorisidro.temspotify.dao.MusicaDAO;
import br.com.professorisidro.temspotify.model.Music;

/**
 * Servlet implementation class UploadMusicaServlet
 */

public class UploadMusicaServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "/error.jsp";
		if( request.getSession().getAttribute( "User" ) != null) {
			try {
				String artista = request.getParameter( "txtArtista" );
				String album   = request.getParameter( "txtAlbum" );
				String titulo  = request.getParameter( "txtNomeMusica" );
				int estilo     = Integer.parseInt( request.getParameter( "txtEstilo" ) );
	
				InputStream arqOriginal = request.getPart( "fileMP3").getInputStream();
				String nomeArquivoOriginal = request.getPart( "fileMP3" ).getSubmittedFileName();
				String nomeArquivo = getServletContext().getRealPath("\\") + "\\musicas\\" + request.getPart( "fileMP3").getSubmittedFileName();
				
				//System.out.println("Nome do arq..." + nomeArquivo);
				FileOutputStream arquivoMP3 = new FileOutputStream( nomeArquivo );
				byte b[] = new byte[1024];
				
				while( arqOriginal.available() > 0 ) {
					arqOriginal.read( b );
					arquivoMP3.write( b );
				}
				arqOriginal.close();
				arquivoMP3.close();
				
				Music musica = new Music();
				musica.setAlbum( album ); 
				musica.setArtist( artista );
				musica.setStyle( estilo ); 
				musica.setTitle( titulo );
				musica.setLinkMP3("musicas/"+nomeArquivoOriginal);
				
				DataSource datasource = new DataSource();
				MusicaDAO dao = new MusicaDAO( datasource );
				
				dao.create( musica );
				
				datasource.getConnection().close();
				
				paginaDestino = "/myaccount.jsp";
				//request.setAttribute("erroSTR", "OK: Deu tudo certo!!!");
				//File mp3 = request.getPart( "fileMP3" ).get
				/*Collection< Part > parts = request.getParts();
				for( Part p : parts ) {
					System.out.println( "Formulario contem: " + p.getName() );
					
				}*/
			}catch( Exception ex ) {
				request.setAttribute("erroSTR", "Erro:Upload falhou");
				
				ex.printStackTrace();
			}
		}else {
			request.setAttribute("erroSTR", "Erro: Usuário não conectado!");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( paginaDestino );
		dispatcher.forward(request, response);
	}

}
