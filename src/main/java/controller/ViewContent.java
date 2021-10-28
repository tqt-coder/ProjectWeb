package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Content;
import model.dao.ContentDAO;

/**
 * Servlet implementation class ViewContent
 */
@WebServlet(urlPatterns = {"/content"})
public class ViewContent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = null;
		ContentDAO ctd=new ContentDAO();
		List<Content> lst = null;
		try {
			lst = ctd.getContent(title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tbcontents",lst);
		RequestDispatcher rd =request.getRequestDispatcher("/content/viewcontent.jsp");
		rd.forward(request,response);
	}

}
