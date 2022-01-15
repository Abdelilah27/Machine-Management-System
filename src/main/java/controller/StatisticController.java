
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
import service.MarqueService;

@WebServlet(urlPatterns = { "/StatisticController" })
public class StatisticController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MachineService ms;
	private MarqueService mas;
	public StatisticController() {
		super();
		ms = new MachineService();
		mas = new MarqueService();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("application/json");
		int count = ms.countMachine();
		int countM = mas.countMarque();
		List<Machine> machines = ms.findAll3();
		Gson json = new Gson();
		String bothList = "[" + json.toJson(count) + "," + json.toJson(machines) + "," + json.toJson(countM) + "]";
		response.getWriter().write(bothList);
		response.setContentType("application/json");

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
