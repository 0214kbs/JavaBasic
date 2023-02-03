package lec0203.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/// Prepared Statement
// hardcoding된 value를 파라미터화 
public class Test {
	
//	MySQL의 JDBC Driver 포함 jar 파일이 준비되어 있다. 
//	 -> java.sql 패키지에 있는 Connection, Statement, PreparedStatement, ResultSet Interface 만 보고 DB 연동 작업을 수행
//	 -> insert, delete, update, select와 같은 DB 연동 작업을 실제로 수행하는 코드는 jar에 interface를 구현한 코드가 수행
	
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		String url = "jdbc:mysql://localhost:3306/test";
		String url = "jdbc:mysql://localhost:3306/ssafydb";
		String user = "root";
		String pwd = "1234";
		
		// test schema
		String insertSql = "insert into customer values(?,?);";
		String updateSql = "update customer set customer_nm =? where customer_id = ?;";
		String deleteSql = "DELETE FROM customer WHERE customer_id = ?;";
		String selectSql = "select * from customer WHERE customer_id = ?;";

		
		Connection con = null;
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		ResultSet rs = null;
		int ret = -1;
		
		//insert
		try {
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(insertSql);

			pstmt.setInt(1, 11); // (parameterIndex , 해당 위치 값)
			pstmt.setString(2,"11길동");
	
			ret = pstmt.executeUpdate();		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}			
		}

		
		//update
		try {
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1,"11길동2");
			pstmt.setInt(2, 11);
			ret = pstmt.executeUpdate();		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		
		// delete
		try {
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, 11);
			ret = pstmt.executeUpdate();		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		
		// select
		try {
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(selectSql);
//			pstmt.setInt(1, 11);
			rs = pstmt.executeQuery();		
			System.out.println(ret);
			while(rs.next()) {
			// 각 row 별로 col 한개씩 추출 
			System.out.println(rs.getInt("customer_id") + " / "+ rs.getString("customer_nm")); 
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}
}
