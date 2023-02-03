package lec0203.jdbc.dao;

import java.util.List;

import lec0203.jdbc.dto.CustomerDto;

public interface CustomerDao {
	int insertCustomer(CustomerDto customerDto);
	int updateCustomer(CustomerDto customerDto);	
	int deleteCustomer(int customerId);
	List<CustomerDto> selectCustomer();	 // 목록
	
	CustomerDto selectCustomerDetail(int customerId); // key를 통한 1건 
	
}
