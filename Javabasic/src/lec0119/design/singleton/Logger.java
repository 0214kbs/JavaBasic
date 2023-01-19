package lec0119.design.singleton;

import java.time.LocalDateTime;

// Logger의 객체가 프로그램에서 단 한개만 만들어지도록 강제 
public class Logger {
	
	static{
		Logger = new Logger();// 단점 1의 해결방안 2
	}
	private static Logger Logger;
//	private static Logger Logger = new Logger(); //단점 1의 해결방안1
	
	/* # Singleton
	 * 1. 생성자를 private
	 * 2. 외부에서 Logger 객체를 가져올 수 있는 method 제공
	 * 		- static method
	 * 		- return type : 자기 자신
	 * 3. 자기자신 타입의 변수와 객체
	 * 		- static Logger type member로, private
	 */
	
	private Logger() {} // 1. 
	public static Logger getInstance() {	//2
		// 3
//		if(Logger == null)	Logger = new Logger();
		// 단점1 : 호출 될때마다 Logger가 null인지 아닌지 확인한다는 것 
		return Logger; 
	}
	
	public void log(String message) {
		// Test에서 logger와 logger2가 같은지 확인
		System.out.println(this); // 출력값 동일(같음)
		
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.getYear()+"/"+ldt.getMonthValue() +"/"+ldt.getDayOfMonth();
		String time = ldt.getHour()+":"+ldt.getMinute() +":"+ldt.getSecond();
		
		System.out.println("["+date+" "+time+"] "+message);
		
		// 모든 개발자 코드가 공유하는 상황 고려
		
	}
}
