package lec0125.exception.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// AutoClosable 객체는 try-resource block
public class JDBCTest3 {
	public static void main(String[] args) throws Exception {
		try (
			Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/test?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul","root","1234");
	
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select student_id, student_nm, major, phone from student ");
	    ){
			Class.forName("com.mysql.cj.jdbc.Driver");
			while(rs.next()) {
		        int studentId = rs.getInt("student_id");
		        String studentNm = rs.getString("student_nm");
		        String major = rs.getString("major");
		        String phone = rs.getString("phone");
		        System.out.println(studentId + " / " + studentNm + " / " + major + " / " + phone );
			
		}
		}catch(ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}finally{ // 자동 자원 반납 
			// 자원 반납 외에 후처리가 필요하면 finally 사용하고 없으면 생략 가능 
		}

	}
}
