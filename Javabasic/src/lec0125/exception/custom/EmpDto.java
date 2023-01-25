package lec0125.exception.custom;

public class EmpDto {
	private String empNo;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public EmpDto() {};
	public EmpDto(String empNo) {
		super();
		this.empNo = empNo;
	}
	
}
