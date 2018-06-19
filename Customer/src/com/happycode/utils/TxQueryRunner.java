package com.happycode.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TxQueryRunner extends QueryRunner{

	public TxQueryRunner() {
		super();
	}

	public TxQueryRunner(boolean pmdKnownBroken) {
		super(pmdKnownBroken);
	}

	public TxQueryRunner(DataSource ds, boolean pmdKnownBroken) {
		super(ds, pmdKnownBroken);
	}

	public TxQueryRunner(DataSource ds) {
		super(ds);
	}

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 得到连接
		 * 调用父类方法
		 * 关闭连接
		 * 返回值
		 */
		Connection con = JdbcUtils.getConnection();
		int[] ret = super.batch(con, sql, params);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T ret = super.insert(con, sql, rsh, params);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T ret = super.insert(con, sql, rsh);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T ret = super.query(con, sql, rsh, params);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T ret = super.query(con, sql, rsh);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int ret = super.update(con, sql, params);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int ret = super.update(con, sql, param);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int ret = super.update(con, sql);
		JdbcUtils.releaseConnetion(con);
		return ret;
	}
	
}
