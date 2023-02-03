package lec0203.team.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String pwd = "1234";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void releaseConnection(PreparedStatement pstmt, Connection con) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!= null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void releaseConnection(ResultSet rs,PreparedStatement pstmt, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!= null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void releaseConnection(AutoCloseable... params) {
		for(AutoCloseable ac : params) {
			if(ac!= null) {
				try {
					ac.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
