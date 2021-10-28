package controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.LoginBean;

@WebServlet(urlPatterns = {"/controller.logincontroller"})
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		if(action == null) {
			String email = req.getParameter("email").trim();
			String pass = req.getParameter("password").trim();
			boolean remember = req.getParameter("remember") != null;

			LoginBean user = new LoginBean();
			user.setEmail(email);
			user.setPassword(pass);

			boolean checkLogin = model.dao.LoginDAO.checkLogin(user.getEmail(), user.getPassword());
			if(checkLogin) {
				session.setAttribute("email", user.getEmail());
				if(remember) {
					Cookie ckEmail = new Cookie("email", user.getEmail());
					Cookie ckPass = new Cookie("password", user.getPassword());

					ckEmail.setMaxAge(60*60*24);
					ckPass.setMaxAge(60*60*24);

					resp.addCookie(ckEmail);
					resp.addCookie(ckPass);

				}
				RequestDispatcher rd = req.getRequestDispatcher("/view/welcom.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Login fail");
				RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
				rd.forward(req, resp);
			}
		}
		else {

		}




	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		HttpSession session = req.getSession();

		if(action == null) {
			LoginBean account = checkCookie(req);
			if(account == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
				rd.forward(req, resp);
			}
			else {
				boolean flag = model.dao.LoginDAO.checkLogin(account.getEmail(), account.getPassword());
				if(flag) {
					// chuyển sang trang đăng nhập thành công
					session.setAttribute("email", account.getEmail());
					RequestDispatcher rd = req.getRequestDispatcher("/view/welcom.jsp");
					rd.forward(req, resp);
				}
				else {
					req.setAttribute("msg", "Login fail");
					RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
					rd.forward(req, resp);
				}
			}
		}
		else {
			if(action.equals("logout")) {
				session.removeAttribute("email");
				Cookie [] cookies = req.getCookies();
				
				for(Cookie ck : cookies) {
					if(ck.getName().equals("email")) {
						ck.setMaxAge(0);
						resp.addCookie(ck);
					}
					
					if(ck.getName().equals("password")) {
						ck.setMaxAge(0);
						resp.addCookie(ck);
					}
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
				rd.forward(req, resp);
			}
		}
	}
	private LoginBean checkCookie (HttpServletRequest req) {
		Cookie [] cookies = req.getCookies();
		LoginBean account = null ;
		if(cookies == null) {
			return null;
		}
		else {
			String email = "";
			String password = "";
			for(Cookie ck : cookies) {
				if(ck.getName().equals("email")) {
					email = ck.getValue();
				}
				if(ck.getName().equals("password")) {
					password = ck.getValue();
				}
			}
			if(!email.isEmpty() && !password.isEmpty()) {
				account = new LoginBean(email, password);
			}

		}
		return account;
	}
}