package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Marque;
import service.MarqueService;

/**
 * Servlet implementation class MarqueController
 */
@WebServlet("/MarqueController")
public class MarqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MarqueService mas;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarqueController() {
        super();
        mas = new MarqueService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op")==null) {
			
			String code = request.getParameter("code");
			String libelle = request.getParameter("libelle");
			mas.create(new Marque(code, libelle));
		}else if(request.getParameter("op").equals("delete")) {
			String id = request.getParameter("indice");
            mas.delete(mas.findById(Integer.parseInt(id)));
            
		}else if(request.getParameter("op").equals("update")) {
			String id = request.getParameter("indice1");
			String code = request.getParameter("code");
			String libelle = request.getParameter("libelle");
			Marque m = mas.findById(Integer.parseInt(id));
			m.setCode(code);
			m.setLibelle(libelle);
			mas.update(m);

		}
		
		response.setContentType("application/json");
		List<Marque> marques =  mas.findAll();
		Gson json = new Gson();
		response.getWriter().write(json.toJson(marques));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
