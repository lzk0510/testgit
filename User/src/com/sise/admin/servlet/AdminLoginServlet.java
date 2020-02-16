package com.sise.admin.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String adminname = request.getParameter("adminname");
			String password	 = request.getParameter("password");
			if(adminname.equals("admin") && password.equals("admin")){
				request.getSession().setAttribute("admin",adminname);
				request.getRequestDispatcher("/adminjsps/admin/index.jsp").forward(request, response);
			//response.sendRedirect("/adminjsps/login.jsp");
			}else{
				Map<String,String> errors = new HashMap<String,String>();//
				errors.put("adminname", adminname);
				errors.put("password", password);
				errors.put("msg", "管理员登录失败！");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/adminjsps/login.jsp").forward(request, response);
				
			}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
