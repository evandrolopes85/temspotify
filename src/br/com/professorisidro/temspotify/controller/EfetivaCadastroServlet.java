package br.com.professorisidro.temspotify.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.professorisidro.temspotify.dao.DataSource;
import br.com.professorisidro.temspotify.dao.UserDAO;
import br.com.professorisidro.temspotify.model.User;

/**
 * Servlet implementation class EfetivaCadastroServlet
 */

public class EfetivaCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetivaCadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// receber dados do formulario
		String pagina = "/myaccount.jsp";
		String nome  = request.getParameter( "txtNome" );
		String email = request.getParameter( "txtEmail" );
		String senha = request.getParameter( "txtSenha" );
		// criar um objeto usuario com estes dados. ( mas que ainda não tem ID)
		User user = new User();
		user.setUsername( nome );
		user.setEmail( email );
		user.setPassword( senha );
		// instancia  o datasource e o DAO
		DataSource datasource = new DataSource();
		UserDAO dao = new UserDAO(datasource);
		
		// gravar
		dao.create(user);
		System.out.println( user );
		
		try {
			datasource.getConnection().close();
		} catch ( SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println( "Error ao fechar a conexão: " + e.getMessage() );
			request.setAttribute("erroMSG", "Erro ao criar nova conta do Usuario");
			pagina = "/error.jsp";
		}
		// dependendo do resultado, vamos trabalhar em qual página retornar
		
		if( user.getId() != 0 ) {
			request.getSession().setAttribute("User", user);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
		// 49 min
	}

}
