package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;
import model.ListCarPart;

/**
 * Servlet implementation class AddCarPartServlet
 */
@WebServlet("/AddCarPartServlet")
public class AddCarPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarPartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String partName = request.getParameter("partName");
		String partNumber = request.getParameter("partNumber");
		
		
		System.out.println("Inside doPost");
		ListCarPart li = new ListCarPart(partName, partNumber);
		ListCarPartHelper dao = new ListCarPartHelper();
		dao.insertCarPart(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
