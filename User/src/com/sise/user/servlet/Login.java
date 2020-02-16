package com.sise.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sise.domain.Cart;
import com.sise.domain.User;
import com.sise.service.UserService;

public class Login extends HttpServlet {
	private UserService service = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User form = new User();
		form.setUsername(username);
		form.setPassword(password);
		
		/*
		 * 检验数据
		 */
		Map<String,String> errors = new HashMap<String,String>();
		
		if(form.getUsername() == null || form.getUsername().trim() == ""){
			errors.put("username", "用户名不能为空！");
		} 
		if(form.getPassword() == null || form.getUsername().trim() == ""){
			errors.put("password", "密码不能为空！");
		}
		if(errors.size()>0){
			request.setAttribute("errors",errors);
			request.getRequestDispatcher("/webs/login.jsp").forward(request, response);
		}
		try {
			User user = service.login(form);
			/*
			 * 如果成功，保存用户名到session中，转发到主页面
			 * 如果失败，保存错误信息和表单信息到login.jsp
			 */
			if(user != null){
					request.getSession().setAttribute("usersession", user);
					//request.getSession().setAttribute("cart",new Cart());
					response.sendRedirect("/User/webs/main.jsp");
			} else {
				errors.put("username", "该用户名或密码错误！");
				request.setAttribute("errors",errors);
				request.getRequestDispatcher("/webs/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			request.getRequestDispatcher("/webs/login.jsp").forward(request, response);
		}

	}
}
