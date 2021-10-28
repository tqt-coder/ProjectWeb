package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.RegisterBean;
import model.dao.RegisterDAO;

@WebServlet(urlPatterns = {"/registercontroller"})
public class RegisterController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		RegisterBean user = new RegisterBean(username, email, password);

		boolean flag = false;
		try {
			flag = RegisterDAO.insertRegister(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd;
		if(flag) {
			rd = req.getRequestDispatcher("/view/login.jsp");
			rd.forward(req, resp);
		}
		else {
			rd = req.getRequestDispatcher("/view/register.jsp");
			rd.forward(req, resp);
		}
	}

}
