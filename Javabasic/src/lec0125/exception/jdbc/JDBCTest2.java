package lec0125.exception.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// 여러개의 예외처리코드가 동일하면 하나로 합칠 수 있음
public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/test?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul","root","1234");
	
		    stmt = con.createStatement();
		    rs = stmt.executeQuery("select student_id, student_nm, major, phone from student ");
		    while(rs.next()) {
		        int studentId = rs.getInt("student_id");
		        String studentNm = rs.getString("student_nm");
		        String major = rs.getString("major");
		        String phone = rs.getString("phone");
		        System.out.println(studentId + " / " + studentNm + " / " + major + " / " + phone );
		    }
		}catch(ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}finally{ // 자원 반납 
			try {
				rs.close(); 
			    stmt.close();
			    con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	}
}
