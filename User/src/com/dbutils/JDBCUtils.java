package com.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/*
	 * 1.创建一个ThreadLocal对象，与当前线程为key
	 * 2.从c3p0-config.xml中读取数据库配置，生成c3p0数据源
	 * 3.返回数据对象
	 * 4.获取c3p0数据库连接对象
	 * 
	 * 5.开启事物
	 * 	>获取连接
	 * 	>开启事物
	 * 
	 * 6.提交事物
	 * 	>得到连接
	 * 	>提交事物
	 * 
	 * 7.事务回滚
	 * 	>得到连接
	 * 	>关闭事物
	 * 	>从集合中移除当前绑定的连接
	 */
	private static ThreadLocal<Connection> threadLocal = 
			new ThreadLocal<Connection>();
	
	//从配置中读取c3p0数据源
	private static DataSource ds = new ComboPooledDataSource("kun");
	
	//返回数据源对象
	public static DataSource getDataSource(){
		return ds;
	}
	
	//获取c3p0数据库连接池连接对象
	public static Connection getConnection() throws SQLException{
		Connection conn = threadLocal.get();
		if(conn == null){
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	//开启事务
	public static void commit(){
		Connection conn = threadLocal.get();
		//提交事物
		if(conn != null){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//事物回滚
	public static void rollback(){
		Connection conn = threadLocal.get();
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//从集合中移除当前绑定的连接
				threadLocal.remove();
				conn = null;
			}
		}
	}
	
}
