package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class DeleteCarServlet
 */
@WebServlet("/deleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarServlet() {
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
		ListCarHelper dao = new ListCarHelper();
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		LocalDate year = request.getParameter(year);
		String color = request.getParameter("color");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListCar carToDelete = dao.searchForCarById(tempId);
		carToDelete.setMake(make);
		carToDelete.setModel(model);
		carToDelete.setYear(year);
		carToDelete.setMake(color);
		
		dao.deleteCar(carToDelete);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
