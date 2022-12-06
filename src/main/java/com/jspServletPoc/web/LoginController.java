package com.jspServletPoc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspServletPoc.dao.UserDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("initializing....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDao user = new UserDao();
		String emailId = request.getParameter("emailId");
		if (user.validateEmail(emailId)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
			dispatcher.forward(request, response);
			System.out.println("HI");
			response.sendRedirect("dashboard.jsp");
		} else {
			throw new Exception("Login not successful..");
		}
	}
}
