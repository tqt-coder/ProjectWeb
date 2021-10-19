package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LoginBean;

@WebServlet(urlPatterns = {"/controller.logincontroller"})
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		LoginBean lg = new LoginBean();
		lg.setEmail(email);
		lg.setPassword(pass);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		boolean flag = model.dao.LoginDAO.checkLogin(email, pass);
		if(flag) {
			out.println("Success");
		}
		else {
			req.setAttribute("msg", "Login fail");
			RequestDispatcher rd = req.getRequestDispatcher("/view/LoginView.jsp");
			rd.forward(req, resp);
		}
	}
}