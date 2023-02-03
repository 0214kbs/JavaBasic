package lec0203.jdbc.dto;

public class CustomerDto {
	private int customerId;
	private String customerNm;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerNm() {
		return customerNm;
	}
	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}
	
	public CustomerDto() {
	}
	public CustomerDto(int customerId, String customerNm) {
		super();
		this.customerId = customerId;
		this.customerNm = customerNm;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", customerNm=" + customerNm + "]";
	}
	
	
}
