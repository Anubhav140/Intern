package pnb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pnb.entity.User;
import pnb.model.UsersModel;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList; 

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {
		case "home": 
			request.setAttribute("title", "Home");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		
		case "listusers": 
			List<User> users= new ArrayList<>();
			users=new UsersModel().listuser();
			request.setAttribute("listusers", users);
			request.setAttribute("title", "List users");
			request.getRequestDispatcher("listusers.jsp").forward(request, response);
			break;
		
		default:
			request.setAttribute("title", "Error");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
