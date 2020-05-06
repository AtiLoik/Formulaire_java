package com.objis.gestionformationssession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.gestionformationssession.metier.User;
import com.objis.gestionformationssession.service.ServiceAuth;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = new User(login, password);
		
		RequestDispatcher dispatcher;
		ServiceAuth auth = new ServiceAuth();
		
		if(auth.authentification(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", user);
			dispatcher = request.getRequestDispatcher("accueil.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("login.html");
		}
		
		
		dispatcher.forward(request, response);
	}

}
