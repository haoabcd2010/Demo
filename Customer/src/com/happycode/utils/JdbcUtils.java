package com.happycode.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * JdbcUtils小工具
 * V5.0
 * 需要MysqlConnector.jar, c3p9.jar, mcchange.jar
 * 提交事务,并且还要能让Service层可以控制事务
 * 5.0新特性，支持多线程同时访问，因为事务con开启了ThreadLocal
 */
public class JdbcUtils {
	// 配置文件的默认配置，要求必须给出c3p0-config.xml
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	 //事务的专用连接
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/*
	 * 从数据库连接池获取Connection
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con != null) return con;
		return dataSource.getConnection();
	}
	
	/*
	 * 获取连接池对象
	 */
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	/*
	* 开始事务
	* 关闭自动提交
	*/
	public static void beginTranSanction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			tl.set(con);
		} else {
			throw new RuntimeException("已经开启了事务！不要重复开启！");
		}
	}
	
	/*
	 * 提交事务
	 */
	public static void commitTranSanction() throws SQLException {
		Connection con = tl.get();
		if (con == null) throw new SQLException("未开启事务，无法提交！");
		con.commit();
		con.close();
		tl.remove();
	}
	
	/*
	 * 回滚事务
	 */
	public static void rollbackTranSanction() throws SQLException {
		Connection con = tl.get();
		if (con == null) throw new SQLException("未开启事务,不能回滚！");
		con.rollback();
		con.close();
		tl.remove();
	}
	
	/*
	 * 释放连接，但如果是事务连接，并不关闭，事务连接由上面的专门的事务操作的方法去关闭
	 * 虽然con.close()是返还给连接池Connection，并不是关闭，为了便于形容才说关闭
	 */
	public static void releaseConnetion(Connection connection) throws SQLException {
		Connection con = tl.get();
		if (connection == con) return;
		if (connection != null) {
			connection.close();
		}
	}
}
