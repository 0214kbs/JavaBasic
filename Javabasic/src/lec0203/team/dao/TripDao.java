package lec0203.team.dao;

import java.util.List;

import lec0203.team.dto.TripDto;

public interface TripDao {
	int insertTrip(TripDto tripDto);
	int updateTrip(TripDto tripDto);	
	int deleteTrip(String name);
	List<TripDto> selectTrip();	 // 목록
	
	TripDto selectTripDetail(String name); // key를 통한 1건 
	
}
