package lec0125.exception.custom;

// 비즈니스 로직 구현 
public class Service {
	public int addEmpVocation(EmpDto dto, int days)throws EmpException {
		// 휴가 업무와 관련된 로직을 점검 <= 5일 초과 X
		if(days>5) {
			throw new EmpException("ERR_02","휴가 일수는 5일을 초과할 수 없음");
		}
		Dao dao = new Dao();
		return dao.addEmpVocation(dto, days);
	}
}
