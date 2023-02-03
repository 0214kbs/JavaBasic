package lec0203.team.app;

import java.util.List;

import lec0203.team.dao.TripDao;
import lec0203.team.dao.TripDaoImpl;
import lec0203.team.dto.TripDto;

public class TripApp {
	public static void main(String[] args) {
		//Client 또는 사용자 입력 customer 정보를 받았다는 가정
		String des = "송정삼정그린코아더시티";
		String streetaddr = "부산광역시 강서구 삼정동 1627-5"; 
		
		TripDto tripDto = new TripDto(des, streetaddr);
		TripDao tripDao = new TripDaoImpl();
		
		// insert
//		int ret = tripDao.insertTrip(tripDto);
//		System.out.println(ret);	

		//update
//		tripDto.setStreetAddress("부산광역시 강서구 송정동 1627-5");	// 삼정동 -> 송정동
//		int ret = tripDao.updateTrip(tripDto);
//		System.out.println(ret);	
		
		//delete
//		int ret = tripDao.deleteTrip(tripDto.getTouristDestination());
//		System.out.println(ret);	
		
		//select
//		List<TripDto> tripList = tripDao.selectTrip();
//		tripList.forEach((dto)-> System.out.println(dto));
		
		// selectDetail
		TripDto dto = tripDao.selectTripDetail(des);
		System.out.println(dto);
	}
}
