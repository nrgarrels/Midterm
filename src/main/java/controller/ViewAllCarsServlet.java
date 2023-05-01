package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/viewAllCarssServlet")
public class ViewAllCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCarHelper dao = new ListCarHelper();
		request.setAttribute("allCars", dao.showAllCars());
		/*
		 * for(ListItem li : dao.showAllItems()) {
		 * System.out.println(li.returnItemDetails()); }
		 */
		
		String path = "/car-list.jsp";
		
		if(dao.showAllCars().isEmpty()) {
			path = "/index.html";
		}
	
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
