package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import Beans.Book;
import Conn.TranVietHoangConnection;
import Utils.BookUtil;


/**
 * Servlet implementation class BookCreate
 */
@WebServlet("/bookCreate")
public class BookCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/BookCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		String bookid = (String) request.getParameter("bookid");
		String title = (String) request.getParameter("title");
		String author = (String) request.getParameter("author");
		String release = (String) request.getParameter("release");
		String price = (String) request.getParameter("price");
		String picture = (String) request.getParameter("picture");
		String publisherid = (String) request.getParameter("publisherId");
		String categoryid = (String) request.getParameter("categoryId");
		int release1 = 0;
		int publisherid1 = 0;
		int categoryid1 = 0;
		float price1 =0;
		try {
			release1 = Integer.parseInt(release);
			publisherid1 = Integer.parseInt(publisherid);
			categoryid1 = Integer.parseInt(categoryid);
			price1 = Float.parseFloat(price);
		} catch(Exception e) {
			errorString = e.getMessage();
		}
		Book book = new Book(bookid, title, author,release1,price1,picture,publisherid1,categoryid1);
		String regex = "\\w+";
		if(bookid == null || !bookid.matches(regex)) {
			errorString = "Book Code invalid";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/BookCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		Connection conn = null;
		try {
			conn = TranVietHoangConnection.getMSSQLConnection();
			BookUtil.addBook(conn, book);
			response.sendRedirect(request.getContextPath() + "/bookList");
			
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/BookCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
