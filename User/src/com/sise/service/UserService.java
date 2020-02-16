package com.sise.service;

import java.sql.SQLException;

import com.sise.dao.UserDao;
import com.sise.domain.User;
import com.sise.exception.UserException;

public class UserService {
	private UserDao userdao = new UserDao();
	/*
	 * 用户注册
	 */
	public void register(User form) throws SQLException, UserException{
		User user = userdao.findByUserName(form.getUsername());
		if(user != null){ 
			throw new UserException("用户名已经被注册");
		}
		userdao.add(form);
	}
	
	/*
	 * 用户登录
	 */
	public User login(User form) throws SQLException{
		User user = userdao.findByUserNamePas(form.getUsername(),form.getPassword());
		if(user != null){
			return user;
		}
		return null;
	}
}
