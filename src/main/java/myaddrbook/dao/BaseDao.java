package myaddrbook.dao;

import myaddrbook.util.ReaderDbConfigUtil;

import java.sql.*;

/**
 * 数据访问层基础数据访问类
 * @author Think
 *
 */
public class BaseDao {
	private static final String URL= ReaderDbConfigUtil.getValue("URL");
	private static final String USER= ReaderDbConfigUtil.getValue("USER");
	private static final String PASSWORD= ReaderDbConfigUtil.getValue("PASSWORD");
	protected Connection conn;
	protected PreparedStatement preStmt = null;
	protected ResultSet rs = null;
	
	/**
	 * 获取连接方法
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		return conn;
	}
	/**
	 * 创建预编译的语句集对象
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PreparedStatement createPreStmt(String sql) throws ClassNotFoundException, SQLException {
		try {
			preStmt = getConn().prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		return preStmt;
	}
	
	/**
	 * 释放数据库连接相关对象
	 * @throws SQLException 
	 */
	public void close() throws SQLException {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(preStmt!=null) {
				preStmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			rs = null;
			preStmt =null;
			conn = null;
		}
	}
}













