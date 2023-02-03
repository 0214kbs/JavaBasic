package lec0203.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lec0203.jdbc.common.DBManager;
import lec0203.jdbc.dto.CustomerDto;


// SQL 수행
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int insertCustomer(CustomerDto customerDto) {
		String insertSql = "insert into customer values(?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, 11); // (parameterIndex , 해당 위치 값)
			pstmt.setString(2,"11길동");
			ret = pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);		
		}
		return ret;
	}

	@Override
	public int updateCustomer(CustomerDto customerDto) {
		String updateSql = "update customer set customer_nm =? where customer_id = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1,"11길동2");
			pstmt.setInt(2, 11);
			ret = pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);		
			
		}
	    return ret;
	}

	@Override
	public int deleteCustomer(int customerId) {
		String deleteSql = "DELETE FROM customer WHERE customer_id = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, 11);
			ret = pstmt.executeUpdate();		
			System.out.println(ret);		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);		
		}
	    return ret;
	}

	@Override
	public List<CustomerDto> selectCustomer() {
		String selectSql = "select * from customer;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				// 각 row별로 col 한개씩 추출해서 CustomerDto 객체를 하나씩 만들고 list에 담는다. 
				int customerId = rs.getInt("customer_id");
				String customer_nm = rs.getString("customer_nm");
				CustomerDto customerDto = new CustomerDto(customerId, customer_nm);
				customerList.add(customerDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);		
			
		}
		
	    return customerList;
	}

	@Override
	public CustomerDto selectCustomerDetail(int customerId) {
		String selectDetailSql = "select * from customer where customer_id = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CustomerDto customerDto = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectDetailSql);
			pstmt.setInt(1,customerId);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				// 있으면 CustomerDto 객체를 하나 만들고 return 
				customerDto = new CustomerDto(rs.getInt("customer_id"),  rs.getString("customer_nm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);		
			
		}
	 return customerDto;
	}
}