package lec0125.exception;
// error : 절대 발생해서는 안되는 오류 <- 반드시 찾아서 해결해야 함 

public class ErrorTest {
	public static void main(String[] args) {
		m();
	}
	
	//StackOverflowError
	// main method에서 m()호출 -> m()에서는 또 m() (자기자신 호출) 하니까 무한 반복
	static void m() {
		m();
	}
	
}
