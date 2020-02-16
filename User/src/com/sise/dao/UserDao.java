package com.sise.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dbutils.JDBCUtils;

import com.sise.domain.User;

public class UserDao {
	//创建QueryRunner对象
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 按用户名查找 
	 */
	public User findByUserName(String username) throws SQLException{
		String sql = "select * from user where username=?";
		Object[] params = {username};
		User user = qr.query(sql, new BeanHandler<User>(User.class),params);
		return user;
	}
	
	/*
	 * 按用户名查找 
	 */
	public User findByUserNamePas(String username,String password) throws SQLException{
		String sql = "select * from user where username=? and password=?";
		Object[] params = {username,password};
		User user = qr.query(sql, new BeanHandler<User>(User.class),params);
		return user;
	}
	
	/*
	 * 按电话号码查询
	 */
	public User findPhone(String phone) throws SQLException{
//		QueryRunner  qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where phone=?";
		Object[] params = {phone};
		User user = qr.query(sql, new BeanHandler(User.class),params);
		return user;
	}
	
	/*
	 * 添加用户
	 */
	public void add(User user) throws SQLException{
		String sql = "insert into user(username,password,phone) values(?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getPhone()};
		qr.update(sql, params);
	}
		/**
		 * 更新用户
		 */
		public boolean update(User user) throws SQLException{
			String sql="update user username=?,password=?,telephone=?,email=? "
					+ "where username=? and password=?";
			Object[] params = {
					user.getUsername(),
					user.getPassword(),
					user.getPhone(),
					user.getEmail()};
			int num=qr.update(sql, params);
			if(num>0)
				return true;
			return false;
		}
	}



