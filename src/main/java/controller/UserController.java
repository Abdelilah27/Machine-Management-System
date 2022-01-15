package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import beans.Marque;
import beans.User;
import connexion.Connexion;

import service.MarqueService;
import service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		us = new UserService();
		// TODO Auto-generated constructor stub
	}

	private static PrintWriter out;
	private static String message;
	private static Gson gson;
	private JSONObject simpeJO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gson = new Gson();
		simpeJO = new JSONObject();
		String name = request.getParameter("name");
		String usern = request.getParameter("username");
		String pass = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		HttpSession session = request.getSession();

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma", "no-cache");
		httpResponse.setDateHeader("Expires", 0);

		boolean login = us.login(usern, pass);
		if (login) {

			session.setAttribute("username", usern);
			if (session.getAttribute("username") == null) {
				response.sendRedirect("/authentification.jsp");
			} else {

				simpeJO.put("status", true);
				simpeJO.put("erreur", "Login Sucess");
			}

		} else {
			session.invalidate();
			simpeJO.put("status", false);
			simpeJO.put("erreur", "Login Sucess");
		}
		message = gson.toJson(simpeJO);
		out.println(message);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
