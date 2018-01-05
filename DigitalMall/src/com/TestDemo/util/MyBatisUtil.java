package com.TestDemo.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	/**
	 * 存储了配置文件,sqlSession创建的工厂
	 */
	private static SqlSessionFactory sf;
	private static ThreadLocal<SqlSession> tdl = new ThreadLocal<SqlSession>();
	static {
		try {
			// 1.获得配置文件的输入流
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			// 2.读取配置文件获得SqlSession工厂对象
			sf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			System.out.println("读配置文件异常!");
		}
	}

	/**
	 * 获得session对象
	 */
	public static SqlSession getCurrentSession() {
		SqlSession sqlSession = null;
		//从当前Thread中获得sqlsession
		sqlSession = tdl.get();
		if(sqlSession == null){
			//当前的thread中没有sqlSession
			sqlSession = sf.openSession();
			//存入当前thread
			tdl.set(sqlSession);
		}
		return sqlSession;
	}

	/**
	 * 关闭session对象
	 */
	public static void close(SqlSession sqlSession) {
		if (sqlSession != null){
			sqlSession.close();
			//移除当前thread中的sqlSession
			tdl.remove();
		}
	}
	
}
