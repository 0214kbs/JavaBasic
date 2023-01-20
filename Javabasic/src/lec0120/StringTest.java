package lec0120;
public class StringTest {
	
	public static void main(String[] args) {
		String str = "Hello, SSAFY";
		String newStr = str.replace('S','W');
		//String 클래스는 immutable하기 때문에 새롭게 String을 지정해주어야함
		
		System.out.println(str);
		System.out.println(newStr);
		
		
	}
	
}
