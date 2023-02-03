package lec0203.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
//	MySQL의 JDBC Driver 포함 jar 파일이 준비되어 있다. 
//	 -> java.sql 패키지에 있는 Connection, Statement, PreparedStatement, ResultSet Interface 만 보고 DB 연동 작업을 수행
//	 -> insert, delete, update, select와 같은 DB 연동 작업을 실제로 수행하는 코드는 jar에 interface를 구현한 코드가 수행
	
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String url = "jdbc:mysql://localhost:3306/test";
		String url = "jdbc:mysql://localhost:3306/ssafydb";
		String user = "root";
		String pwd = "1234";
		
		/*
		// test schema
		String insertSql = "insert into customer values(11,'11길동')";
		String updateSql = "update customer set customer_nm = '11길동2' where customer_id = 11;";
		String deleteSql = "DELETE FROM customer WHERE customer_id = 11;";
		String selectSql = "select * from customer;";
		*/
		
//		/* 
		//ssafydb schema
		String selectSql = "select * from countries";
		String insertSql = "insert into countries values('KO','Corea',3);";
		String updateSql = "update customer set country_name = 'Korea' where country_id = 'KO';";
		String deleteSql = "DELETE FROM countries WHERE country_id = 'KO';";
//		*/
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int ret = -1;
		
		//insert
		/*
		try {
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			ret = stmt.executeUpdate(insertSql);		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}			
		}
		 */
		
		//update
//		/*
		try {
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			ret = stmt.executeUpdate(updateSql);		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
//		*/
		
		// delete
//		/*
		try {
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			ret = stmt.executeUpdate(deleteSql);		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
//		*/
		
		// select
		/*
		try {
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectSql);		
			System.out.println(ret);
			while(rs.next()) {
			// 각 row 별로 col 한개씩 추출 
//			System.out.println(rs.getInt("customer_id") + " / "+ rs.getString("customer_nm")); 
			System.out.println(rs.getString("country_id")+" / "+ rs.getString("country_name"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/

	}
}
