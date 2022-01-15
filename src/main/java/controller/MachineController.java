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

@WebServlet(urlPatterns = { "/MachineController" })
public class MachineController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MachineService ms;

	public MachineController() {
		super();
		ms = new MachineService();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		if (request.getParameter("op") == null) {
//
//			String ref = request.getParameter("ref");
//			String prix = request.getParameter("prix");
//			String dateAchat = request.getParameter("dateAchat").replace("-", "/");
//			ms.create(new Machine(ref,new Date(dateAchat), Double.parseDouble(prix)));
//		} else if (request.getParameter("op").equals("delete")) {
//			String id = request.getParameter("indice");
//			//mas.delete(mas.findById(Integer.parseInt(id)));
//
//		} else if (request.getParameter("op").equals("update")) {
//			String id = request.getParameter("indice1");
//			String code = request.getParameter("code");
//			String libelle = request.getParameter("libelle");
//			//Marque m = mas.findById(Integer.parseInt(id));
//			//m.setCode(code);
//			//m.setLibelle(libelle);
//			//mas.update(m);
//
//		}

//		response.setContentType("application/json");
//		List<Machine> machines = ms.findAll();
//		Gson json = new Gson();
//		response.getWriter().write(json.toJson(machines));

		if (request.getParameter("op") == null) {
			String ref = request.getParameter("ref");
			String prix = request.getParameter("prix");
			String dateAchat = request.getParameter("dateAchat").replace("-", "/");
			String idMarque = request.getParameter("marque");
			ms.create(new Machine(ref, new Date(dateAchat), Double.parseDouble(prix), Integer.parseInt(idMarque)));
		}else if(request.getParameter("op").equals("delete")) {
			String id = request.getParameter("indice");
            ms.delete(ms.findById(Integer.parseInt(id)));
            
		}else if(request.getParameter("op").equals("update")) {
			String id = request.getParameter("indice1");
			String ref = request.getParameter("indice2");
			String dateA = request.getParameter("indice3").replace("-", "/");
			String prix = request.getParameter("indice4");
			String idM = request.getParameter("indice5");
			Machine m = ms.findById(Integer.parseInt(id));
			m.setReference(ref);
			m.setDateAchat(new Date(dateA));
			m.setPrix(Integer.parseInt(prix));
			m.setIdMarque(Integer.parseInt(idM));
			ms.update(m);

		}

		response.setContentType("application/json");
		List<Marque> marques = ms.findAllMarque();
		List<Machine> machines = ms.findAll2();
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
