package lec0203.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/// Prepared Statement
// hardcoding된 value를 파라미터화 
public class Test2 {
	
//	MySQL의 JDBC Driver 포함 jar 파일이 준비되어 있다. 
//	 -> java.sql 패키지에 있는 Connection, Statement, PreparedStatement, ResultSet Interface 만 보고 DB 연동 작업을 수행
//	 -> insert, delete, update, select와 같은 DB 연동 작업을 실제로 수행하는 코드는 jar에 interface를 구현한 코드가 수행
	
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/ssafy_user";
		String user = "root";
		String pwd = "1234";
		

		String selectSql = "select writername, min(createtime) createtime, count(*) as '개수' \r\n"
				+ "from (\r\n"
				+ "	select  writername, createtime \r\n"
				+ "	from board \r\n"
				+ "	group by writername, createtime\r\n"
				+ "	having  createtime > ? \r\n"
				+ ")as t\r\n"
				+ "group by writername;\r\n"
				+ "\r\n"
				+ "";
		// '2017-01-01 00:00:00'
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;
		
		
		// select
		try {
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, "2017-01-01 00:00:00");
			rs = pstmt.executeQuery();		
			System.out.println(ret);
			while(rs.next()) {
			// 각 row 별로 col 한개씩 추출 
			System.out.println(rs.getString("writername") + " / "+ rs.getString("createtime")+ " / "+rs.getInt("개수")); 
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
