package lec0125.exception.custom;

public class Test {
	public static void main(String[] args) {
		Controller controller = new Controller();
		EmpDto dto = getEmpDto(); // 가상으로 클라이언트가 보내오는 데이터를 받는 메소드 
		
		// 발생되는 예외를 통해서 커스텀 예외의 exCode 값으로 상황을 파악, 처리 
		try {
//			controller.addEmpVocation(dto, 4);
			controller.addEmpVocation(dto, 6);
		}catch(EmpException e) {
			// 각각의 exCode에 맞는 구분 처리 구조가 필요함 
			if("ERR_01".equals(e.exCode)) {
				//로그
				// 사용자(화면을 보고있는)에게 연락/공지
				// 시스템 모니터링 담당자에게 연락 
				System.out.println(e.exCode+" : "+e.getMessage());
			}else if("ERR_02".equals(e.exCode)) {
				System.out.println(e.exCode+" : "+e.getMessage());
			}else if("ERR_03".equals(e.exCode)) {
				System.out.println(e.exCode+" : "+e.getMessage());
			}
		}
		System.out.println("Test : 사원 휴가정보 등록 완료");
	}
	
	static EmpDto getEmpDto(){
		// "ERR_01 : 전달된 사원정보가 없음" 출력 
//		return null; 
//		return new EmpDto(); 
		return new EmpDto("111");
	}
}
