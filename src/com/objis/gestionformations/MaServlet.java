package com.objis.gestionformations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.objis.gestionformations.service.ServiceAuth;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		////Refarctoring du doGet
		traitement(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		traitement(request,response);
		
	}
protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

////Etape 1 : Récupération des paramètres de la requête : 
String login=request.getParameter("loginuser");
String pwd=request.getParameter("mdpuser");

//// Etape 2 : Soumettre les paramètres de la requête à la couche service
ServiceAuth service = new ServiceAuth();

RequestDispatcher dispatcher;

if (service.estValide(login, pwd) == true){
dispatcher=request.getRequestDispatcher("Acceuil.jsp");
}
else{
dispatcher = request.getRequestDispatcher("Login.jsp");
}

////Etape 3 : Réponse à l'utilisateur

dispatcher.forward(request, response);

}
}
