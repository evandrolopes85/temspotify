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
import br.com.professorisidro.temspotify.dao.UserDAO;
import br.com.professorisidro.temspotify.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		User incompleto = new User();
		incompleto.setEmail(email);
		incompleto.setPassword(senha);
		String pagina= "/error.jsp";
		
		try {
			DataSource ds = new DataSource();
			UserDAO userDAO = new UserDAO(ds);
			
			List<Object> res = userDAO.read(incompleto);
			if(res != null && res.size() > 0) {
				pagina = "/myaccount.jsp";
				request.getSession().setAttribute("User", res.get(0));
			}else {
				request.setAttribute("erroSTR", "User / Password Invalid");
			}
			ds.getConnection().close();
		}catch(Exception ex) {
			request.setAttribute("erroSTR", "Erro ao recuperar");
		}
		
		
		/* Simulate a recovery of the DB */
		/*List<Object> res;
		UserDAO userDAO = new UserDAO();
		res = userDAO.read(null);
		
		if(email.equals("isidro@professorisidro.com.br") && senha.equals("1234")) {
			
			request.getSession().setAttribute("User", res.get(0));
			
			pagina = "/myaccount.jsp";
		}else {
			request.setAttribute("erroSTR", "Email / Password not found!!!");
			pagina = "/error.jsp";
		}*/
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
