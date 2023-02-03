package lec0203.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lec0203.jdbc.common.DBManager;
import lec0203.jdbc.dto.CustomerDto;
import lec0203.team.dto.TripDto;

// SQL 수행
public class TripDaoImpl implements TripDao {

	@Override
	public int insertTrip(TripDto tripDto) {
		String insertSql = "insert into 전국관광지정보표준데이터(관광지명, 소재지도로명주소) values(?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, tripDto.getTouristDestination() ); // (parameterIndex , 해당 위치 값)
			pstmt.setString(2,tripDto.getStreetAddress());
			ret = pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);		
		}
		return ret;
	}

	@Override
	public int updateTrip(TripDto tripDto) {
		String updateSql ="update 전국관광지정보표준데이터 set 소재지도로명주소 =? where 관광지명= ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1,tripDto.getStreetAddress());
			pstmt.setString(2, tripDto.getTouristDestination() ); // (parameterIndex , 해당 위치 값)
			ret = pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);		
		}
		return ret;
	}

	@Override
	public int deleteTrip(String name) {
		String deleteSql = "DELETE FROM 전국관광지정보표준데이터 WHERE 관광지명 = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setString(1, "송정삼정그린코아더시티");
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
	public List<TripDto> selectTrip() {
		String selectSql = "select * from 전국관광지정보표준데이터;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TripDto> tripList = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				// 각 row별로 col 한개씩 추출해서 CustomerDto 객체를 하나씩 만들고 list에 담는다. 
				String tripNm = rs.getString("관광지명");
				String tripAddr = rs.getString("소재지도로명주소");
				
				TripDto tripDto = new TripDto(tripNm, tripAddr, rs.getString("소재지지번주소"), rs.getDouble("위도"), rs.getDouble("경도"),rs.getString("관광지소개"));
				tripList.add(tripDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);		
			
		}
		
	    return tripList;
	}

	@Override
	public TripDto selectTripDetail(String name) {
		String selectDetailSql = "select * from 전국관광지정보표준데이터 where 관광지명 = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		TripDto tripDto = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectDetailSql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				// 각 row별로 col 한개씩 추출해서 CustomerDto 객체를 하나씩 만들고 list에 담는다. 
				tripDto = new TripDto(rs.getString("관광지명"),rs.getString("소재지도로명주소"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs, pstmt, con);		
			
		}
		
	    return tripDto;
	}

}