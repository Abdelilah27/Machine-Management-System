package controller;

import beans.Machine;
import beans.Marque;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MachineService;

@WebServlet(urlPatterns = { "/RechercheMachineController" })
public class RechercheMachineController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MachineService ms;
	private String idMarque;
	private List<Machine> machines;

	public RechercheMachineController() {
		super();
		ms = new MachineService();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 if(request.getParameter("op").equals("search")) {
			idMarque = request.getParameter("indice");
			machines = ms.findMachineByMarque((Integer.parseInt(idMarque)));
			System.out.println(ms.findMachineByMarque((Integer.parseInt(idMarque))).toString());
		}

		//System.out.println("test: " + idMarque);
		//System.out.println(ms.findMachineByMarque(Integer.parseInt(idMarque)).toString());
		response.setContentType("application/json");
		List<Marque> marques = ms.findAllMarque();
		Gson json = new Gson();
		String bothList = "[" + json.toJson(marques) + "," + json.toJson(machines) + "]";
		response.getWriter().write(bothList);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
