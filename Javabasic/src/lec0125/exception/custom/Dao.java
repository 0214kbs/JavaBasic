package lec0125.exception.custom;
// 자바 <-> DB 가상
public class Dao {
	public int addEmpVocation(EmpDto dto, int days) throws EmpException{
		// DB에 최종적인 데이터 등록 처리
		// DB 저장에 위배되는 데이터 검증 <= 사번(empNo는 emp 문자열로 시작해야함)
		if(!(dto.getEmpNo().indexOf("emp")==0)){
			throw new EmpException("ERR_03","사원의 사번이 올바르지 않음");
		}
		
		System.out.println("사원"+dto.getEmpNo()+"의 휴가를 등록함");
		return 1;
	}
}
