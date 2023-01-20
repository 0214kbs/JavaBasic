package lec0120.inter;

public class Test {
	public static void main(String[] args) {
		/* 일반적으로 사용 -> error
		{
			Animal bird = new Bird();
	//		bird.howToFly(); //error
			
			
			Transportation airplane = new Airplane();
	//		airplane.howToFly();  // e.m. : The method howToFly() is undefined for the type Transportation
		}
		*/
		
		/*interface 
		{
			Fly bird = new Bird();
			bird.howFastFly();
			
			Fly airplane = new Airplane();
			airplane.howToFly();
			
//			bird.eat(); // e.m. : The method howToFly() is undefined for the type Transportation
		}
		*/
		
		// 보통 이렇게 많이 쓰임 
		{
			// Bird도 모르고 Airplane도 모르는 상태
			Fly obj = getInstance(); // 넘겨줌 
			obj.howFastFly();
			obj.howToFly();
		}
	}
	
	// 다른 팀에서 작성, 배포 
	static Fly getInstance() {
//		return new Airplane();
		return new Bird();
	}
}
