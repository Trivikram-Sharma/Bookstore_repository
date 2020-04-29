package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.model.Book;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				BookDao bd = new BookDaoImpl();
				int id = Integer.parseInt(request.getParameter("id"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				float price = Float.parseFloat(request.getParameter("price"));
				Book b = new Book(id, title, author, price);
				boolean status = bd.updateBookDetailsById(b);
				if(status) {
				request.setAttribute("status", "Update Successful");
				request.getRequestDispatcher("update-status.jsp").forward(request, response);
				}
				else {
					request.setAttribute("status", "Update Not Successful");
					request.getRequestDispatcher("update-status.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
