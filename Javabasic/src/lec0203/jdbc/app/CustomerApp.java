package lec0203.jdbc.app;

import java.util.List;

import lec0203.jdbc.dao.CustomerDao;
import lec0203.jdbc.dao.CustomerDaoImpl;
import lec0203.jdbc.dto.CustomerDto;

public class CustomerApp {
	public static void main(String[] args) {
		//Client 또는 사용자 입력 customer 정보를 받았다는 가정
		int customerId = 11;
		String customerNm = "11길동";
		
		CustomerDto customerDto = new CustomerDto(customerId, customerNm);
		CustomerDao customerDao = new CustomerDaoImpl();
		
		// insert
//		int ret = customerDao.insertCustomer(customerDto);

		//update
//		customerDto.setCustomerNm("11길동2");
//		int ret = customerDao.updateCustomer(customerDto);
		
		//delete
//		int ret = customerDao.deleteCustomer(customerDto.getCustomerId());
//		System.out.println(ret);	
		
		//select
//		List<CustomerDto> customerList = customerDao.selectCustomer();
//		customerList.forEach((dto)-> System.out.println(dto));
		
		// selectDetail
		CustomerDto dto = customerDao.selectCustomerDetail(customerDto.getCustomerId());
		System.out.println(dto);
	}
}
