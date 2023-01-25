package lec0125.exception.custom;
// client(웹의 frontend)

// controller : client가 보낸 데이터의 정확도 체크하고 Service 메소드 호출 
public class Controller {
	public int addEmpVocation(EmpDto dto, int days) throws EmpException{
		if(dto==null|| dto.getEmpNo()==null) {
			throw new EmpException("ERR_01","전달된 사원정보가 없음");
		}
		
		Service service = new Service();
		return service.addEmpVocation(dto, days);
	}
}
