package com.sise.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sise.domain.User;
import com.sise.exception.UserException;
import com.sise.service.UserService;

public class Register extends HttpServlet {
	
	private UserService service = new UserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		String password2 = request.getParameter("pwd2");
		String phone = request.getParameter("phone");

		/*
		 * 检验电话号码的正则表达式
		 */
		String regex ="^1[3|4|5|7|8][0-9]{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(phone);
		
		User form = new User();
		form.setUsername(username);
		form.setPassword(password);
		form.setPhone(phone);
		
		/*
		 * 检查表单数据,创建一个Map保存错误信息
		 */
		Map<String,String> errors = new HashMap<String,String>();
		if(form.getUsername()==null || form.getUsername().trim()==""){
			errors.put("username", "用户名不能为空！");
		}
		
		if(form.getPassword()==null || form.getPassword().trim()==""){
			errors.put("password", "密码不能为空！");
		} else if(form.getPassword().length() <6){
			errors.put("password","密码长度不能小于6位");
		}
		
		if(form.getPhone()==null || form.getPhone().trim()==""){
			errors.put("phone", "电话号码不能为空");
		} else if(!m.find()){
			errors.put("phone", "电话号码格式不正确");
		}
		
		/*
		 * 判断errors中是否为空，为空代表没有错误
		 */
		if(errors.size() > 0){
			request.setAttribute("errors",errors);
			request.setAttribute("form",form);
			request.getRequestDispatcher("/webs/register.jsp").forward(request, response);
		}
		/*
		 * 调用注册方法
		 */
		try {
			service.register(form);
			request.setAttribute("msg", "恭喜，注册成功");
			request.getRequestDispatcher("/webs/msg.jsp").forward(request,response);
		} catch (UserException e) {
			request.setAttribute("msg", "注册失败！");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/webs/register.jsp").forward(request, response);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
