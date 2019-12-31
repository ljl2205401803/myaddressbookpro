package myaddrbook.dao;

import myaddrbook.util.ReaderDbConfigUtil;

import java.sql.*;

/**
 * ���ݷ��ʲ�������ݷ�����
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
	 * ��ȡ���ӷ���
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
	 * ����Ԥ�������伯����
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
	 * �ͷ����ݿ�������ض���
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













