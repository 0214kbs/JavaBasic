package lec0125.exception.custom;
// 사용자 정의 Exception
public class EmpException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmpException() {}
	public EmpException(String message) {
		super(message); // 부모 생성자 호출
	}	
	public EmpException(String exCode, String message) {
		super(message); // 부모 생성자 호출
		this.exCode = exCode;
	}
	// 사원 휴가 등 비즈니스 로직의 예외에 대해서 활용
	String exCode; //exception code
	// ERR_01 : 전달된 사원 정보가 없다. 
	// ERR_02 : 휴가 일수가 5일을 초과했다.
	// ERR_03 : 사원정보의 사원번호 오류 
	
	
}
