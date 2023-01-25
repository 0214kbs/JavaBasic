package lec0125.exception;

// RuntimeException 
public class ExceptionTest3 {
	
	public static void main(String[] args) {
		ControllerRunEx ec = new ControllerRunEx();
		try {
			ec.m();
		}/*catch(NullPointerException e) {
			System.out.println("catch");
		}*/finally {
			System.out.println("finally");
		}
	}
}

class ControllerRunEx{
	public void m() {
		// 실행시 NullPointerException 을 출력하지만, compiler가 오류라 체크하지는 않음
		String s = null;
		s.length();
	}
}