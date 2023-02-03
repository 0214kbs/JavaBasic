package lec0203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "1234";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int ret = -1;
		
		boolean isSuccess = true;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			// transaction 작업 수행 
			con.setAutoCommit(false);
			m1(stmt);
			m2(stmt);
			m3(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
			isSuccess = false;
		}finally {
			try {
				if(isSuccess) con.commit();
				else con.rollback();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//아래 메소드는 서로 다른 dao의 메소드다 라고 가정 
	static void m1(Statement stmt) throws SQLException{
		String insertSql1 = "insert into customer values(11,'11길동');";
		int ret = stmt.executeUpdate(insertSql1);
		System.out.println(ret);
	}
	static void m2(Statement stmt) throws SQLException{
		String insertSql2 = "insert into customer values(22,'22길동');";
		int ret = stmt.executeUpdate(insertSql2);
		System.out.println(ret);
	}
	static void m3(Statement stmt) throws SQLException{
		String insertSql3 = "insert into customer values(33,'33길동');";
		int ret = stmt.executeUpdate(insertSql3);
		System.out.println(ret);
	}
}
